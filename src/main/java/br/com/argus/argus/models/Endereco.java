package br.com.argus.argus.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "enderecos")
public class Endereco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2327060819649637831L;

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String rua;

	@Column(nullable = false)
	private Integer numero;

	@Column(nullable = true, length = 50)
	private String complemento;

	@Column(nullable = false, length = 30)
	private String bairro;

	@Column(nullable = false, length = 30)
	private String cidade;

	@Column(nullable = false, length = 2)
	private String uf;

	@Column(nullable = false, length = 10)
	private String cep;

	public Endereco() {
	}

	public Long getId() {
		return id;
	}

	@NotBlank(message = "Rua é obrigatório")
	@Size(max = 100)
	public String getRua() {
		return rua;
	}

	@NotNull(message = "Número é obrigatório")
	public Integer getNumero() {
		return numero;
	}

	@Size(max = 50)
	public String getComplemento() {
		return complemento;
	}

	@NotBlank(message = "Bairro é obrigatório")
	@Size(min = 3, max = 30, message = "Bairro deve ter no mínimo 3 caracteres e no máximo 30")
	public String getBairro() {
		return bairro;
	}

	@NotBlank(message = "Cidade é obrigatório")
	@Size(min = 3, max = 30, message = "Cidade deve ter no mínimo 3 caracteres e no máximo 30")
	public String getCidade() {
		return cidade;
	}

	@NotBlank(message = "UF é obrigatório")
	@Size(min = 2, max = 2)
	public String getUf() {
		return uf;
	}

	@NotBlank(message = "Cep é obrigatório")
	@Size(min = 10, max = 10)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "xx.xxx-xx")
	public String getCep() {
		return cep;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "xx.xxx-xx")
	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "Endereco [getId()=" + getId() + ", getRua()=" + getRua() + ", getNumero()=" + getNumero()
				+ ", getComplemento()=" + getComplemento() + ", getBairro()=" + getBairro() + ", getCidade()="
				+ getCidade() + ", getUf()=" + getUf() + ", getCep()=" + getCep() + "]";
	}

}
