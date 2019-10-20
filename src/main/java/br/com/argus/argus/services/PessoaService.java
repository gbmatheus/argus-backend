package br.com.argus.argus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.argus.argus.models.Endereco;
import br.com.argus.argus.models.Pessoa;
import br.com.argus.argus.repositories.PessoaRepository;

@Service
public class PessoaService extends GenericService<Pessoa> {

	@Autowired
	EnderecoService enderecoService;

	@Autowired
	PessoaRepository pessoaRepository;

	public Pessoa save(Pessoa pessoaDto) {

		for (Pessoa p : findByAll()) {
			if (p.getNome().equalsIgnoreCase(pessoaDto.getNome())
					&& p.getNaturalidade().equalsIgnoreCase(pessoaDto.getNaturalidade())
					&& p.getDataNascimento().getTime() == pessoaDto.getDataNascimento().getTime()) {
				System.out.println("Pessoa id " + p.getId());
				return p;
			}
		}

		Pessoa pessoa = new Pessoa();
		pessoa.setNome(pessoaDto.getNome());
		pessoa.setDataNascimento(pessoaDto.getDataNascimento());
		pessoa.setNaturalidade(pessoaDto.getNaturalidade());

		pessoa.setEndereco(enderecoService.save(pessoaDto.getEndereco()));

//		FacadeCreateService
//		pessoa.setEndereco(pessoaDto.getEndereco());

		return pessoaRepository.save(pessoa);
	}

	public Optional<Pessoa> findById(long id) {
		return pessoaRepository.findById(id);
	}

	public List<Pessoa> findByAll() {
		return pessoaRepository.findAll();
	}

	@Override
	public Pessoa findBy(long id) {
//		return pessoaRepository.findOne(id);
		return null;
	}

	@Override
	public Pessoa update(long id, Pessoa pessoaDto) {
		return findById(id).map(record -> {
			record.setNome(pessoaDto.getNome());
			record.setDataNascimento(pessoaDto.getDataNascimento());
			record.setNaturalidade(pessoaDto.getNaturalidade());
			record.setEndereco(pessoaDto.getEndereco());

			Pessoa pessoa = pessoaRepository.save(record);
			return pessoa;
		}).orElse(null);
	}

	@Override
	public void remove(long id) {
		findById(id).map(record -> {
			record.setAtivo(!record.isAtivo());
			return pessoaRepository.save(record);

		}).orElse(null);
	}

	@Override
	public void deleteById(long id) {

	}
}
