package br.com.argus.argus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.argus.argus.models.Disciplina;
import br.com.argus.argus.repositories.DisciplinaRepositories;

@Service
public class DisciplinaService extends ServiceGeneric<Disciplina>{

	@Autowired
	DisciplinaRepositories disciplinaRepositories;
	
	@Override
	public JpaRepository<Disciplina, Long> getRepository() {
		return disciplinaRepositories;
	}
}
