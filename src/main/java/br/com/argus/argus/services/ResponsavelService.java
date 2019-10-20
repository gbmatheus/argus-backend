package br.com.argus.argus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.argus.argus.models.Responsavel;
import br.com.argus.argus.repositories.ResposavelRepository;

@Service
public class ResponsavelService extends GenericService<Responsavel>{
	
	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	ResposavelRepository resposavelRepository;
	

	@Override
	public Responsavel save(Responsavel responsavelDto) {
		System.out.println(responsavelDto.toString());
		
		Responsavel responsavel = new Responsavel();
		responsavel.setCpf(responsavelDto.getCpf());
		
		responsavel.setPessoa(
				pessoaService.save(
						responsavelDto.getPessoa()
						)
				);
		
//		FacadeCreateService
//		responsavel.setPessoa(responsavelDto.getPessoa());
		
		return resposavelRepository.save(responsavel);
	}

	@Override
	public Optional<Responsavel> findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Responsavel findBy(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Responsavel> findByAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Responsavel update(long id, Responsavel obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(long id) {
		// TODO Auto-generated method stub
		
	}

}
