package br.com.argus.argus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "enderecos")
public class Endereco {

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 100)
//	@NotBlank(message = "Campo rua é obrigatório")
	private String rua;

	@Column(nullable = false)
//	@NotBlank(message = "Campo numero é obrigatório")
	private Integer numero;

	@Column(nullable = false, length = 30)
//	@NotBlank(message = "Campo complemento é obrigatório")
	private String complemento;

	@Column(nullable = false, length = 30)
//	@NotBlank(message = "Campo bairo é obrigatório")
	private String bairro;

	@Column(nullable = false, length = 30)
//	@NotBlank(message = "Campo cidade é obrigatório")
	private String cidade;

	@Column(nullable = false, length = 2)
//	@NotBlank(message = "Campo estado é obrigatório")
	private String uf;

	@Column(nullable = false, length = 10)
//	@NotBlank(message = "Campo login é obrigatório")
	private String cep;

	public Endereco() {}
	
	//Teste para o funcionario dto
	public Endereco(String rua, Integer numero, String complemento, String bairro, String cidade, String uf,
			String cep) {
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}

	public Endereco(Long id, String rua, Integer numero, String complemento, String bairro, String cidade, String uf,
			String cep) {
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Long getId() {
		return id;
	}
}
