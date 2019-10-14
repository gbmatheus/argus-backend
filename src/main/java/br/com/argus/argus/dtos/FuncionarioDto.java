package br.com.argus.argus.dtos;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.argus.argus.models.Endereco;
import br.com.argus.argus.models.Pessoa;
import br.com.argus.argus.models.Usuario;

public class FuncionarioDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Atributo de Funcionario
	private Long id;
	private String cpf;
	private Integer cargaHoraria;
	
	//Atributo de Pessoa
	private String nome;
	private String naturalidade;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dataNascimento;
	
	//Atributo de Endereco
	private String rua;
	private Integer numero;
	private String complemento;
	private String bairro;
	private String cidade;
//	@Length(min = 2, max = 2, message = "UF inválido")
	private String uf;
//	@Length(min = 8, max = 11, message = "Cep inválido")
	private String cep;
	
	//Atributo de Usuario
	private String login;
	private String senha;
	private String email;
	private String tipo;
	
	private Pessoa pessoaDto;
	private Endereco enderecoDto;
	private Usuario usuarioDto;
	
	public FuncionarioDto() {}
	
	
	//Ao inves de passar todos os usuario atributos para atribuido
	// contruir um metodo contrutor para o funcionarioDto com todos
	//  os parametros de suas dependecias, e atrinuindo ao objeto instanciado
	public FuncionarioDto(Long id, String nome, Date dataNascimento, String naturalidade, String rua, Integer numero,
			String complemento, String bairro, String cidade, String uf, String cep, String login, String senha,
			String email, String tipo, String cpf, Integer cargaHoraria) {
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.naturalidade = naturalidade;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.tipo = tipo;
		this.cpf = cpf;
		this.cargaHoraria = cargaHoraria;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Integer getCargaHoraria() {
		return cargaHoraria;
	}


	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getNaturalidade() {
		return naturalidade;
	}


	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Pessoa getPessoaDto() {
		return pessoaDto;
	}


	public void setPessoaDto(Pessoa pessoaDto) {
		this.pessoaDto = pessoaDto;
	}


	public Endereco getEnderecoDto() {
		return enderecoDto;
	}


	public void setEnderecoDto(Endereco enderecoDto) {
		this.enderecoDto = enderecoDto;
	}


	public Usuario getUsuarioDto() {
		return usuarioDto;
	}


	public void setUsuarioDto(Usuario usuarioDto) {
		this.usuarioDto = usuarioDto;
	}

}
