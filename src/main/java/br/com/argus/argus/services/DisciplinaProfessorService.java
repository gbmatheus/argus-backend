package br.com.argus.argus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.argus.argus.models.DisciplinaProfessor;
import br.com.argus.argus.repositories.DisplinaProfessorRepository;

@Service
public class DisciplinaProfessorService extends ServiceGeneric<DisciplinaProfessor> {

	@Autowired
	DisplinaProfessorRepository dpRepository;
	
	@Override
	public JpaRepository<DisciplinaProfessor, Long> getRepository() {
		return dpRepository;
	}
	
	

}
