package br.com.argus.argus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.argus.argus.exception.CodigoException;
import br.com.argus.argus.models.Disciplina;
import br.com.argus.argus.repositories.DisciplinaRepositories;

@Service
public class DisciplinaService extends ServiceGeneric<Disciplina> {

	@Autowired
	DisciplinaRepositories disciplinaRepositories;

	@Override
	public JpaRepository<Disciplina, Long> getRepository() {
		return disciplinaRepositories;
	}

	@Override
	@Transactional
	public Disciplina save(Disciplina disciplinaDto) {
		if (disciplinaRepositories.findByCodigo(disciplinaDto.getCodigo()) != null)
			throw new CodigoException("Código já está em uso");
		return super.save(disciplinaDto);
	}

	@Override
	@Transactional
	public Disciplina update(Long id, Disciplina disciplinaDto) {
		return findById(id).map(record -> {
			record.setCodigo(disciplinaDto.getCodigo());
			record.setNome(disciplinaDto.getNome());
			record.setCargaHoraria(disciplinaDto.getCargaHoraria());

			Disciplina disciplina = getRepository().save(record);
			return disciplina;
		}).orElse(null);
	}
}
