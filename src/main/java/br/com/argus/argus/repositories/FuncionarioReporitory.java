package br.com.argus.argus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.argus.argus.models.Funcionario;

@Repository
public interface FuncionarioReporitory extends JpaRepository<Funcionario, Long>{
	
	Funcionario findByCpf(String cpf);

}
