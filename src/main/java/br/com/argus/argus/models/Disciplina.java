package br.com.argus.argus.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "disciplinas")
public class Disciplina implements Serializable{
	
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
	
	@Column(name = "carga_horaria",nullable = false)
	private Integer cargaHoraria;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Funcionario professor;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "disciplinas_id")
	private List<Matricula> matricula;
	
	public Disciplina() {}

	public Long getId() {
		return id;
	}

	@NotBlank(message = "Código é obrigatório")
	@Size(min = 8, max = 8)
	public String getCodigo() {
		return codigo;
	}

	@NotBlank(message = "Nome da disciplinha é obrigatório")
	@Size(min = 4, max = 20)
	public String getNome() {
		return nome;
	}

	@NotNull(message = "Carga horária é obrigatório")
	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	@NotNull(message = "Professor é obrigatório")
	public Funcionario getProfessor() {
		return professor;
	}
	
	public List<Matricula> getMatricula() {
		return matricula;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public void setProfessor(Funcionario professor) {
		this.professor = professor;
	}
	
}
