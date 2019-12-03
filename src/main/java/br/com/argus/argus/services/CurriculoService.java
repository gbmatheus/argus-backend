package br.com.argus.argus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.argus.argus.exception.CodigoException;
import br.com.argus.argus.exception.ServicesException;
import br.com.argus.argus.models.Curriculo;
import br.com.argus.argus.models.Disciplina;
import br.com.argus.argus.models.Turma;
import br.com.argus.argus.repositories.CurriculoRepository;
import br.com.argus.argus.repositories.DisciplinaRepositories;

@Service
public class CurriculoService extends ServiceGeneric<Curriculo> {

	@Autowired
	DisciplinaRepositories disciplinaRepositories;

	@Autowired
	TurmaService turmaService;

	@Autowired
	CurriculoRepository curriculoRepository;

	@Override
	public JpaRepository<Curriculo, Long> getRepository() {
		return curriculoRepository;
	}

	@Override
	@Transactional
	public Curriculo save(Curriculo objetoDto) {
		if (curriculoRepository.findByCodigo(objetoDto.getCodigo()) != null)
			throw new CodigoException("Código já em uso");

		return super.save(objetoDto);
	}
	
	public List<Disciplina> listDisciplina(Long curriculoID) {
		return findById(curriculoID).get().getDisciplinas();
	}
	
	public List<Turma> listTurma(Long curriculoID){
		return findById(curriculoID).get().getTurmas();
	}

	@Transactional
	public Curriculo addDisciplina(Long curriculoID, Long disciplinaID) {
		Optional<Curriculo> curriculo = curriculoRepository.findById(curriculoID);
		Optional<Disciplina> disciplina = disciplinaRepositories.findById(disciplinaID);
		
		if (!curriculo.isPresent()) {
			throw new ServicesException("Curriculo não encontrado");
		}
		if (!disciplina.isPresent()) {
			throw new ServicesException("Disciplina não encontrada");
		}

		disciplina.get().getCurriculos().add(curriculo.get());
		Disciplina d = disciplinaRepositories.save(disciplina.get());

//		curriculo.get().getDisciplinas().add(disciplina.get());
		curriculo.get().getDisciplinas().add(d);
		
		return curriculoRepository.save(curriculo.get());
	}

	@Transactional
	public Curriculo addTurma(Long curriculoID, Turma turmaDto) {
		Optional<Curriculo> curriculo = curriculoRepository.findById(curriculoID);
		Turma turma = new Turma();

		if (!curriculo.isPresent()) {
			throw new ServicesException("Curriculo não encontrado");
		}

		turma.setAnoEscolar(turmaDto.getAnoEscolar());
		turma.setTurno(turmaDto.getTurno());
		turma.setDescricao(turmaDto.getDescricao());
		turma.setCurriculo(curriculo.get());
//		curriculo.get().getTurmas().add(turma);
		curriculo.get().getTurmas().add(turmaService.save(turma));

		return curriculoRepository.save(curriculo.get());
	}

}
