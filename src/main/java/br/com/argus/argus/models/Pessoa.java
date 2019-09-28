package br.com.argus.argus.models;

import java.util.Calendar;

import javax.persistence.Entity;

@Entity
public class Pessoa {

	private Long id;
	private String nome;
	private Calendar dataNascimento;
	private String naturalidade;// Alterar para enum
	private String endereco;// Alterar para tabela

	public Pessoa() {
	}

	public Pessoa(Long id, String nome, Calendar dataNascimento, String naturalidade, String endereco) {
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.naturalidade = naturalidade;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

}
