package br.com.argus.argus.models;

import java.util.List;

import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.argus.argus.enums.AnoLetivo;

@Entity
@Table(name = "curriculos")
public class Curriculo {

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 10, nullable = false)
	private String codigo;

	@Column(length = 30, nullable = false)
	private String nome;

	@Column(name = "ano_letivo", nullable = false)
	@Enumerated(EnumType.STRING)
	private AnoLetivo anoLetivo;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "curriculos_id")
	private List<Turma> turma;
	
//	@OneToMany
//	@JoinColumn(name = "pessoa_id")
//	private List<Cachorro> cachorros;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "curriculos_id")
	private List<Disciplina> disciplinas;

	public Curriculo() {
	}

	public Long getId() {
		return id;
	}

	@NotBlank(message = "Código é obrigatório")
	@Size(min = 5, max = 10)
	public String getCodigo() {
		return codigo;
	}

	@NotBlank(message = "Nome é obrigatório")
	@Size(min = 5, max = 30)
	public String getNome() {
		return nome;
	}

	@NotNull(message = "Ano letivo é obrigatório")
	public AnoLetivo getAnoLetivo() {
		return anoLetivo;
	}

	@NotNull(message = "Turmas são obrigatório")
	public List<Turma> getTurma() {
		return turma;
	}

	@NotNull(message = "Disciplinas são obrigatórias")
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
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

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
