package br.com.argus.argus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.argus.argus.models.Curriculo;
import br.com.argus.argus.repositories.CurriculoRepository;

@Service
public class CurriculoService extends ServiceGeneric<Curriculo>{
	
	@Autowired
	CurriculoRepository curriculoRepository;

	@Override
	public JpaRepository<Curriculo, Long> getRepository() {
		return curriculoRepository;
	}

}
