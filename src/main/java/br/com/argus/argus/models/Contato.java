package br.com.argus.argus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "contatos")
public class Contato {

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 15)
	private String telefone;

	@Column(length = 15)
	private String celular;

	public Contato() {
	}

	public Long getId() {
		return id;
	}

	@NotBlank(message = "Telefone é obrigatório")
	@Size(min = 7, max = 15)
	public String getTelefone() {
		return telefone;
	}

	@NotBlank(message = "Celular é obrigatório")
	@Size(min = 7, max = 15)
	public String getCelular() {
		return celular;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

}
