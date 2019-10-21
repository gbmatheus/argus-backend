package br.com.argus.argus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.argus.argus.models.Endereco;
import br.com.argus.argus.repositories.EnderecoRepository;

@Service
public class EnderecoService extends GenericService<Endereco>{
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	
	public Endereco save(Endereco enderecoDto) {
		Endereco endereco = new Endereco();
		
		for (Endereco e : findByAll()) {
			if(e.getRua().equalsIgnoreCase(enderecoDto.getRua())
					&& e.getBairro().equalsIgnoreCase(enderecoDto.getBairro())
					&& e.getCidade().equalsIgnoreCase(enderecoDto.getCidade())
					&& e.getUf().equalsIgnoreCase(enderecoDto.getUf())
					&& e.getCep().equalsIgnoreCase(e.getCep())
					) {
				endereco = e;
				endereco.setNumero(e.getNumero());
				return enderecoRepository.save(endereco);
				
			}else if(e.getRua().equalsIgnoreCase(enderecoDto.getRua())
					&& e.getNumero() == enderecoDto.getNumero()
					&& e.getBairro().equalsIgnoreCase(enderecoDto.getBairro())
					&& e.getCidade().equalsIgnoreCase(enderecoDto.getCidade())
					&& e.getUf().equalsIgnoreCase(enderecoDto.getUf())
					&& e.getCep().equalsIgnoreCase(e.getCep())
					){
				System.out.println("Endereco id "+e.getId());
				return e;
			}
		}
		
		endereco.setRua(enderecoDto.getRua());
		endereco.setNumero(enderecoDto.getNumero());
		endereco.setBairro(enderecoDto.getBairro());
		endereco.setCidade(enderecoDto.getCidade());
		endereco.setUf(enderecoDto.getUf());
		endereco.setCep(enderecoDto.getCep());
		
		return enderecoRepository.save(endereco);
	}

	@Override
	public Optional<Endereco> findById(long id) {
		return enderecoRepository.findById(id);
	}

	@Override
	public Endereco findBy(long id) {
//		return enderecoRepository.findOne(id);
		return null;
	}

	@Override
	public List<Endereco> findByAll() {
		return enderecoRepository.findAll();
	}


	@Override
	public Endereco update(long id, Endereco enderecoDto) {
		return findById(id)
				.map(record-> {
					record.setRua(enderecoDto.getRua());
					record.setNumero(enderecoDto.getNumero());
					record.setBairro(enderecoDto.getBairro());
					record.setCidade(enderecoDto.getCidade());
					record.setUf(enderecoDto.getUf());
					record.setCep(enderecoDto.getCep());
					
					Endereco endereco = enderecoRepository.save(record);
					return endereco;
				}).orElse(null);
	}

	@Override
	public void deleteById(long id) {
		
	}

	@Override
	public void remove(long id) {
		
	}

}
