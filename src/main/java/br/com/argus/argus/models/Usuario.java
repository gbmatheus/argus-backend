package br.com.argus.argus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length = 100)
//	@NotBlank(message = "Campo login é obrigatório")
	private String login;

	@Column(nullable = false, length = 100)
//	@NotBlank(message = "Campo senha é obrigatório")
	private String senha;

	@Column(nullable = false, length = 100)
//	@NotBlank(message = "Campo email é obrigatório")
	private String email;
	
	@Column(nullable = false, length = 10)
//	@NotBlank(message = "Campo tipo é obrigatório")
	private String tipo;
	
//	@Column(nullable = false)
//	private Boolean ativo = true;

	public Usuario() {}

	//Teste para o funcionario DTO
	public Usuario(String login, String senha, String email, String tipo) {
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.tipo = tipo;
	}
	
	public Usuario(Long id, String login, String senha, String email, String tipo) {
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.tipo = tipo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

}
