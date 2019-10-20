package br.com.argus.argus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.argus.argus.models.Disciplina;
import br.com.argus.argus.repositories.DisciplinaRepositories;

public class DisciplinaService extends GenericService<Disciplina> {
		
	@Autowired
	DisciplinaRepositories disciplinaRepositories;

	@Override
	public Optional<Disciplina> findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Disciplina findBy(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Disciplina> findByAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Disciplina save(Disciplina obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Disciplina update(long id, Disciplina obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(long id) {
		// TODO Auto-generated method stub
		
	}
}
