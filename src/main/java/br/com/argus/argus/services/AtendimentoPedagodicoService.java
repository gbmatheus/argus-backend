package br.com.argus.argus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.argus.argus.models.AtendimentoPedagogico;
import br.com.argus.argus.repositories.AtendimentoPedagogicoRepository;

@Service
public class AtendimentoPedagodicoService extends ServiceGeneric<AtendimentoPedagogico> {

	@Autowired
	AtendimentoPedagogicoRepository atendimentoRepository;

	@Override
	public JpaRepository<AtendimentoPedagogico, Long> getRepository() {
		return atendimentoRepository;
	}

}
