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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.argus.argus.exception.ValidarColunaException;
import br.com.argus.argus.models.Aluno;
import br.com.argus.argus.responses.Response;
import br.com.argus.argus.services.AlunoService;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

	@Autowired
	AlunoService alunoService;

	@GetMapping
	public ResponseEntity<List<Aluno>> index() {
		List<Aluno> alunos = alunoService.findByAll();
		return ResponseEntity.status(HttpStatus.OK).body(alunos);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<Aluno>> show(@PathVariable("id") long id) {
		Aluno aluno = alunoService.findBy(id);
		Response<Aluno> response = new Response<Aluno>();
		response.setData(aluno);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping
	public ResponseEntity<Response<Aluno>> create(@Valid @RequestBody Aluno aluno, BindingResult result) {
		Response<Aluno> response = new Response<Aluno>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Aluno obj;

		try {
			obj = this.alunoService.save(aluno);
			response.setData(obj);
		} catch (ValidarColunaException e) {
			e.printStackTrace();
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aluno.getId()).toUri();
		return ResponseEntity.created(uri).body(response);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Response<Aluno>> update(@PathVariable("id") long id, @RequestBody Aluno aluno) {
//		Response<Aluno> response = new Response<Aluno>();

//		return alunoService.findById(id).map(record -> {
//			Aluno updated = alunoService.save(aluno);
//			response.setData(updated);
//			return ResponseEntity.accepted().body(response);
//		}).orElse(ResponseEntity.notFound().build());
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping(path = "/{id}")
	public void remove(@PathVariable long id) {

	}

	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) {
		return alunoService.findById(id).map(record -> {
			alunoService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());

	}

}
