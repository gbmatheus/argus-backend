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

	public Pessoa findRg(String rg) {
		Pessoa pessoa = pessoaRepository.findByRg(rg);
		if(pessoa == null) {
			System.out.println("Não existe");
		}
		
		return pessoa;
		
	}
	
	@Override
	@Transactional
	public Pessoa save(Pessoa objetoDto) {
		if (pessoaRepository.findByRg(objetoDto.getRg()) != null) {
			throw new PessoaException("RG já foi cadastrado");
		}
		return super.save(objetoDto);
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

			Pessoa pessoa = super.save(record);
			return pessoa;
		}).orElse(null);
	}

}
