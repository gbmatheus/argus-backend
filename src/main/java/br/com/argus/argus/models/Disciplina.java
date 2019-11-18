package br.com.argus.argus.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "disciplinas")
public class Disciplina implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8882105127845340193L;

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 8, nullable = false)
	private String codigo;

	@Column(length = 20, nullable = false)
	private String nome;

	@Column(name = "carga_horaria", nullable = false)
	private Integer cargaHoraria;

	@JsonIgnore
	@ManyToMany(mappedBy = "disciplinas")
	private List<Curriculo> curriculos;

//	@OneToOne(cascade = CascadeType.ALL)
//	private Funcionario professor;

	@OneToMany(mappedBy = "disciplina")
	private List<Matricula> matriculas;

	public Disciplina() {
	}

	public Long getId() {
		return id;
	}

	@NotEmpty(message = "Código é obrigatório")
	@Size(min = 4, max = 8)
	public String getCodigo() {
		return codigo;
	}

	@NotEmpty(message = "Nome da disciplinha é obrigatório")
	@Size(min = 4, max = 20)
	public String getNome() {
		return nome;
	}

	@NotNull(message = "Carga horária é obrigatório")
	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

//	@Valid
//	public Funcionario getProfessor() {
//		return professor;
//	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public List<Curriculo> getCurriculos() {
		return curriculos;
	}

	public void setCurriculos(List<Curriculo> curriculos) {
		this.curriculos = curriculos;
	}

//	@Override
//	public String toString() {
//		return "Disciplina [id=" + id + ", codigo=" + codigo + ", nome=" + nome + ", cargaHoraria=" + cargaHoraria
//				+ ", curriculos=" + curriculos.toString() + ", matriculas=" + matriculas + "]";
//	}

//	public void setProfessor(Funcionario professor) {
//		this.professor = professor;
//	}
	
	
}
