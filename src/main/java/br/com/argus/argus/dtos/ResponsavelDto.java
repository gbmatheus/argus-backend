package br.com.argus.argus.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ResponsavelDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8889293700183151602L;

	private Long id;
	private String cpf;
	private PessoaDto pessoa;

	public ResponsavelDto() {
	}

	@Override
	public String toString() {
		return "Responsavel: {\n cpf: " + cpf + "\n responsavel: " + pessoa + "\n }";
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "xxx.xxx.xxx-xx")
	public String getCpf() {
		return cpf;
	}

	@NotNull(message = "Os dados do responsável são obrigatórios")
	public PessoaDto getPessoa() {
		return pessoa;
	}

	@NotBlank(message = "Cpf é um dado obrigatório")
	@Size(min = 14, max = 14, message = "CPF deve ter 14 caracteres")
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

}
