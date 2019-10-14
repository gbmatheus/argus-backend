package br.com.argus.argus.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.argus.argus.enums.Situacao;

@Entity
@Table(name = "matriculas")
public class Matricula {

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Aluno aluno;

	@Column(name = "nota_1", scale = 2, nullable = false)
	private BigDecimal nota1;

	@Column(name = "nota_2", scale = 2, nullable = false)
	private BigDecimal nota2;

	@Column(name = "nota_3", scale = 2, nullable = false)
	private BigDecimal nota3;

	@Column(name = "nota_4", scale = 2, nullable = false)
	private BigDecimal nota4;

	@Column(name = "media_geral", scale = 2, nullable = false)
	private BigDecimal mediaGeral;

	@Column(name = "prova_final", scale = 2, nullable = false)
	private BigDecimal provaFinal;

	@Column(name = "media_final", scale = 2, nullable = false)
	private BigDecimal mediaFinal;

	@Column(length = 20, nullable = false)
	@Enumerated(EnumType.STRING)
	private Situacao situacao;

	public Matricula() {
	}

	public Matricula(Long id, Aluno aluno, BigDecimal nota1, BigDecimal nota2, BigDecimal nota3, BigDecimal nota4,
			BigDecimal mediaGeral, BigDecimal provaFinal, BigDecimal mediaFinal, Situacao situacao) {
		super();
		this.id = id;
		this.aluno = aluno;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.nota4 = nota4;
		this.mediaGeral = mediaGeral;
		this.provaFinal = provaFinal;
		this.mediaFinal = mediaFinal;
		this.situacao = situacao;
	}

	public Long getId() {
		return id;
	}

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

}
