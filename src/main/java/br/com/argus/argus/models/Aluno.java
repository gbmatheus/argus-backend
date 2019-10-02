package br.com.argus.argus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "alunos")
public class Aluno {

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
//	@NotBlank(message = "Campo pessoa é obrigátorio")
	private Pessoa pessoa;
	
	@OneToOne
//	@NotBlank(message = "Campo pai é obrigatório")
	private Pessoa pai;

	@OneToOne
//	@NotBlank(message = "Campo mãe é obrigatório")
	private Pessoa mae;

	@OneToOne
//	@NotBlank(message = "Compo responsavvel é obrigatório")
//	private Responsavel responsavel;
	private Pessoa responsavelTeste;

	@Column(nullable = false, length = 10)
//	@NotBlank(message = "Compo matricula é obrigatório")
	private String matricula;

	public Aluno() {}

	public Aluno(Long id, Pessoa pessoa, Pessoa pai, Pessoa mae, Responsavel responsavel, String matricula) {
		this.id = id;
		this.pessoa = pessoa;
		this.pai = pai;
		this.mae = mae;
//		this.responsavel = responsavel;
		this.matricula = matricula;
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

//	public Responsavel getResponsavel() {
//		return responsavel;
//	}
//
//	public void setResponsavel(Responsavel responsavel) {
//		this.responsavel = responsavel;
//	}
	
	public Pessoa getResponsavelTeste() {
		return responsavelTeste;
	}

	public void setResponsavelTeste(Pessoa responsavelTeste) {
		this.responsavelTeste = responsavelTeste;
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
