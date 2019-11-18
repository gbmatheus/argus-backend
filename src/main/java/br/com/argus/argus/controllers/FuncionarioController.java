package br.com.argus.argus.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.argus.argus.models.Funcionario;
import br.com.argus.argus.responses.Response;
import br.com.argus.argus.services.FuncionarioService;
import br.com.argus.argus.services.PessoaService;
import br.com.argus.argus.services.UsuarioService;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private FuncionarioService funcionarioService;

	@CrossOrigin // Notação cors para ter acesso a api via url
	@Transactional
	@PostMapping
	@ResponseBody
	public ResponseEntity<Response<Funcionario>> create(@Valid @RequestBody Funcionario funcionarioDto,
			BindingResult result) {
		System.out.println(funcionarioDto.toString());
		Response<Funcionario> response = new Response<Funcionario>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Funcionario funcionario = new Funcionario();

		System.out.println("Settando dados pessoais de funcionario");
		funcionario.setPessoa(pessoaService.save(funcionarioDto.getPessoa()));
		System.out.println("Settou pessoa");
		System.out.println("Settando do usuario do funcionario");
		funcionario.setUsuario(usuarioService.save(funcionarioDto.getUsuario()));
		System.out.println("Settou usuario");
		funcionario.setCargaHoraria(funcionarioDto.getCargaHoraria());
		
		funcionario.setCpf(funcionarioDto.getCpf());
		System.out.println("Settou dados do funcionario");

		Funcionario obj = this.funcionarioService.save(funcionario);
		response.setData(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(funcionario.getId())
				.toUri();
		return ResponseEntity.created(uri).body(response);

	}

	@CrossOrigin
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
