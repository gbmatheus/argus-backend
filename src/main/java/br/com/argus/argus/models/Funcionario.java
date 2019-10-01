package br.com.argus.argus.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "funcionarios")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	private Long id;

	@Column(nullable = false, length = 14)
	private String cpf;
	
	@OneToOne
	private Pessoa pessoa;
	
	@OneToOne
	private Usuario usuario;
	
	@Column(name = "carga_horaria", nullable = false)
//	@NotBlank(message = "Campo cargo é obrigatório")
	private Integer cargaHoraria;//Alterar para enum

	public Funcionario() {
		this.pessoa =  new Pessoa();
		this.usuario = new Usuario();
	}
	
	public Funcionario(Long id, String cpf, Pessoa pessoa, Usuario usuario,
			@NotBlank(message = "Campo cargo é obrigatório") Integer cargaHoraria) {
		this.id = id;
		this.cpf = cpf;
		this.pessoa = pessoa;
		this.usuario = usuario;
		this.cargaHoraria = cargaHoraria;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Long getId() {
		return id;
	}
	
}
