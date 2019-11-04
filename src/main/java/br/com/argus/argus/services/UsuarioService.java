package br.com.argus.argus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.argus.argus.exception.ServicesException;
import br.com.argus.argus.exception.UsuarioException;
import br.com.argus.argus.models.Usuario;
import br.com.argus.argus.repositories.UsuarioRepository;

@Service
public class UsuarioService extends ServiceGeneric<Usuario> {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public JpaRepository<Usuario, Long> getRepository() {
		return usuarioRepository;
	}

	public Usuario login() {
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

	@Override
	@Transactional
	public Usuario save(Usuario objetoDto) {
		List<Usuario> usuarios = findByAll();

		System.out.println("Service");
		if (usuarios.size() != 0) {
			System.out.println("Service 00");
			for (Usuario u : usuarios) {
				System.out.println("Service 0");
				System.out.println("Service 1");

				if (!u.getLogin().equalsIgnoreCase(objetoDto.getLogin())
						&& !u.getEmail().equalsIgnoreCase(objetoDto.getEmail())) {
					return super.save(objetoDto);
				
				}else
					return null;
			}
		}
		return super.save(objetoDto);
	}

	@Override
	@Transactional
	public Usuario update(long id, Usuario objetoDto) {
		return findById(id).map(record -> {
			record.setLogin(objetoDto.getLogin());
			record.setEmail(objetoDto.getEmail());
			record.setSenha(objetoDto.getSenha());
			record.setTipo(objetoDto.getTipo());
			record.setAtivo(objetoDto.isAtivo());
			Usuario usuario = super.save(record);
			return usuario;
		}).orElse(null);
	}

	@Override
	@Transactional
	public void remove(long id) {
		findById(id).map(record -> {
			record.setAtivo(!record.isAtivo());
			return usuarioRepository.save(record);
		}).orElse(null);
	}

}
