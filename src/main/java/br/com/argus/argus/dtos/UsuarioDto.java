package br.com.argus.argus.dtos;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UsuarioDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4766203426865673243L;

	private Long id;
	private String login;
	private String email;
	private String senha;
	private String tipo;

	public UsuarioDto() {
	}

	public Long getId() {
		return id;
	}

	@NotEmpty
	public String getLogin() {
		return login;
	}

	@NotEmpty
	@Email
	public String getEmail() {
		return email;
	}

	@NotEmpty
	public String getSenha() {
		return senha;
	}

	public String getTipo() {
		return tipo;
	}

}
