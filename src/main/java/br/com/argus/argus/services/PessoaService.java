package br.com.argus.argus.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.argus.argus.dtos.PessoaDto;
import br.com.argus.argus.models.Pessoa;
import br.com.argus.argus.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	EnderecoService enderecoService;

	@Autowired
	PessoaRepository pessoaRepository;

	public Pessoa save(PessoaDto pessoaDto) {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(pessoaDto.getNome());
		pessoa.setDataNascimento(pessoaDto.getDataNascimento());
		pessoa.setNaturalidade(pessoaDto.getNaturalidade());

		pessoa.setEndereco(
				enderecoService.save(pessoaDto.getEndereco())
				);

		return pessoaRepository.save(pessoa);
	}

	public Pessoa findById(long id) {
		return null;
	}

	public List<Pessoa> findByAll() {
		return null;
	}

	public Pessoa update(Pessoa pessoa) {
		return null;
	}

	public void delete(long id) {

	}
}
