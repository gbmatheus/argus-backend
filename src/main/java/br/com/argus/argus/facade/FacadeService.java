package br.com.argus.argus.facade;

import java.util.List;
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
import br.com.argus.argus.services.UsuarioService;

@Service
public class FacadeService {

	@Autowired
	AlunoService alunoService;

	@Autowired
	FuncionarioService funcionarioService;
	
	@Autowired
	UsuarioService usuarioService;

	@Autowired
	DisciplinaService disciplinaService;

	@Autowired
	DisciplinaProfessorService dpService;

	@Autowired
	TurmaService turmaService;

	@Autowired
	CurriculoService curriculoService;
	
//	Métodos do aluno -----------------------------------------------------------
	
	public List<Aluno> indexAluno() {
		return alunoService.findByAll();
	}
	
	public Aluno createAluno(Aluno aluno) {
		return alunoService.save(aluno);
	}
	
	public Aluno updateAluno(Aluno aluno) {
		return alunoService.update(aluno);
	}
	
	public Aluno updateAluno(Long id, Aluno aluno) {
		return alunoService.update(id, aluno);
	}
	
	public Aluno showAluno(Long id) {
		return alunoService.findById(id).get();
	}
	
//	Métodos do funcionário -----------------------------------------------------
	public Funcionario createFuncionario(Funcionario funcionario) {
		return funcionarioService.save(funcionario);
	}
	
	public Funcionario updateFuncionario(Funcionario funcionario) {
		return funcionarioService.update(funcionario);
	}
	
	public Funcionario updateFuncionario(Long id, Funcionario funcionario) {
		return funcionarioService.update(id, funcionario);
	}
	
	public Funcionario showFuncionario(Long id) {
		return funcionarioService.findById(id).get();
	}
	
	public List<Funcionario> indexFuncionario() {
		return funcionarioService.findByAll();
	}
	
//	Métodos da disciplina -------------------------------------------------------
	public Disciplina createDisciplina(Disciplina disciplina) {
	    return disciplinaService.save(disciplina);
	}

	public Disciplina updateDisciplina(Disciplina disciplina) {
	    return disciplinaService.update(disciplina);
	}
	
	public Disciplina updateDisciplina(Long id, Disciplina disciplina) {
	    return disciplinaService.update(id, disciplina);
	}

	public Disciplina showDisciplina(Long id) {
	    return disciplinaService.findById(id).get();
	}

	public List<Disciplina> indexDisciplina() {
	    return disciplinaService.findByAll();
	}

//	Métodos da turma ------------------------------------------------------------
	public Turma createTurma(Turma turma) {
	    return turmaService.save(turma);
	}

	public Turma updateTurma(Turma turma) {
	    return turmaService.update(turma);
	}
	
	public Turma updateTurma(Long id, Turma turma) {
	    return turmaService.update(id, turma);
	}

	public Turma showTurma(Long id) {
	    return turmaService.findById(id).get();
	}

	public List<Turma> indexTurma() {
	    return turmaService.findByAll();
	}

	public List<Aluno> listAlunos(Long id) {
		return turmaService.findAlunos(id);
	}

//	 Realizar matricula do aluno na turma
	@Transactional
	public Turma matricular(Long turmaID, Aluno alunoDto) {
		return turmaService.maticular(turmaID, alunoDto);
	}
	
//	 Realizar matricula do aluno na turma
	@Transactional
	public Turma matricular(Long turmaID, Long alunoID) {
		return turmaService.maticular(turmaID, alunoID);
	}
	
	public List<Disciplina> listDisciplinas(Long id) {
		return null;
	}
	
//	Métodos do cúrriculo --------------------------------------------------------
 	public Curriculo createCurriculo(Curriculo curriculo) {
	    return curriculoService.save(curriculo);
	}

	public Curriculo updateCurriculo(Curriculo curriculo) {
	    return curriculoService.update(curriculo);
	}

	public Curriculo updateCurriculo(Long id, Curriculo curriculo) {
	    return curriculoService.update(id, curriculo);
	}

	public Curriculo showCurriculo(Long id) {
	    return curriculoService.findById(id).get();
	}

	public List<Curriculo> indexCurriculo() {
	    return curriculoService.findByAll();
	}


//	 Adicionar a disciplina e professor
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

//	 Adicionar disciplina ao turma
	@Transactional
	public Turma registrarDisciplina(Long turmaID, Long dpID) {
		Optional<DisciplinaProfessor> disciplinaProfessor = dpService.findById(dpID);
		Optional<Turma> turma = turmaService.findById(turmaID);

		disciplinaProfessor.get().getTurmas().add(turma.get());
		DisciplinaProfessor dp = dpService.save(disciplinaProfessor.get());

		turma.get().getDisciplinaProfessor().add(dp);

		return turmaService.update(turma.get());
	}

//	 Adicionar disciplina ao curriculo
	@Transactional
	public Curriculo addDisciplina(Long curriculoID, Long disciplinaID) {
		Optional<Curriculo> curriculo = curriculoService.findById(curriculoID);
		Optional<Disciplina> disciplina = disciplinaService.findById(disciplinaID);

		disciplina.get().getCurriculos().add(curriculo.get());
		curriculo.get().getDisciplinas().add(disciplinaService.update(disciplina.get()));

		return curriculoService.update(curriculo.get());
	}

//	 Adicionar turma ao curriculo
	@Transactional
	public Curriculo addTurma(Long curriculoID, Long turmaID) {
		Optional<Curriculo> curriculo = curriculoService.findById(curriculoID);
		Optional<Turma> turma = turmaService.findById(turmaID);
		
		turma.get().setCurriculo(curriculo.get());
//		Adicionando disciplinas na turma a partir das disciplinas no curriculo
//		for (Disciplina d : curriculo.get().getDisciplinas()) {
//			d.getTurmas().add(turma.get());
//			turma.get().getDisciplinas().add(disciplinaService.update(d));
//		}
		curriculo.get().getTurmas().add(turmaService.update(turma.get()));
		return curriculoService.update(curriculo.get());

	}

	
	
}
