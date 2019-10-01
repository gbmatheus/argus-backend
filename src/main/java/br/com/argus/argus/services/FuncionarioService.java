package br.com.argus.argus.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.argus.argus.dtos.FuncionarioDto;
import br.com.argus.argus.models.Endereco;
import br.com.argus.argus.models.Funcionario;
import br.com.argus.argus.models.Pessoa;
import br.com.argus.argus.models.Usuario;
import br.com.argus.argus.repositories.EnderecoRepository;
import br.com.argus.argus.repositories.FuncionarioReporitory;
import br.com.argus.argus.repositories.PessoaRepository;
import br.com.argus.argus.repositories.UsuarioRepository;

@Service
public class FuncionarioService {
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	FuncionarioReporitory funcionarioReporitory;
	
	public List<Funcionario> findByAll(){
		return funcionarioReporitory.findAll();
	}
	
	public Funcionario save(FuncionarioDto funcionarioDto) {
		Funcionario funcionario = new Funcionario();
		
		//primeira forma pensada
//		funcionario.setCpf(funcionarioDto.getCpf());
//		funcionario.setCargaHoraria(funcionarioDto.getCargaHoraria());
//		funcionario.setPessoa(funcionarioDto.getPessoaDto());
//		funcionario.setUsuario(funcionarioDto.getUsuarioDto());
		
		//segunda forma pensada
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(funcionarioDto.getNome());
		pessoa.setDataNascimento(funcionarioDto.getDataNascimento());
		pessoa.setNaturalidade(funcionarioDto.getNaturalidade());

		Endereco endereco = new Endereco();
		endereco.setRua(funcionarioDto.getRua());
		endereco.setBairro(funcionarioDto.getBairro());
		endereco.setCidade(funcionarioDto.getCidade());
		endereco.setComplemento("");
		endereco.setCep(funcionarioDto.getCep());
		endereco.setNumero(funcionarioDto.getNumero());
		endereco.setUf(funcionarioDto.getUf());
		
		if(enderecoRepository.save(endereco) != null) {
			System.out.println("Salvar endereço #####################################################################################################################################");
			pessoa.setEndereco(endereco);
		}else
			System.out.println("Error: Salvar endereço #####################################################################################################################################");
		
		if(pessoaRepository.save(pessoa) != null) {
			System.out.println("Salvar pessoa #####################################################################################################################################");
			funcionario.setPessoa(pessoa);
		}else 
			System.out.println("Error: Salvar pessoa #####################################################################################################################################");
		
		Usuario usuario = new Usuario();
		usuario.setLogin(funcionarioDto.getLogin());
		usuario.setSenha(funcionarioDto.getSenha());
		usuario.setEmail(funcionarioDto.getEmail());
		usuario.setTipo("Admin");
		
		if(usuarioRepository.save(usuario) != null) {
			System.out.println("Salvar usuário #####################################################################################################################################");
			funcionario.setUsuario(usuario);
		}else
			System.out.println("Error: Salvar usuário #####################################################################################################################################");
		
		funcionario.setCpf(funcionarioDto.getCpf());
		funcionario.setCargaHoraria(funcionarioDto.getCargaHoraria());

//		//terceira forma pensada - chamar o service de cada uma,
//		// passando o objeto correspondente por parametro
		
		
		return funcionarioReporitory.save(funcionario);
	}
}










