package br.com.argus.argus.dtos;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

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

	@NotBlank
	public String getLogin() {
		return login;
	}

	@NotBlank
	@Email
	public String getEmail() {
		return email;
	}

	@NotBlank
	public String getSenha() {
		return senha;
	}

	public String getTipo() {
		return tipo;
	}

}
