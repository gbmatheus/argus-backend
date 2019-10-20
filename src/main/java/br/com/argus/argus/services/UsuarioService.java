/**
 * 
 */
package br.com.argus.argus.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.argus.argus.exception.EntityException;
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

	public Usuario save(Usuario usuarioDto) throws EntityExistsException {
		List<Usuario> usuarios = findByAll();

		if (usuarios != null) {
			System.out.println("Lista de usuários não vazia");
			for (Usuario u : usuarios) {
				if (u.getLogin().equalsIgnoreCase(usuarioDto.getLogin())
						|| u.getEmail().equalsIgnoreCase(usuarioDto.getEmail())) {
					System.out.println("Usuário já existe");
					throw new EntityExistsException("Usuário já existe");
				}
			}
			return usuarioRepository.save(usuarioDto);
		}
		System.out.println("Lista de usuários vazia");
		return usuarioRepository.save(usuarioDto);
	}

	public void deleteById(long id) {
		usuarioRepository.deleteById(id);
	}

	public void deleteAll() {
		usuarioRepository.deleteAll();
	}

	@Override
	public Usuario update(long id, Usuario obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(long id) {
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
