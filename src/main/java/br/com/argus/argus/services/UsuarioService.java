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

@Service
public class UsuarioService extends GenericService<Usuario> {

	@Autowired
	UsuarioRepository usuarioRepository;

	public Optional<Usuario> findById(long id) {
		return usuarioRepository.findById(id);

	}

	public Usuario findBy(long id) {
//		Usuario usuario = usuarioRepository.findOne(id);
//		
//		if(usuario == null) {
//			try {
//				throw new ServicesException("Usuário não está cadastrado");
//			} catch (ServicesException e) {
//				e.printStackTrace();
//			}
//		}
//		return usuario;
		return null;
	}

	public List<Usuario> findByAll() {
		return usuarioRepository.findAll();
	}

	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario update(Usuario usuario) {
		return null;
	}

	public Usuario active(long id) {
		return null;
	}

	public void deleteById(long id) {
		usuarioRepository.deleteById(id);
	}

	public void deleteAll() {
		usuarioRepository.deleteAll();
	}

	@Override
	public void remove(Usuario obj) {
		// TODO Auto-generated method stub

	}

	public Usuario login(Usuario usuario) {
		List<Usuario> usuarios = usuarioRepository.findAll();

		for (Usuario u : usuarios) {
			if (u.getLogin().equalsIgnoreCase(usuario.getLogin())) {

				if (u.getSenha().equalsIgnoreCase(usuario.getSenha()))
					return u;
				else
					return null;
			} else
				return null;
		
		}
		return null;

	}


}
