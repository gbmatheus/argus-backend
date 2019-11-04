package br.com.argus.argus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.argus.argus.models.Usuario;

/**
 * Interface Usuário Dao
 * Extende a interface JpaRository
 * 	- JpaRepository fornece os métodos de acesso ao banco de dados
 *  	- findAll, findById, save...
 * 	-  JpaRepository <T, ID> 
 * 			- T = Entidade(@Entity) que a jpa representa 
 * 			- ID = Tipo da chave primária da classe 
 * */
@Repository
@Transactional(readOnly = false)
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByLogin(String login);
	Usuario findByEmail(String email);

}
