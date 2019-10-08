package br.com.argus.argus.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EnderecoDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String rua;
	private Integer numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;

	public EnderecoDto() {
	}

	@Override
	public String toString() {
		return "Endereco: {\n rua: " + rua + "\n numero: " + numero + "\n complemento: " + complemento + "\n bairro:"
				+ bairro + "\n cidade: " + cidade + "\n uf: " + uf + "\n cep: " + cep + "\n}";
	}

	public Long getId() {
		return id;
	}

	@NotNull
	@NotBlank(message = "Rua é uma infromação obrigatória")
	@Size(min = 1, max = 100, message = "A rua deve ter mais de um caractere")
	public String getRua() {
		return rua;
	}

	@NotNull
	@NotBlank(message = "Numero da residência é uma informação obrigatória")
	public Integer getNumero() {
		return numero;
	}

	@Size(max = 50)
	public String getComplemento() {
		return complemento;
	}

	@NotNull
	@NotBlank(message = "Bairro é uma informação obrigatória")
	@Size(min = 5, max = 30)
	public String getBairro() {
		return bairro;
	}

	@NotNull
	@NotBlank(message = "Cidade é uma informação obrigatória")
	@Size(min = 3, max = 30)
	public String getCidade() {
		return cidade;
	}

	@NotNull
	@NotBlank(message = "UF é uma informação obrigatória")
	@Size(min = 2, max = 2)
	public String getUf() {
		return uf;
	}

	@NotNull
	@NotBlank(message = "CEP é uma informação obrigatória")
	@Size(min = 10, max = 10)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "xx.xxx-xxx")
	public String getCep() {
		return cep;
	}

}
