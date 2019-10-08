package br.com.argus.argus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.argus.argus.dtos.EnderecoDto;
import br.com.argus.argus.models.Endereco;
import br.com.argus.argus.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	public Endereco save(EnderecoDto enderecoDto) {
		Endereco endereco = new Endereco();
		endereco.setRua(enderecoDto.getRua());
		endereco.setNumero(enderecoDto.getNumero());
		endereco.setBairro(enderecoDto.getBairro());
		endereco.setCidade(enderecoDto.getCidade());
		endereco.setUf(enderecoDto.getUf());
		endereco.setCep(enderecoDto.getCep());
		
		return enderecoRepository.save(endereco);
	}

}
