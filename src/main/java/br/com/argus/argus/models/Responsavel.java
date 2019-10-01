package br.com.argus.argus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "res_fin")
public class Responsavel {
	
	@Id
	private Long id;
	
	@Column(nullable = false, length = 14)
	private String cpf;
	
	@OneToOne
	private Pessoa resPessoa;
	
	public Responsavel() {}
	
	public Responsavel(Long id, String cpf, Pessoa resPessoa) {
		this.id = id;
		this.cpf = cpf;
		this.resPessoa = resPessoa;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Pessoa getResPessoa() {
		return resPessoa;
	}

	public void setResPessoa(Pessoa resPessoa) {
		this.resPessoa = resPessoa;
	}

	public Long getId() {
		return id;
	}
}
