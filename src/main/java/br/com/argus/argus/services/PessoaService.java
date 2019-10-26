package br.com.argus.argus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		List<Pessoa> pessoas = findByAll();

		if (pessoas.size() != 0) {
			for (Pessoa p : pessoas) {
				if (p.getNome().equalsIgnoreCase(objetoDto.getNome())
						&& p.getNaturalidade().equalsIgnoreCase(objetoDto.getNaturalidade())
						&& p.getRg().equalsIgnoreCase(objetoDto.getRg())
						&& p.getDataNascimento().getTime() == objetoDto.getDataNascimento().getTime()
						&& p.getEndereco().equals(objetoDto.getEndereco()))
					return p;
				
				else if(p.getRg().equalsIgnoreCase(objetoDto.getRg()))
					return null;//retornar erro
			}
		}

		return super.save(objetoDto);
	}
	
	@Override
	@Transactional
	public Pessoa update(long id, Pessoa objetoDto) {
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


}
