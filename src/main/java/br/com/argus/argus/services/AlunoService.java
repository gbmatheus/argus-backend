package br.com.argus.argus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.argus.argus.models.Aluno;
import br.com.argus.argus.repositories.AlunoRepository;

@Service
public class AlunoService extends ServiceGeneric<Aluno> {

	@Autowired
	AlunoRepository alunoRepository;
	
	@Override
	public JpaRepository<Aluno, Long> getRepository() {
		return alunoRepository;
	}
	
	@Override
	@Transactional
	public Aluno save(Aluno objetoDto) {
		return super.save(objetoDto);
	}
}
