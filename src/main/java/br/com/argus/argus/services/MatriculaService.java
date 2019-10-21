package br.com.argus.argus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.argus.argus.models.Matricula;
import br.com.argus.argus.repositories.MatriculaRepository;

@Service
public class MatriculaService extends ServiceGeneric<Matricula> {

	@Autowired
	MatriculaRepository matriculaRepository;

	@Override
	public JpaRepository<Matricula, Long> getRepository() {
		return matriculaRepository;
	}

}
