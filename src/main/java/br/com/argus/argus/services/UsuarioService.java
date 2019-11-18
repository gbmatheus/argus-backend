package br.com.argus.argus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		
		if(usuarioRepository.findByLogin(objetoDto.getLogin()) != null) {
			throw new UsuarioException("Login em uso");
		}else if(usuarioRepository.findByEmail(objetoDto.getEmail()) != null) {
			throw new UsuarioException("Email em uso");
		}else
			return super.save(objetoDto);
	}

	@Override
	@Transactional
	public Usuario update(Long id, Usuario objetoDto) {
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
	public void remove(Long id) {
		findById(id).map(record -> {
			record.setAtivo(!record.isAtivo());
			return usuarioRepository.save(record);
		}).orElse(null);
	}

}
