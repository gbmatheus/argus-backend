package br.com.argus.argus.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class AlunoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8957405544371610948L;

	private Long id;

	private PessoaDto pessoa;
	private PessoaDto pai;
	private PessoaDto mae;
	private PessoaDto responsavelTeste;
	private ResponsavelDto responsavel;

	private String matricula;

	public AlunoDto() {
	}

	@Override
	public String toString() {
		return "\nAlunoDto: { pessoa: " + pessoa + "\n pai: " + pai + "\n mae: " + mae + "\n responsavelTeste: "
				+ responsavelTeste + "\n responsavel: " + responsavel + "\n matricula: " + matricula + "\n}\n";
	}

	public Long getId() {
		return id;
	}
	
	@NotEmpty(message = "{pessoa.not.null}")
	public PessoaDto getPessoa() {
		return pessoa;
	}

	@NotEmpty(message = "{mae.not.null}")
	public PessoaDto getPai() {
		return pai;
	}

	@NotEmpty(message = "{mae.not.null}")
	public PessoaDto getMae() {
		return mae;
	}

	public PessoaDto getResponsavelTeste() {
		return responsavelTeste;
	}

	@NotEmpty(message = "{responsavel.not.null}")
	public ResponsavelDto getResponsavel() {
		return responsavel;
	}

	public String getMatricula() {
		return matricula;
	}

}
