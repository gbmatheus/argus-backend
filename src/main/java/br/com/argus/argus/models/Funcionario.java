package br.com.argus.argus.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "funcionarios")
public class Funcionario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6431287336617436606L;

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 14)
	private String cpf;

	@OneToOne
	private Pessoa pessoa;

	@OneToOne
	private Usuario usuario;

	@Column(name = "carga_horaria")
	private Integer cargaHoraria;

	public Funcionario() {
	}

	public Funcionario(Long id, String cpf, Pessoa pessoa, Usuario usuario, Integer cargaHoraria) {
		this.id = id;
		this.cpf = cpf;
		this.pessoa = pessoa;
		this.usuario = usuario;
		this.cargaHoraria = cargaHoraria;
	}

	public Long getId() {
		return id;
	}

	@NotBlank(message = "CPF é obrigatório")
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "xxx.xxx.xxx-xx")
	public String getCpf() {
		return cpf;
	}

	@NotNull(message = "Pessoa é obrigatório")
	public Pessoa getPessoa() {
		return pessoa;
	}

	@NotNull(message = "Usuário é obrigatório")
	public Usuario getUsuario() {
		return usuario;
	}

	@NotNull(message = "Carga horária é obrigatório")
	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "xxx.xxx.xxx-xx")
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", cpf=" + cpf + ", pessoa=" + pessoa + ", usuario=" + usuario
				+ ", cargaHoraria=" + cargaHoraria + "]";
	}
	
	
	

}
