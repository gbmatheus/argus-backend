package br.com.argus.argus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.argus.argus.models.Aluno;
import br.com.argus.argus.repositories.AlunoRepository;

@Service
public class AlunoService extends GenericService<Aluno> {

	static int matricula = 0;

	@Autowired
	PessoaService pessoaService;

	@Autowired
	ResponsavelService responsavelService;

	@Autowired
	AlunoRepository alunoRepository;

	@Override
	public Optional<Aluno> findById(long id) {
		return alunoRepository.findById(id);
	}

	@Override
	public Aluno findBy(long id) {
//		Aluno aluno = alunoRepository.findOne(id);
//
//		if (aluno == null) {
//			try {
//				throw new ServicesException("Aluno não existe");
//			} catch (ServicesException e) {
//				e.printStackTrace();
//			}
//		}
//		return aluno;
		return null;
	}

	@Override
	public List<Aluno> findByAll() {
		return alunoRepository.findAll();
	}

	@Override
	public Aluno save(Aluno alunoDto) {
		Aluno aluno = new Aluno();

		aluno.setPessoa(pessoaService.save(alunoDto.getPessoa()));

		aluno.setMae(pessoaService.save(alunoDto.getMae()));

		aluno.setPai(pessoaService.save(alunoDto.getPai()));

		aluno.setResponsavel(responsavelService.save(alunoDto.getResponsavel()));

//		FacadeCreateService
//		aluno.setPessoa(alunoDto.getPessoa());
//		aluno.setMae(alunoDto.getMae());
//		aluno.setPai(alunoDto.getPai());
//		aluno.setResponsavel(alunoDto.getResponsavel());

		
		return alunoRepository.save(aluno);
	}

	@Override
	public Aluno update(Aluno obj) {
		return alunoRepository.save(obj);
	}

	@Override
	public void remove(Aluno obj) {

	}

	@Override
	public void deleteById(long id) {
		alunoRepository.deleteById(id);
	}

}
