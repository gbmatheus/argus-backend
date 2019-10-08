package br.com.argus.argus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.argus.argus.dtos.ResponsavelDto;
import br.com.argus.argus.models.Responsavel;
import br.com.argus.argus.repositories.ResposavelRepository;

@Service
public class ResponsavelService {
	
	@Autowired
	PessoaService pessoaService;
	@Autowired
	ResposavelRepository resposavelRepository;
	
	public Responsavel save(ResponsavelDto responsavelDto) {
		System.out.println(responsavelDto.toString());
		
		Responsavel responsavel = new Responsavel();
		responsavel.setCpf(responsavelDto.getCpf());
		responsavel.setPessoa(
				pessoaService.save(
						responsavelDto.getPessoa()
						)
				);
		
		return resposavelRepository.save(responsavel);
	}

}
