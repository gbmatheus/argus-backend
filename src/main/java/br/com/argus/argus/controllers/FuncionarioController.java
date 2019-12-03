package br.com.argus.argus.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.argus.argus.facade.FacadeService;
import br.com.argus.argus.models.Funcionario;
import br.com.argus.argus.responses.Response;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController implements IController<Funcionario> {

	@Autowired
	private FacadeService facadeService;

	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Funcionario>> index() {
		List<Funcionario> funcionarios = facadeService.indexFuncionario();
		return ResponseEntity.status(HttpStatus.OK).body(funcionarios);
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<Response<Funcionario>> create(@Valid @RequestBody Funcionario funcionarioDto,
			BindingResult result) {
		Response<Funcionario> response = new Response<Funcionario>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Funcionario funcionario = this.facadeService.createFuncionario(funcionarioDto);
		response.setData(funcionario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(funcionarioDto.getId())
				.toUri();
		return ResponseEntity.created(uri).body(response);

	}

	@CrossOrigin
	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Funcionario>> show(@PathVariable("id") Long id) {
		Response<Funcionario> response = new Response<Funcionario>();
		Funcionario funcionario = facadeService.showFuncionario(id);
		response.setData(funcionario);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@CrossOrigin
	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<Funcionario>> update(Long id, @Valid Funcionario funcionarioDto) {
		Response<Funcionario> response = new Response<Funcionario>();
		Funcionario funcionario = this.facadeService.updateFuncionario(id, funcionarioDto);
		response.setData(funcionario);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@CrossOrigin
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Funcionario>> remove(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@CrossOrigin
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<List<Funcionario>> delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
