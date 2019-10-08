package br.com.argus.argus.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PessoaDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1005289612175205883L;

	private Long id;
	private String nome;
	private Date dataNascimento;
	private String naturalidade;

	private EnderecoDto endereco;

	public PessoaDto() {
	}

	public PessoaDto(String nome, Date dataNascimento, String naturalidade, EnderecoDto endereco) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.naturalidade = naturalidade;
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "\nPessoa: {\n nome: " + nome + "\n dataNascimento: " + dataNascimento + "\n naturalidade: " + naturalidade
				+ "\n endereco: " + endereco + "\n}\n";
	}

	public Long getId() {
		return id;
	}
	
	@Size(min = 3, max = 100)
	@NotBlank(message = "{nome.not.blank}")
	public String getNome() {
		return nome;
	}

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@NotBlank(message = "Data de nascimento é uma informação obrigatória")
	public Date getDataNascimento() {
		return dataNascimento;
	}

	@NotNull
	@NotBlank(message = "Naturalidade é uma informação obrigatória")
	@Length(min = 2, max = 2)
	public String getNaturalidade() {
		return naturalidade;
	}

	@NotNull(message = "Endereco é uma informação obrigatória")
	public EnderecoDto getEndereco() {
		return endereco;
	}

}
