package br.com.argus.argus.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.argus.argus.exception.ServicesException;
import br.com.argus.argus.exception.ValidarColunaException;
import br.com.argus.argus.models.Pessoa;
import br.com.argus.argus.repositories.PessoaRepository;

@Service
public class PessoaService extends GenericService<Pessoa> {

	@Autowired
	EnderecoService enderecoService;

	@Autowired
	PessoaRepository pessoaRepository;

	public Pessoa save(Pessoa pessoaDto) throws EntityExistsException, ValidarColunaException {
		List<Pessoa> pessoas = findByAll();
		Pessoa pessoa = new Pessoa();

//		if (!pessoaDto.getRg().matches("^[0-9]*$"))
//			throw new ValidarColunaException("Rg inválido");

		if (pessoas.size() != 0) {
			for (Pessoa p : pessoas) {
				if (p.getNome().equalsIgnoreCase(pessoaDto.getNome())
						&& p.getNaturalidade().equalsIgnoreCase(p.getNaturalidade())
						&& p.getRg().equalsIgnoreCase(pessoaDto.getRg())
						&& p.getDataNascimento().getTime() == pessoaDto.getDataNascimento().getTime()
						&& p.getEndereco().equals(pessoaDto.getEndereco()))
					return p;

				else if (p.getRg().equalsIgnoreCase(pessoaDto.getRg())) {
					throw new EntityExistsException("Já existe uma pessoa com esse rg");
				}
			}
		}

		pessoa.setNome(pessoaDto.getNome());
		pessoa.setDataNascimento(pessoaDto.getDataNascimento());
		pessoa.setNaturalidade(pessoaDto.getNaturalidade());
		pessoa.setRg(pessoaDto.getRg());

		pessoa.setEndereco(enderecoService.save(pessoaDto.getEndereco()));

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
		Pessoa pessoa = pessoaRepository.findOne(id);
		if (pessoa == null)
			throw new ServicesException("Usuário não está cadastrado");

		return pessoa;

	}

	@Override
	public Pessoa update(long id, Pessoa pessoaDto) {
		return findById(id).map(record -> {
			record.setNome(pessoaDto.getNome());
			record.setDataNascimento(pessoaDto.getDataNascimento());
			record.setNaturalidade(pessoaDto.getNaturalidade());
			record.setRg(pessoaDto.getRg());
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
		pessoaRepository.deleteById(id);
	}
}
