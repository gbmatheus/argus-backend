package br.com.argus.argus.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.argus.argus.models.Endereco;

public class PessoaDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;
	private Date dataNascimento;
	private String naturalidade;
	
	private Endereco endereco;
	
	public PessoaDto() {}
	
	public PessoaDto(String nome, Date dataNascimento, String naturalidade, Endereco endereco) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.naturalidade = naturalidade;
		this.endereco = endereco;//dá new em endereco
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@NotBlank(message = "Nome é uma informação obrigatório")
	@Length(min = 3, max = 100)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@NotBlank(message = "Data de nascimento é uma informação obrigatório")
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@NotBlank(message = "Naturalidade é uma informação obrigatório")
	@Length(min = 2, max = 2)
	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(String rua, Integer numero, String complemento, String bairro, String cidade, String uf,
			String cep) {
		this.endereco = new Endereco(rua, numero, complemento, bairro, cidade, uf, cep);
	}
	
}
