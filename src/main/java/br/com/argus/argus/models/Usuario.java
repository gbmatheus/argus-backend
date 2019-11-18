package br.com.argus.argus.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.argus.argus.enums.Tipo;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -323345484627801915L;

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//adicionar random 
	@Column(nullable = false, length = 50)
	private String login;

	//adicionar senha padrao e hash
	@Column(nullable = false, length = 50)
	private String senha;

	@Column(nullable = false, length = 100)
	private String email;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Tipo tipo = Tipo.SEC;

	@Column(nullable = false)
	private Boolean ativo = true;

	public Usuario() {
	}

	public Long getId() {
		return id;
	}

	@NotEmpty(message = "Login é obrigatório")
	@Size(min = 8, max = 50, message = "Login deve ter no mínimo 8 caracteres e no máximo 50")
	public String getLogin() {
		return login;
	}

	@NotEmpty(message = "Senha é obrigatório")
	@Size(min = 8, max = 50, message = "Senha deve ter no mínimo 8 caracteres e no máximo 50")
	public String getSenha() {
		return senha;
	}

	@NotEmpty(message = "Email é obrigatório")
	@Email(message = "Formato incorreto. Ex: seuemail@email.com")
	@Size(min = 8, max = 50, message = "Login deve ter no mínimo 8 caracteres e no máximo 50")
	public String getEmail() {
		return email;
	}

	@NotNull(message = "Tipo de Usuário é obtigatório")
	public Tipo getTipo() {
		return tipo;
	}

	public Boolean isAtivo() {
		return ativo;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", senha=" + senha + ", email=" + email + ", tipo=" + tipo
				+ ", ativo=" + ativo + "]";
	}

}
