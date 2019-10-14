package br.com.argus.argus.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "turmas")
public class Turma implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6838772791096037297L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 255, nullable = true)
	private String descicao;
	
	@OneToMany
	@JoinColumn(name = "turmas_id")
	private List<Matricula> matricula;
	
	public Turma() {}
	
	public Turma(Long id, String descicao) {
		this.id = id;
		this.descicao = descicao;
	}

	public String getDescicao() {
		return descicao;
	}

	public void setDescicao(String descicao) {
		this.descicao = descicao;
	}

	public Long getId() {
		return id;
	}

}
