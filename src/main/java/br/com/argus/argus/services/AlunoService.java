package br.com.argus.argus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.argus.argus.dtos.AlunoDto;
import br.com.argus.argus.models.Aluno;
import br.com.argus.argus.models.Pessoa;
import br.com.argus.argus.models.Responsavel;
import br.com.argus.argus.repositories.AlunoRepository;
import br.com.argus.argus.repositories.EnderecoRepository;
import br.com.argus.argus.repositories.PessoaRepository;
import br.com.argus.argus.repositories.ResposavelRepository;

@Service
public class AlunoService {
	
	@Autowired
	EnderecoRepository enderecoRepositoty;
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	PessoaService pessoaService;
	
	@Autowired
	ResposavelRepository resposavelRepository;
	
	@Autowired
	AlunoRepository alunoRepository;
	
	
	public List<Aluno> findByAll(){
		return alunoRepository.findAll();
	}
	
	public Aluno save(AlunoDto alunoDto) {
		Aluno aluno = new Aluno();
		
//		Pessoa pessoa = new Pessoa(
//				alunoDto.getPessoa().getNome(),
//				alunoDto.getPessoa().getDataNascimento(), 
//				alunoDto.getPessoa().getNaturalidade(), 
//				alunoDto.getPessoa().getEndereco());
		
		
		Pessoa pessoa = pessoaService.save(alunoDto.getPessoa());
		aluno.setPessoa(pessoa);
		System.out.println("Salvou pessoa aluno ##################");
		Pessoa mae = pessoaService.save(alunoDto.getMae());
		aluno.setMae(mae);
		System.out.println("Salvou mae ##################");
		Pessoa pai = pessoaService.save(alunoDto.getPai());
		aluno.setPai(pai);
		System.out.println("Salvou pai ##################");
		Pessoa res = pessoaService.save(alunoDto.getResponsavelTeste());
		aluno.setResponsavelTeste(res);
		System.out.println("Salvou responsavel teste ##################");
//		Responsavel responsavel = 
//		aluno.setResponsavel(responsavel);
//		aluno.setMatricula(String.valueOf(pessoa.getId()));
		aluno.setMatricula("Teste");
		
		System.out.println("Salvando aluno ##################");
		return alunoRepository.save(aluno);
//		return null;
	}
	

}
