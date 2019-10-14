package br.com.argus.argus.facade;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.argus.argus.models.Aluno;
import br.com.argus.argus.models.Endereco;
import br.com.argus.argus.models.Funcionario;
import br.com.argus.argus.models.Pessoa;
import br.com.argus.argus.models.Responsavel;
import br.com.argus.argus.models.Usuario;
import br.com.argus.argus.services.AlunoService;
import br.com.argus.argus.services.EnderecoService;
import br.com.argus.argus.services.FuncionarioService;
import br.com.argus.argus.services.PessoaService;
import br.com.argus.argus.services.ResponsavelService;
import br.com.argus.argus.services.UsuarioService;

public class FacadeCreateService {

	@Autowired
	PessoaService pessoaService;

	@Autowired
	EnderecoService enderecoService;

	@Autowired
	AlunoService alunoService;

	@Autowired
	ResponsavelService responsavelService;

	@Autowired
	FuncionarioService funcionarioService;

	@Autowired
	UsuarioService usuarioService;
	
	
	public FacadeCreateService() {
	}

	public Object create(Object object) {

		if (object instanceof Aluno) {
			return alunoCreate(object);

		}
		else if (object instanceof Funcionario) {
			return funcionarioCreate(object);

		}
		else if (object instanceof Aluno) {
			return alunoCreate(object);

		}
		else if (object instanceof Aluno) {
			return alunoCreate(object);

		}

		return null;
	}

	private Object alunoCreate(Object object) {
		System.out.println("Aluno create \n "+object.toString()+"\n\n");
		
		Aluno obj = (Aluno) object;
		Aluno aluno = new Aluno();

		Endereco endereco = enderecoService.save(obj.getPessoa().getEndereco());

		Pessoa pessoa = obj.getPessoa();
		pessoa.setEndereco(endereco);
		aluno.setPessoa(pessoaService.save(pessoa));

		endereco = null;
		endereco = enderecoService.save(obj.getPessoa().getEndereco());

		Pessoa pai = obj.getPai();
		pai.setEndereco(endereco);
		aluno.setPai(pessoaService.save(pai));

		endereco = null;
		endereco = enderecoService.save(obj.getPessoa().getEndereco());

		Pessoa mae = obj.getMae();
		mae.setEndereco(endereco);
		aluno.setMae(pessoaService.save(mae));

		endereco = null;
		endereco = enderecoService.save(obj.getPessoa().getEndereco());


		Responsavel responsavel = obj.getResponsavel();
		
		Pessoa responsavelPessoa = obj.getResponsavel().getPessoa();
		responsavelPessoa.setEndereco(endereco);
		responsavel.setPessoa(pessoaService.save(responsavelPessoa));
		aluno.setResponsavel(responsavelService.save(responsavel));
		
		System.out.println("Salvando aluno \n Aluno \n"+aluno.toString());

		return alunoService.save(aluno);

	}
	
	private Object funcionarioCreate(Object object) {
		Funcionario obj = (Funcionario) object;
		Funcionario funcionario = new Funcionario();

		Endereco endereco = enderecoService.save(obj.getPessoa().getEndereco());

		Pessoa pessoa = obj.getPessoa();
		pessoa.setEndereco(endereco);
		funcionario.setPessoa(pessoaService.save(pessoa));
		
		Usuario usuario = usuarioService.save(obj.getUsuario());
		funcionario.setUsuario(usuario);
		
		funcionario.setCargaHoraria(obj.getCargaHoraria());
		funcionario.setCpf(obj.getCpf());
		
		return funcionarioService.save(funcionario);

	}

}
