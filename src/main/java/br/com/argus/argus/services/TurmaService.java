package br.com.argus.argus.services;

import java.util.List;
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

//	@Autowired
//	FuncionarioService professorService;
//
//	@Autowired
//	DisciplinaService disciplinaService;

	@Autowired
	TurmaRepository turmaRepository;

	@Override
	public JpaRepository<Turma, Long> getRepository() {
		return turmaRepository;
	}

	@Override
	@Transactional
	public Turma save(Turma turmaDto) {
		return super.save(turmaDto);
	}

	@Transactional
	public Turma update(Turma turmaDto) {
		return super.update(turmaDto);
	}

	@Override
	@Transactional
	public Turma update(Long id, Turma turmaDto) {
		return findById(id).map(record -> {
			record.setTurno(turmaDto.getTurno());
			record.setAnoEscolar(turmaDto.getTurno());
			record.setDescricao(turmaDto.getDescricao());

			Turma turma = getRepository().save(record);
			return turma;
		}).orElse(null);

	}

	public List<Aluno> findAlunos(Long id) {
		Optional<Turma> turma = findById(id);
//		if (!turma.isPresent()) {
//			throw new NotFoundException("Turma não encontrada");
//		}

		return turma.get().getAlunos();
	}

	@Transactional
	public Turma maticular(Long turmaID, Aluno alunoDto) {
		Optional<Turma> turma = findById(turmaID);
//		Alt-1
		alunoDto.setTurma(turma.get());
		Aluno aluno = alunoService.save(alunoDto);

		turma.get().getAlunos().add(aluno);
		return getRepository().save(turma.get());
	}

	@Transactional
	public Turma maticular(Long turmaID, Long alunoID) {
		Optional<Turma> turma = findById(turmaID);
		Optional<Aluno> aluno = alunoService.findById(alunoID);

		aluno.get().setTurma(turma.get());
		turma.get().getAlunos().add(aluno.get());

		return getRepository().save(turma.get());
	}

//	public List<Disciplina> findDisciplinas(Long id) {
//		Optional<Turma> turma = findById(id);
//		if(!turma.isPresent()) {
//			throw new NotFoundException("Turma não encontrada");
//		}
//		
//		return turma.get().getDisciplinaProfessor();
//	}
	
	public Turma registrar(Long turmaID, Long disciplinaID) {
		return null;
	}

}
