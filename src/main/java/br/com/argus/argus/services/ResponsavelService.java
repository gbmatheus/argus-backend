package br.com.argus.argus.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.argus.argus.exception.ServicesException;
import br.com.argus.argus.exception.ValidarColunaException;
import br.com.argus.argus.models.Responsavel;
import br.com.argus.argus.repositories.ResponsavelRepository;

@Service
public class ResponsavelService extends GenericService<Responsavel> {

	@Autowired
	PessoaService pessoaService;

	@Autowired
	ResponsavelRepository responsavelRepository;

	@Override
	public Responsavel save(Responsavel responsavelDto) {
		System.out.println(responsavelDto.toString());

		Responsavel responsavel = new Responsavel();
		responsavel.setCpf(responsavelDto.getCpf());

		try {
			responsavel.setPessoa(pessoaService.save(responsavelDto.getPessoa()));
		} catch (EntityExistsException | ValidarColunaException e) {
			e.printStackTrace();
		}

		return responsavelRepository.save(responsavel);
	}

	@Override
	public Optional<Responsavel> findById(long id) {
		return responsavelRepository.findById(id);
	}

	@Override
	public Responsavel findBy(long id) {
		Responsavel responsavel = responsavelRepository.findOne(id);

		if (responsavel == null) {
			try {
				throw new ServicesException("Aluno não existe");
			} catch (ServicesException e) {
				e.printStackTrace();
			}
		}
		return responsavel;
	}

	@Override
	public List<Responsavel> findByAll() {
		return responsavelRepository.findAll();
	}

	@Override
	public void deleteById(long id) {
		responsavelRepository.deleteById(id);
	}

	@Override
	public Responsavel update(long id, Responsavel responsavelDto) {
		return findById(id).map(record -> {
			record.setCpf(responsavelDto.getCpf());
			record.setPessoa(responsavelDto.getPessoa());

			Responsavel responsavel = responsavelRepository.save(record);
			return responsavel;
		}).orElse(null);
	}

	@Override
	public void remove(long id) {
		Optional<Responsavel> r = findById(id);
		pessoaService.remove(r.get().getPessoa().getId());
	}

}
