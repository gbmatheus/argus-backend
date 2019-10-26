package br.com.argus.argus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.argus.argus.models.Endereco;
import br.com.argus.argus.repositories.EnderecoRepository;

@Service
public class EnderecoService extends ServiceGeneric<Endereco> {

	@Autowired
	EnderecoRepository enderecoRepository;

	@Override
	public JpaRepository<Endereco, Long> getRepository() {
		return enderecoRepository;
	}

	@Override
	@Transactional
	public Endereco save(Endereco objetoDto) {
		List<Endereco> enderecos = findByAll();

		if (enderecos.size() != 0) {
			for (Endereco e : enderecos) {
				if (e.getRua().equalsIgnoreCase(objetoDto.getRua())
						&& e.getBairro().equalsIgnoreCase(objetoDto.getBairro())
						&& e.getCidade().equalsIgnoreCase(objetoDto.getCidade())
						&& e.getUf().equalsIgnoreCase(objetoDto.getUf()) && e.getCep().equalsIgnoreCase(e.getCep())) {
					Endereco endereco = e;
					endereco.setNumero(e.getNumero());
					return super.save(e);
				} else if (e.getRua().equalsIgnoreCase(objetoDto.getRua()) && e.getNumero() == objetoDto.getNumero()
						&& e.getBairro().equalsIgnoreCase(objetoDto.getBairro())
						&& e.getCidade().equalsIgnoreCase(objetoDto.getCidade())
						&& e.getUf().equalsIgnoreCase(objetoDto.getUf()) && e.getCep().equalsIgnoreCase(e.getCep())
						&& e.getNumero() == e.getNumero()) {
					System.out.println("Endereco id " + e.getId());
					return e;
				}
			}
		}

		return super.save(objetoDto);
	}

	@Override
	@Transactional
	public Endereco update(long id, Endereco enderecoDto) {
		return findById(id).map(record -> {
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

}
