package br.com.argus.argus.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.argus.argus.enums.AnoLetivo;

@Entity
@Table(name = "curriculos")
public class Curriculo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 10, nullable = false)
	private String codigo;

	@Column(length = 50, nullable = false)
	private String nome;

	@Column(name = "ano_letivo", nullable = false)
	@Enumerated(EnumType.STRING)
	private AnoLetivo anoLetivo;

	@OneToMany
	@JoinColumn(name = "curriculos_id")
	private List<Turma> turma;

	@OneToMany
	@JoinColumn(name = "curriculos_id")
	private List<Disciplina> disciplinas;

	public Curriculo() {
	}

	public Curriculo(Long id, String codigo, String nome, AnoLetivo anoLetivo, List<Turma> turma,
			List<Disciplina> disciplinas) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.anoLetivo = anoLetivo;
		this.turma = turma;
		this.disciplinas = disciplinas;
	}

	public Long getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public AnoLetivo getAnoLetivo() {
		return anoLetivo;
	}

	public List<Turma> getTurma() {
		return turma;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setAnoLetivo(AnoLetivo anoLetivo) {
		this.anoLetivo = anoLetivo;
	}

	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
