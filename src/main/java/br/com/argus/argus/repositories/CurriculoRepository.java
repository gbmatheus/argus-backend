package br.com.argus.argus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.argus.argus.models.Curriculo;

@Repository
public interface CurriculoRepository extends JpaRepository<Curriculo, Long> {
	
	Curriculo  findByCodigo(String codigo);

}
