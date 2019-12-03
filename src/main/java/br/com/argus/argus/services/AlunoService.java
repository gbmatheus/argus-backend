package br.com.argus.argus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.argus.argus.models.Aluno;
import br.com.argus.argus.models.Pessoa;
import br.com.argus.argus.repositories.AlunoRepository;

@Service
public class AlunoService extends ServiceGeneric<Aluno> {

	@Autowired
	AlunoRepository alunoRepository;
	
	@Autowired
	ResponsavelService responsavelService;
	
	@Autowired
	PessoaService pessoaService;
	
	@Override
	public JpaRepository<Aluno, Long> getRepository() {
		return alunoRepository;
	}
	
	@Override
	@Transactional
	public Aluno save(Aluno alunoDto) {
		Aluno aluno = new Aluno();
		aluno.setResponsavel(responsavelService.save(alunoDto.getResponsavel()));
		
		Pessoa pessoa = pessoaService.findRg(aluno.getResponsavel().getPessoa().getRg());
				
		if(pessoa != null) {
			if(pessoa.getRg().equalsIgnoreCase(alunoDto.getPessoa().getRg())) {
				aluno.setPessoa(pessoaService.update(pessoa));
			} else
				aluno.setPessoa(pessoaService.save(alunoDto.getPessoa()));
			
			if(pessoa.getRg().equalsIgnoreCase(alunoDto.getPai().getRg())) {
				aluno.setPai(pessoaService.update(pessoa));
			} else
				aluno.setPai(pessoaService.save(alunoDto.getPai()));
			
			if(pessoa.getRg().equalsIgnoreCase(alunoDto.getMae().getRg())) {
				aluno.setMae(pessoaService.update(pessoa));	
			} else 
				aluno.setMae(pessoaService.save(alunoDto.getMae()));
			
		}else {
			aluno.setPessoa(pessoaService.save(alunoDto.getPessoa()));
			aluno.setPai(pessoaService.save(alunoDto.getPai()));
			aluno.setMae(pessoaService.save(alunoDto.getMae()));
		}
		
		aluno.setTurma(alunoDto.getTurma());
		
		return super.save(alunoDto);
	}
	
	@Override
	public Aluno update(Long id, Aluno alunoDto) {
		Aluno alunoOld = super.findById(id).get();
		
		alunoOld.setResponsavel(alunoDto.getResponsavel());
		alunoOld.setPessoa(alunoDto.getPessoa());
		alunoOld.setPai(alunoDto.getPai());
		alunoOld.setMae(alunoDto.getMae());
		
		return super.save(alunoOld);
		
//		return findById(id).map(record -> {
//			record.setPessoa(funcionarioDto.getPessoa());
//			record.setUsuario(funcionarioDto.getUsuario());
//			record.setCargaHoraria(funcionarioDto.getCargaHoraria());
//			record.setCpf(record.getCpf());
//
//			Funcionario funcionario = funcionarioReporitory.save(record);
//			return funcionario;
//		}).orElse(null);

	}
	
}









































