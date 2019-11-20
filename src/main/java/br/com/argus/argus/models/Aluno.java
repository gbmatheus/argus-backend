package br.com.argus.argus.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
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

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Pessoa pai;

	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Pessoa mae;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Responsavel responsavel;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "turma_id", nullable = true)
	private Turma turma;

	public Aluno() {
	}

	@Valid
	@NotNull(message = "Aluno é obrigatório")
	public Pessoa getPessoa() {
		return pessoa;
	}

	@Valid
	@NotNull(message = "Pai é obrigatório")
	public Pessoa getPai() {
		return pai;
	}

	@Valid
	@NotNull(message = "Mãe é obrigatório")
	public Pessoa getMae() {
		return mae;
	}

	@Valid
	@NotNull(message = "Responsável é obrigatório")
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

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}
