package br.com.argus.argus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.argus.argus.models.AtendimentoPedagogico;

@Repository
public interface AtendimentoPedagogicoRepository extends JpaRepository<AtendimentoPedagogico, Long>{

}
