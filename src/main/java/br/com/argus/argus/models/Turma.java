package br.com.argus.argus.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "turmas")
public class Turma implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6838772791096037297L;

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 255, nullable = true)
	private String descricao;

	@Column(length = 10, nullable = false)
	private String anoEscolar;

	@Column(length = 10, nullable = true)
	private String turno = "manhã";

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "curriculo_id", nullable = false)
	private Curriculo curriculo;

	@OneToMany(mappedBy = "turma")
	private List<Matricula> matriculas;

	public Turma() {
	}

//	@NotEmpty(message = "Descrição é uma informação obrigatória")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descicao) {
		this.descricao = descicao;
	}

	public Long getId() {
		return id;
	}

	public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}

	public String getAnoEscolar() {
		return anoEscolar;
	}

	public void setAnoEscolar(String anoEscolar) {
		this.anoEscolar = anoEscolar;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	
	

}
