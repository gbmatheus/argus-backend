package br.com.argus.argus.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.argus.argus.models.Turma;
import br.com.argus.argus.responses.Response;
import br.com.argus.argus.services.TurmaService;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {

	@Autowired
	TurmaService turmaService;

	@GetMapping
	ResponseEntity<List<Turma>> index() {
		List<Turma> turmas = turmaService.findByAll();
		return ResponseEntity.status(HttpStatus.OK).body(turmas);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<Turma>> show(@PathVariable("id") long id) {
		Turma turma = turmaService.findBy(id);
		Response<Turma> response = new Response<Turma>();
		response.setData(turma);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@Transactional
	@PostMapping
	@ResponseBody
	public ResponseEntity<Response<Turma>> create(@Valid @RequestBody Turma turma, BindingResult result) {

		Response<Turma> response = new Response<Turma>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Turma obj = turmaService.save(turma);
		response.setData(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(turma.getId()).toUri();
		return ResponseEntity.created(uri).body(response);
	}

}
