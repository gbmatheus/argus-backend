package br.com.argus.argus.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.argus.argus.exception.ValidarColunaException;
import br.com.argus.argus.models.Funcionario;
import br.com.argus.argus.responses.Response;
import br.com.argus.argus.services.FuncionarioService;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	

	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Funcionario>> index() {
		List<Funcionario> funcionarios = funcionarioService.findByAll();
		return ResponseEntity.status(HttpStatus.OK).body(funcionarios);
	}

	@GetMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<Response<Funcionario>> show(@PathVariable("id") long id) {
		Funcionario funcionario = funcionarioService.findBy(id);
		Response<Funcionario> response = new Response<Funcionario>();
		response.setData(funcionario);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping
	@ResponseBody
	public ResponseEntity<Response<Funcionario>> create(@Valid @RequestBody Funcionario funcionario, BindingResult result) {
		Response<Funcionario> response = new Response<Funcionario>();
		
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
				
		Funcionario obj;
		try {
			obj = this.funcionarioService.save(funcionario);
			response.setData(obj);
		} catch (ValidarColunaException e) {
			e.printStackTrace();
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(funcionario.getId()).toUri();
		return ResponseEntity.created(uri).body(response);

	}

	@PutMapping(value = "/{id}")
	@ResponseBody
	public ResponseEntity<Response<Funcionario>> update(@PathVariable("id") long id, @RequestBody Funcionario funcionario) {
//		Response<Funcionario> response = new Response<Funcionario>();
//
//		return funcionarioService.findById(id).map(record -> {
//			Funcionario updated = funcionarioService.save(funcionario);
//			response.setData(updated);
//			return ResponseEntity.accepted().body(response);
//		}).orElse(ResponseEntity.notFound().build());
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping(path = "/{id}")
	@ResponseBody
	public void remove(@PathVariable("id") long id) {

	}

	@DeleteMapping(path = "/delete/{id}")
	@ResponseBody
	public ResponseEntity<?> delete(@PathVariable long id) {
		return funcionarioService.findById(id).map(record -> {
			funcionarioService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());

	}
	
}
