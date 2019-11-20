package br.com.argus.argus.facade;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.argus.argus.enums.Tipo;
import br.com.argus.argus.exception.BadRequestException;
import br.com.argus.argus.models.Aluno;
import br.com.argus.argus.models.Curriculo;
import br.com.argus.argus.models.Disciplina;
import br.com.argus.argus.models.DisciplinaProfessor;
import br.com.argus.argus.models.Funcionario;
import br.com.argus.argus.models.Turma;
import br.com.argus.argus.services.AlunoService;
import br.com.argus.argus.services.CurriculoService;
import br.com.argus.argus.services.DisciplinaProfessorService;
import br.com.argus.argus.services.DisciplinaService;
import br.com.argus.argus.services.FuncionarioService;
import br.com.argus.argus.services.TurmaService;

@Service
public class FacadeService {

	@Autowired
	AlunoService alunoService;

	@Autowired
	FuncionarioService funcionarioService;

	@Autowired
	DisciplinaService disciplinaService;

	@Autowired
	DisciplinaProfessorService dpService;

	@Autowired
	TurmaService turmaService;

	@Autowired
	CurriculoService curriculoService;

	// Realizar matricula do aluno na turma
	@Transactional
	public Turma matricular(Long turmaID, Long alunoID) {
		Optional<Turma> turma = turmaService.findById(turmaID);
		Optional<Aluno> aluno = alunoService.findById(alunoID);

		aluno.get().setTurma(turma.get());

		turma.get().getAlunos().add(alunoService.save(aluno.get()));

		return turmaService.update(turma.get());
	}

	// Adicionar a disciplina e professor
	@Transactional
	public DisciplinaProfessor ministrada(Long disciplinaID, Long professorID) {
		DisciplinaProfessor registro = new DisciplinaProfessor();
		Optional<Disciplina> disciplina = disciplinaService.findById(disciplinaID);
		Optional<Funcionario> professor = funcionarioService.findById(professorID);

		if (professor.get().getUsuario().getTipo() != Tipo.PRO)
			throw new BadRequestException("Esse funcionário não é um professor");

		registro.setDisciplina(disciplina.get());
		registro.setProfessor(professor.get());
		disciplina.get().getRegistro().add(registro);
		professor.get().getRegistro().add(registro);

		return dpService.save(registro);
	}

	// Adicionar à turma
	@Transactional
	public Turma registrarDisciplina(Long turmaID, Long dpID) {
		Optional<DisciplinaProfessor> disciplinaProfessor = dpService.findById(dpID);
		Optional<Turma> turma = turmaService.findById(turmaID);

		disciplinaProfessor.get().getTurmas().add(turma.get());
		DisciplinaProfessor dp = dpService.save(disciplinaProfessor.get());

		turma.get().getDisciplinaProfessor().add(dp);

		return turmaService.update(turma.get());
	}

	// Adicionar disciplina ao curriculo
	@Transactional
	public Curriculo addDisciplina(Long curriculoID, Long disciplinaID) {
		Optional<Curriculo> curriculo = curriculoService.findById(curriculoID);
		Optional<Disciplina> disciplina = disciplinaService.findById(disciplinaID);

		disciplina.get().getCurriculos().add(curriculo.get());
		curriculo.get().getDisciplinas().add(disciplinaService.update(disciplina.get()));

		return curriculoService.update(curriculo.get());
	}

	// Adicionar turma ao curriculo
	@Transactional
	public Curriculo addTurma(Long curriculoID, Long turmaID) {
		Optional<Curriculo> curriculo = curriculoService.findById(curriculoID);
		Optional<Turma> turma = turmaService.findById(turmaID);

		turma.get().setCurriculo(curriculo.get());
		curriculo.get().getTurmas().add(turmaService.update(turma.get()));
		return curriculoService.update(curriculo.get());

	}

}
