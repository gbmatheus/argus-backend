package br.com.argus.argus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.argus.argus.models.Turma;
import br.com.argus.argus.repositories.TurmaRepository;

@Service
public class TurmaService extends ServiceGeneric<Turma> {

	@Autowired
	TurmaRepository turmaRepository;

	@Override
	public JpaRepository<Turma, Long> getRepository() {
		return turmaRepository;
	}
	
	@Override
	public Turma save(Turma objetoDto) {
		return super.save(objetoDto);
	}

}
