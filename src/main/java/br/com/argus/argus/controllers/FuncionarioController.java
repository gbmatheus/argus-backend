package br.com.argus.argus.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.argus.argus.models.Endereco;
import br.com.argus.argus.models.Funcionario;
import br.com.argus.argus.models.Pessoa;
import br.com.argus.argus.models.Usuario;
import br.com.argus.argus.responses.Response;
import br.com.argus.argus.services.EnderecoService;
import br.com.argus.argus.services.FuncionarioService;
import br.com.argus.argus.services.PessoaService;
import br.com.argus.argus.services.UsuarioService;

@Validated
@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private FuncionarioService funcionarioService;

	@Transactional
	@PostMapping
	@ResponseBody
	public ResponseEntity<Response<Funcionario>> create(@Valid @RequestBody Funcionario funcionarioDto,
			BindingResult result) {
		
		Response<Funcionario> response = new Response<Funcionario>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Endereco endereco = funcionarioDto.getPessoa().getEndereco();
		endereco = enderecoService.save(endereco);
		System.out.println("Passou aki");
		System.out.println(endereco.toString());

		Pessoa pessoa = funcionarioDto.getPessoa();
		System.out.println("Passou aki 1");
		System.out.println(pessoa.toString());
//		pessoa.setEndereco(enderecoService.save(funcionarioDto.getPessoa().getEndereco()));
//		pessoa.setEndereco(endereco);
		pessoa = pessoaService.save(pessoa);
		System.out.println("Passou aki 2");

		Usuario usuario = usuarioService.save(funcionarioDto.getUsuario());
		System.out.println(usuario.toString());

		Funcionario funcionario = new Funcionario();
		funcionario.setPessoa(pessoa);
		funcionario.setUsuario(usuario);
		funcionario.setCargaHoraria(funcionarioDto.getCargaHoraria());
		funcionario.setCpf(funcionarioDto.getCpf());
		System.out.println(funcionarioDto.toString());
		System.out.println(funcionario.toString());

		Funcionario obj;
		obj = this.funcionarioService.save(funcionario);
		response.setData(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(funcionario.getId())
				.toUri();
		return ResponseEntity.created(uri).body(response);

	}

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Funcionario>> index() {
		List<Funcionario> funcionarios = funcionarioService.findByAll();
		return ResponseEntity.status(HttpStatus.OK).body(funcionarios);
	}
//
//	@GetMapping(value = "/{id}")
//	@ResponseBody
//	public ResponseEntity<Response<Funcionario>> show(@PathVariable("id") long id) {
//		Funcionario funcionario = funcionarioService.findBy(id);
//		Response<Funcionario> response = new Response<Funcionario>();
//		response.setData(funcionario);
//		return ResponseEntity.status(HttpStatus.OK).body(response);
//	}

}
