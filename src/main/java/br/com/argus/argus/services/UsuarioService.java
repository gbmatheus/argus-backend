/**
 * 
 */
package br.com.argus.argus.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.argus.argus.exception.ServicesException;
import br.com.argus.argus.models.Usuario;
import br.com.argus.argus.repositories.UsuarioRepository;

@Service
public class UsuarioService extends GenericService<Usuario> {

	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario login(String login, String password) {
		List<Usuario> usuarios = findByAll();
//		Usuario us = usuarioRepository.findOne(usuario);

		for (Usuario u : usuarios) {
			if (u.getLogin().equalsIgnoreCase(login)) {

				if (u.getSenha().equalsIgnoreCase(password))
					return u;
				else
					return null;
			} else
				return null;

		}
		return null;

	}

	public Usuario logout() {
		return null;
	}

	public Usuario alterPassword() {
		return null;
	}

	public void resetPassword() {

	}

	public void forgotPassword() {

	}

	public Optional<Usuario> findById(long id) {
		return usuarioRepository.findById(id);

	}

	public List<Usuario> findByAll() {
		return usuarioRepository.findAll();
	}

	public Usuario save(Usuario usuarioDto) throws EntityExistsException {
		List<Usuario> usuarios = findByAll();

		if (usuarios.size() != 0) {
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

	public Usuario findBy(long id) throws ServicesException {
		Usuario usuario = usuarioRepository.findOne(id);
		if (usuario == null)
			throw new ServicesException("Usuário não está cadastrado");

		return usuario;
	}

	@Override
	public Usuario update(long id, Usuario usuarioDto) {
		return findById(id).map(record -> {
			record.setLogin(usuarioDto.getLogin());
			record.setEmail(usuarioDto.getEmail());
			record.setSenha(usuarioDto.getSenha());
			record.setTipo(usuarioDto.getTipo());
			record.setAtivo(usuarioDto.isAtivo());
			Usuario usuario = usuarioRepository.save(record);
			return usuario;
		}).orElse(null);
	}

	@Override
	public void remove(long id) {
		findById(id).map(record -> {
			record.setAtivo(!record.isAtivo());
			return usuarioRepository.save(record);

		}).orElse(null);
	}

}
