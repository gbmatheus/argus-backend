package br.com.argus.argus.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
@Table(name = "pessoas")
public class Pessoa {
	
	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "nome", nullable = false, length = 100)
//	@NotBlank(message = "Campo nomeé obrigatório")
	private String nome;
	
//	@Temporal(TemporalType.DATE)
	@JsonSerialize(using = DateSerializer.class)
	@Column(name = "data_nascimento", nullable = false)
//	@NotBlank(message = "Campo data de nascimento é obrigatório")
	private Date dataNascimento;

	@Column(name = "naturalidade", nullable = false)
//	@NotBlank(message = "Campo naturalidade é obrigatório")
	private String naturalidade;// Alterar para enum
	
	@OneToOne
	private Endereco endereco;// Alterar para tabela

	public Pessoa() {}

	//Teste para o funcionario dto
	public Pessoa(String nome, Date dataNascimento, String naturalidade, Endereco endereco) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.naturalidade = naturalidade;
		this.endereco = endereco;
	}
	
	public Pessoa(Long id, String nome, Date dataNascimento, String naturalidade, Endereco endereco) {
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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date getDataNascimento() {
		return dataNascimento;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}
}
