package br.com.argus.argus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.argus.argus.exception.CpfException;
import br.com.argus.argus.models.Responsavel;
import br.com.argus.argus.repositories.ResponsavelRepository;

@Service
public class ResponsavelService extends ServiceGeneric<Responsavel> {

	@Autowired
	ResponsavelRepository responsavelRepository;

	@Override
	public JpaRepository<Responsavel, Long> getRepository() {
		return responsavelRepository;
	}

	@Override
	@Transactional
	public Responsavel save(Responsavel objetoDto) {
		if (responsavelRepository.findByCpf(objetoDto.getCpf()) != null) {
			throw new CpfException("CPF já cadastrado");
		}
		return super.save(objetoDto);
	}

}
