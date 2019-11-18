package br.com.argus.argus.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
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
	private Long id;

	@Column(length = 14, nullable = false, unique = true)
	private String cpf;

//	@OneToOne(mappedBy = "responsavel", cascade = CascadeType.ALL)
	@OneToOne
	@MapsId
	private Pessoa pessoa;

	public Responsavel() {
	}
	
	public Responsavel(Long id, String cpf) {
		this.id = id;
		this.cpf = cpf;
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

	public void setId(Long id) {
		this.id = id;
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
