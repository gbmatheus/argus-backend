package br.com.argus.argus.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "alunos")
public class Aluno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5671116911706195166L;

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	private Pessoa pessoa;

	@OneToOne
	private Pessoa pai;

	@OneToOne
	private Pessoa mae;

	@OneToOne
	private Responsavel responsavel;

	@Column(nullable = false, length = 10)
	private String matricula;

	public Aluno() {
	}

	public Aluno(Long id, Pessoa pessoa, Pessoa pai, Pessoa mae, Responsavel responsavel, String matricula) {
		this.id = id;
		this.pessoa = pessoa;
		this.pai = pai;
		this.mae = mae;
		this.responsavel = responsavel;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Pessoa getPai() {
		return pai;
	}

	public void setPai(Pessoa pai) {
		this.pai = pai;
	}

	public Pessoa getMae() {
		return mae;
	}

	public void setMae(Pessoa mae) {
		this.mae = mae;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Long getId() {
		return id;
	}

}
