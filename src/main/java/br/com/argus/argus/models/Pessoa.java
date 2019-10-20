package br.com.argus.argus.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
@Table(name = "pessoas")
public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3817717553523601535L;

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false, length = 100)
	private String nome;

	@JsonSerialize(using = DateSerializer.class)
	@Column(name = "data_nascimento", nullable = false)
	private Date dataNascimento;

	@Column(name = "naturalidade", nullable = false, length = 2)
	private String naturalidade;// Alterar para enum
	
	@Column(nullable = false)
	private boolean ativo = true;

	@OneToOne
	private Endereco endereco;

	public Pessoa() {
	}

	public Pessoa(Long id, String nome, Date dataNascimento, String naturalidade, Endereco endereco) {
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.naturalidade = naturalidade;
		this.endereco = endereco;
	}
	
	@NotBlank(message = "Nome é obrigatório")
	@Size(min = 2, max = 100, message = "Nome deve ter mais de 3 caracteres")
	public String getNome() {
		return nome;
	}

	@NotNull(message = "Data de nascimento é obrigatório")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public Date getDataNascimento() {
		return dataNascimento;
	}

	@NotBlank(message = "Naturalidade é obrigatório")
	@Size(min = 3, max = 3)
	public String getNaturalidade() {
		return naturalidade;
	}

	@NotNull(message = "Endereço é obrigatório")
	public Endereco getEndereco() {
		return endereco;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Pessoa [getNome()=" + getNome() + ", getDataNascimento()=" + getDataNascimento()
				+ ", getNaturalidade()=" + getNaturalidade() + ", getEndereco()=" + getEndereco() + ", getId()="
				+ getId() + "]";
	}
	
	
}
