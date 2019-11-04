package br.com.argus.argus.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "res_fin")
public class Responsavel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6656380915923820691L;

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 14, nullable = false)
	private String cpf;

	@OneToOne(cascade = CascadeType.ALL)
	private Pessoa pessoa;

	public Responsavel() {
	}

	public Long getId() {
		return id;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "xxx.xxx.xxx-xx")
	@NotEmpty(message = "CPF é obrigratório")
	@Size(min = 14, max = 14)
	public String getCpf() {
		return cpf;
	}

	@Valid
	@NotNull(message = "Infomaçções do responsável é obrigatório")
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Responsavel [id=" + id + ", cpf=" + cpf + ", pessoa=" + pessoa + "]";
	}
	
	
}
