package br.com.argus.argus.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.argus.argus.models.Aluno;
import br.com.argus.argus.models.Matricula;
import br.com.argus.argus.models.Turma;
import br.com.argus.argus.repositories.MatriculaRepository;

@Service
public class MatriculaService extends ServiceGeneric<Matricula> {

	@Autowired
	PessoaService pessoaService;

	@Autowired
	AlunoService alunoService;

	@Autowired
	FuncionarioService funcionarioService;

	@Autowired
	TurmaService turmaService;

	@Autowired
	MatriculaRepository matriculaRepository;

	@Override
	public JpaRepository<Matricula, Long> getRepository() {
		return matriculaRepository;
	}

	@Override
	public Matricula save(Matricula objetoDto) {
		return super.save(objetoDto);
	}

	public Matricula registerMatricula(Long turmaID, Long alunoID) {
		Matricula matricula = new Matricula();
		Optional<Aluno> aluno = alunoService.findById(alunoID);
//		Optional<Funcionario> professor = funcionarioService.findById(professorID);
		Optional<Turma> turma = turmaService.findById(turmaID);

		matricula.setAluno(aluno.get());
		aluno.get().getMatriculas().add(matricula);

//		matricula.setProfessor(professor.get());
//		professor.get().getMatriculas().add(matricula);

		matricula.setTurma(turma.get());
		turma.get().getMatriculas().add(matricula);

		return matricula;

	}

}
