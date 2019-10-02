package br.com.argus.argus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.argus.argus.models.Endereco;
import br.com.argus.argus.models.Pessoa;
import br.com.argus.argus.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	EnderecoService enderecoService;
	
	public Pessoa save(Pessoa pessoaDto) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(pessoaDto.getNome());
		pessoa.setDataNascimento(pessoaDto.getDataNascimento());
		pessoa.setNaturalidade(pessoaDto.getNaturalidade());
		
		pessoa.setEndereco(
				enderecoService.save(
						pessoaDto.getEndereco()));
		System.out.println("Salvou enderenco ##################");
		return pessoaRepository.save(pessoa);
	}
	
	public Pessoa findById(long id) {
		return null;
	}
	
	public List<Pessoa> findByAll(){
		return null;
	}
	
	public Pessoa update(Pessoa pessoa) {
		return null;
	}
	
	public void delete(long id) {
		
	}
}
