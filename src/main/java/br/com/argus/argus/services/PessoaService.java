package br.com.argus.argus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.argus.argus.exception.PessoaException;
import br.com.argus.argus.models.Pessoa;
import br.com.argus.argus.repositories.PessoaRepository;

@Service
public class PessoaService extends ServiceGeneric<Pessoa> {

	@Autowired
	PessoaRepository pessoaRepository;

	@Override
	public JpaRepository<Pessoa, Long> getRepository() {
		return pessoaRepository;
	}

	@Override
	@Transactional
	public Pessoa save(Pessoa objetoDto) {
		if (pessoaRepository.findByRg(objetoDto.getRg()) != null) {
			throw new PessoaException("RG já foi cadastrado");
		}
		System.out.println("Salvou");
		return pessoaRepository.save(objetoDto);
	}

	@Override
	@Transactional
	public Pessoa update(Long id, Pessoa objetoDto) {
		return findById(id).map(record -> {
			record.setNome(objetoDto.getNome());
			record.setDataNascimento(objetoDto.getDataNascimento());
			record.setNaturalidade(objetoDto.getNaturalidade());
			record.setRg(objetoDto.getRg());
			record.setEndereco(objetoDto.getEndereco());

			Pessoa pessoa = pessoaRepository.save(record);
			return pessoa;
		}).orElse(null);
	}

	public Pessoa findByPessoa(Pessoa objetoDto) {
		Pessoa p = pessoaRepository.findByRg(objetoDto.getRg());
		if (!p.getNome().equalsIgnoreCase(objetoDto.getNome())) {
			System.out.println("Existe mas rg diferente");
			throw new PessoaException("RG já foi cadastrado");
		}
		return p;
	}

}
