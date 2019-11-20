package br.com.argus.argus.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.argus.argus.models.Aluno;
import br.com.argus.argus.models.Turma;
import br.com.argus.argus.repositories.TurmaRepository;

@Service
public class TurmaService extends ServiceGeneric<Turma> {
	
	@Autowired
	AlunoService alunoService;
	

	@Autowired
	FuncionarioService professorService;
	
	@Autowired
	DisciplinaService disciplinaService;
	
	@Autowired
	TurmaRepository turmaRepository;
	
	@Override
	public JpaRepository<Turma, Long> getRepository() {
		return turmaRepository;
	}
	
	@Override
	@Transactional
	public Turma save(Turma objetoDto) {
		return super.save(objetoDto);
	}
	
	@Transactional
	public Turma update(Turma objetoDto) {
		return turmaRepository.save(objetoDto);
	}
		
	public Turma maticular(Long turmaID, Long alunoID) {
		Optional<Turma> turma = turmaRepository.findById(turmaID);
		Optional<Aluno> aluno = alunoService.findById(alunoID);
		
		aluno.get().setTurma(turma.get());
		turma.get().getAlunos().add(aluno.get());
		
		return turmaRepository.save(turma.get());
	}
	
}
