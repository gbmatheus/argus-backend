package br.com.argus.argus.models;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.argus.argus.enums.Situacao;

@Entity
@Table(name = "matriculas")
public class Matricula {

	@Id
	@JsonIgnore
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	private Aluno aluno;

	@Column(name = "nota_1", precision = 2, scale = 2, nullable = false)
	private BigDecimal nota1 = new BigDecimal(0);

	@Column(name = "nota_2", precision = 2, scale = 2, nullable = false)
	private BigDecimal nota2 = new BigDecimal(0);

	@Column(name = "nota_3", precision = 2, scale = 2, nullable = false)
	private BigDecimal nota3 = new BigDecimal(0);

	@Column(name = "nota_4", precision = 2, scale = 2, nullable = false)
	private BigDecimal nota4 = new BigDecimal(0);

	@Column(name = "media_geral", precision = 2, scale = 2, nullable = false)
	private BigDecimal mediaGeral = new BigDecimal(0);

	@Column(name = "prova_final", precision = 2, scale = 2, nullable = false)
	private BigDecimal provaFinal = new BigDecimal(0);

	@Column(name = "media_final", precision = 2, scale = 2, nullable = false)
	private BigDecimal mediaFinal = new BigDecimal(0);

	@Column(length = 20, nullable = false)
	@Enumerated(EnumType.STRING)
	private Situacao situacao;

	public Matricula() {
	}

	public Long getId() {
		return id;
	}

	@NotNull(message = "Aluno é uma informação obrigatória")
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

}
