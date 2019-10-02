package br.com.argus.argus.dtos;

import java.util.Date;

import br.com.argus.argus.models.Endereco;
import br.com.argus.argus.models.Pessoa;
import br.com.argus.argus.models.Responsavel;

public class AlunoDto {

	private Long id;
	private Pessoa pessoa;
	private Pessoa pai;
	private Pessoa mae;
	private Pessoa responsavelTeste;
	private Responsavel responsavel;
	private String matricula;

	public AlunoDto() {}

	public AlunoDto(Pessoa pessoa, Pessoa pai, Pessoa mae, Responsavel responsavel, String matricula) {
		this.pessoa = pessoa;
		this.pai = pai;
		this.mae = mae;
		this.responsavel = responsavel;
		this.matricula = matricula;
	}

	public Long getId() {
		return id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public void setPessoa(String nome, Date dataNascimento, String naturalidade, Endereco endereco) {
		this.pessoa = new Pessoa(nome, dataNascimento, naturalidade, endereco);
	}

	public Pessoa getPai() {
		return pai;
	}

	public void setPai(Pessoa pai) {
		this.pai = pai;
	}
	
	public void setPai(String nome, Date dataNascimento, String naturalidade, Endereco endereco) {
		this.pai = new Pessoa(nome, dataNascimento, naturalidade, endereco);
	}

	public Pessoa getMae() {
		return mae;
	}

	public void setMae(Pessoa mae) {
		this.mae = mae;
	}
	
	public void setMae(String nome, Date dataNascimento, String naturalidade, Endereco endereco) {
		this.mae = new Pessoa(nome, dataNascimento, naturalidade, endereco);
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

	public Pessoa getResponsavelTeste() {
		return responsavelTeste;
	}

	public void setResponsavelTeste(Pessoa responsavelTeste) {
		this.responsavelTeste = responsavelTeste;
	}

}
