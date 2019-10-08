package br.com.argus.argus.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.argus.argus.dtos.FuncionarioDto;
import br.com.argus.argus.models.Funcionario;
import br.com.argus.argus.responses.Response;
import br.com.argus.argus.services.FuncionarioService;

@RestController
@RequestMapping("api/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> findAll() {
		List<Funcionario> funcionarios = funcionarioService.findByAll();
		return ResponseEntity.status(HttpStatus.OK).body(funcionarios);
	}

	@PostMapping
	public ResponseEntity<Response<Funcionario>> create(@Valid @RequestBody FuncionarioDto funcionarioDto, BindingResult result) {
		Response<Funcionario> response = new Response<Funcionario>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Funcionario obj = this.funcionarioService.save(funcionarioDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(funcionarioDto.getId()).toUri();
		response.setData(obj);
		return ResponseEntity.created(uri).body(response);

	}
}
