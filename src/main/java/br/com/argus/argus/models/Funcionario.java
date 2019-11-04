package br.com.argus.argus.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
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

	@Column(length = 14, nullable = false)
	private String cpf;

	@OneToOne(cascade = CascadeType.ALL)
	private Pessoa pessoa;

	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario;

	@Column(name = "carga_horaria", nullable = false)
	private Integer cargaHoraria;

	public Funcionario() {
	}

	public Long getId() {
		return id;
	}

	@NotEmpty(message = "CPF é obrigatório")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "xxx.xxx.xxx-xx")
	public String getCpf() {
		return cpf;
	}

	@Valid
	@NotNull(message = "Informações do funcionário é obrigatório")
	public Pessoa getPessoa() {
		return pessoa;
	}
	
//	@NotNull(message = "Endereco é obrigatório")
//	public Endereco getEndereco() {
//		return pessoa.getEndereco();
//	}

	@Valid
	@NotNull(message = "Infomações do usuário é obrigatório")
	public Usuario getUsuario() {
		return usuario;
	}

	@NotNull(message = "Carga horária é obrigatório")
	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "xxx.xxx.xxx-xx")
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
