package br.com.argus.argus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.argus.argus.models.Turma;

@Repository
@Transactional
public interface TurmaRepository extends JpaRepository<Turma, Long>{
	
}
