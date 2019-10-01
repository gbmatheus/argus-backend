package br.com.argus.argus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.argus.argus.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
