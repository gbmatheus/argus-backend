package br.com.argus.argus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.argus.argus.models.Contato;

@Repository
@Transactional
public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
