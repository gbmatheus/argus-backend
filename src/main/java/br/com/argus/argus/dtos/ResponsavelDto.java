package br.com.argus.argus.dtos;

import java.util.Date;

import br.com.argus.argus.models.Endereco;
import br.com.argus.argus.models.Pessoa;

public class ResponsavelDto {

	private Long id;
	private String cpf;
	private Pessoa responsavel;
	
	public ResponsavelDto() {}
	
	public ResponsavelDto(String cpf, Pessoa resPessoa) {
		this.cpf = cpf;
		this.responsavel = resPessoa;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Pessoa getResPessoa() {
		return responsavel;
	}

	public void setResponsavel(Pessoa resPessoa) {
		this.responsavel = resPessoa;
	}
	
	public void setResponsavel(String nome, Date dataNascimento, String naturalidade, Endereco endereco) {
		this.responsavel = new Pessoa(nome, dataNascimento, naturalidade, endereco);
	}

	public Long getId() {
		return id;
	}

}
