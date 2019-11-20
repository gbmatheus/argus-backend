package br.com.argus.argus.models;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.argus.argus.enums.Situacao;

public class Matricula {
	private Long id;

//	@ManyToOne
//	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

//	@ManyToOne
//	@JoinColumn(name = "disciplina_id")
	private Disciplina disciplina;

//	@ManyToOne
//	@JoinColumn(name = "professor_id")
	private Funcionario professor;

//	@ManyToOne
//	@JoinColumn(name = "turma_id")
	private Turma turma;

//	@Column(name = "matricula", length = 25)
	private String codigoMatricula;

//	@Column(name = "nota_1", precision = 2, scale = 2, nullable = false)
	private BigDecimal nota1 = new BigDecimal(0);

//	@Column(name = "nota_2", precision = 2, scale = 2, nullable = false)
	private BigDecimal nota2 = new BigDecimal(0);

//	@Column(name = "nota_3", precision = 2, scale = 2, nullable = false)
	private BigDecimal nota3 = new BigDecimal(0);

//	@Column(name = "nota_4", precision = 2, scale = 2, nullable = false)
	private BigDecimal nota4 = new BigDecimal(0);

//	@Column(name = "media_geral", precision = 2, scale = 2, nullable = false)
	private BigDecimal mediaGeral = new BigDecimal(0);

//	@Column(name = "prova_final", precision = 2, scale = 2, nullable = false)
	private BigDecimal provaFinal = new BigDecimal(0);

//	@Column(name = "media_final", precision = 2, scale = 2, nullable = false)
	private BigDecimal mediaFinal = new BigDecimal(0);

//	@Column(length = 20, nullable = false)
//	@Enumerated(EnumType.STRING)
	private Situacao situacao = Situacao.EA;

	public Matricula() {
	}

	public Long getId() {
		return id;
	}

	@Valid
	public Aluno getAluno() {
		return aluno;
	}

	public BigDecimal getNota1() {
		return nota1;
	}

	public BigDecimal getNota2() {
		return nota2;
	}

	public BigDecimal getNota3() {
		return nota3;
	}

	public BigDecimal getNota4() {
		return nota4;
	}

	public BigDecimal getMediaGeral() {
		return mediaGeral;
	}

	public BigDecimal getProvaFinal() {
		return provaFinal;
	}

	public BigDecimal getMediaFinal() {
		return mediaFinal;
	}

	@NotNull(message = "Situação é uma informação obrigatória")
	public Situacao getSituacao() {
		return situacao;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void setNota1(BigDecimal nota1) {
		this.nota1 = nota1;
	}

	public void setNota2(BigDecimal nota2) {
		this.nota2 = nota2;
	}

	public void setNota3(BigDecimal nota3) {
		this.nota3 = nota3;
	}

	public void setNota4(BigDecimal nota4) {
		this.nota4 = nota4;
	}

	public void setMediaGeral(BigDecimal mediaGeral) {
		this.mediaGeral = mediaGeral;
	}

	public void setProvaFinal(BigDecimal provaFinal) {
		this.provaFinal = provaFinal;
	}

	public void setMediaFinal(BigDecimal mediaFinal) {
		this.mediaFinal = mediaFinal;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
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

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public String getCodigoMatricula() {
		return codigoMatricula;
	}

	public void setCodigoMatricula(String codigoMatricula) {
		this.codigoMatricula = codigoMatricula;
	}

}
