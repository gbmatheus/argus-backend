package br.com.argus.argus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.argus.argus.models.Responsavel;

@Repository
@Transactional
public interface ResponsavelRepository extends JpaRepository<Responsavel, Long>{
	
	Responsavel findByCpf(String cpf);

}
