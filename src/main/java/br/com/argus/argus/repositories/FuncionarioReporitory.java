package br.com.argus.argus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.argus.argus.models.Funcionario;

public interface FuncionarioReporitory extends JpaRepository<Funcionario, Long>{

}
