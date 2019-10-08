package br.com.argus.argus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.argus.argus.dtos.AlunoDto;
import br.com.argus.argus.models.Aluno;
import br.com.argus.argus.repositories.AlunoRepository;

@Service
public class AlunoService {

	static int matricula = 0;

	@Autowired
	PessoaService pessoaService;

	@Autowired
	ResponsavelService responsavelService;

	@Autowired
	AlunoRepository alunoRepository;

	public List<Aluno> findByAll() {
		return alunoRepository.findAll();
	}

	public Aluno save(AlunoDto alunoDto) {
		System.out.println(alunoDto.toString());
		Aluno aluno = new Aluno();

		aluno.setPessoa(pessoaService.save(alunoDto.getPessoa()));

		aluno.setMae(pessoaService.save(alunoDto.getMae()));

		aluno.setPai(pessoaService.save(alunoDto.getPai()));
		
		aluno.setResponsavel(responsavelService.save(alunoDto.getResponsavel()));
		
		aluno.setMatricula("A" + matricula++);

		return alunoRepository.save(aluno);
	}

}
