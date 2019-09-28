package br.com.argus.argus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
