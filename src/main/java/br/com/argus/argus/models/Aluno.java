package br.com.argus.argus.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	private Pessoa pessoa;

	@OneToOne(cascade = CascadeType.ALL)
	private Pessoa pai;

	@OneToOne(cascade = CascadeType.ALL)
	private Pessoa mae;

	@OneToOne(cascade = CascadeType.ALL)
	private Responsavel responsavel;

	public Aluno() {
	}

	@NotNull(message = "Informação pessoais são obrigatórias")
	public Pessoa getPessoa() {
		return pessoa;
	}

	@NotNull(message = "Infomação do pai são obrigatórias")
	public Pessoa getPai() {
		return pai;
	}

	@NotNull(message = "Informações da mãe são obrigatórias")
	public Pessoa getMae() {
		return mae;
	}

	@NotNull(message = "Informações do responsável são obrigatórias")
	public Responsavel getResponsavel() {
		return responsavel;
	}

	public Long getId() {
		return id;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void setPai(Pessoa pai) {
		this.pai = pai;
	}

	public void setMae(Pessoa mae) {
		this.mae = mae;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	@Override
	public String toString() {
		return "Aluno [getPessoa()=" + getPessoa() + ", getPai()=" + getPai() + ", getMae()=" + getMae()
				+ ", getResponsavel()=" + getResponsavel() + ", getId()=" + getId() + "]";
	}

}
