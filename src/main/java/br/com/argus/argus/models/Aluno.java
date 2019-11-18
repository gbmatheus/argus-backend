package br.com.argus.argus.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	@OneToMany(mappedBy = "aluno")
	private List<Matricula> matriculas;

	public Aluno() {
	}

	@Valid
	@NotNull(message = "Infomaçções do aluno é obrigatório")
	public Pessoa getPessoa() {
		return pessoa;
	}

	@Valid
	@NotNull(message = "Infomaçções do pai é obrigatório")
	public Pessoa getPai() {
		return pai;
	}

	@Valid
	@NotNull(message = "Infomaçções da mãe é obrigatório")
	public Pessoa getMae() {
		return mae;
	}

	@Valid
	@NotNull(message = "Infomaçções do responsável é obrigatório")
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

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

}
