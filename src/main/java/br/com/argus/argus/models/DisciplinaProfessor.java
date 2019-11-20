package br.com.argus.argus.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "dis_pro")
public class DisciplinaProfessor {

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "turma_id")
//	private Turma turma;

	@ManyToMany(mappedBy = "disciplinaProfessor")
	private List<Turma> turmas;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "disciplina_id")
	private Disciplina disciplina;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "professor_id")
	private Funcionario professor;

	public DisciplinaProfessor() {
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Funcionario getProfessor() {
		return professor;
	}

	public void setProfessor(Funcionario professor) {
		this.professor = professor;
	}

	public Long getId() {
		return id;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

}
