package br.com.argus.argus.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "res_fin")
public class Responsavel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6656380915923820691L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 14)
	private String cpf;

	@OneToOne
	private Pessoa pessoa;

	public Responsavel() {}

	public Responsavel(String cpf, Pessoa pessoa) {
		this.cpf = cpf;
		this.pessoa = pessoa;
	}

	public Responsavel(Long id, String cpf, Pessoa pessoa) {
		this.id = id;
		this.cpf = cpf;
		this.pessoa = pessoa;
	}

	public Long getId() {
		return id;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "xxx.xxx.xxx-xx")
	public String getCpf() {
		return cpf;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
