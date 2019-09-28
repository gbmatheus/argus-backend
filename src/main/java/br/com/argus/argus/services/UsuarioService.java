/**
 * 
 */
package br.com.argus.argus.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.argus.argus.models.Usuario;
import br.com.argus.argus.repositories.UsuarioRepository;

/**
 * Usuário service contém a lógica das regras de negócio Faz invocação dos
 * métodos do repository
 *
 * 
 */
@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	/**
	 * Buscar usuário por id
	 * 
	 * @param id
	 * @return usuário
	 */
	public Optional<Usuario> findById(long id) {
		return usuarioRepository.findById(id);
	}

	/**
	 * Buscar todos usuários
	 * 
	 * @return lista de usuário
	 */
	public List<Usuario> findByAll() {
		return usuarioRepository.findAll();
	}

	/**
	 * Criar usuário
	 * 
	 * @param usuario
	 * @return
	 */
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	/**
	 * Atualizar usuário
	 * 
	 * @param usuario
	 * @return
	 */
	public Usuario update(Usuario usuario) {
		return null;
	}

	/**
	 * Ativar ou desativar usuário
	 * 
	 * @param usuario
	 * @return
	 */
	public Usuario active(long id) {
		return null;
	}

	/**
	 * Apagar usuário pelo id
	 * 
	 * @param id
	 */
	public void deleteById(long id) {
		usuarioRepository.deleteById(id);
	}

	/**
	 * Apagar todos os usuários
	 */
	public void deleteAll() {
		usuarioRepository.deleteAll();
	}

}
