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

import br.com.argus.argus.models.Disciplina;
import br.com.argus.argus.responses.Response;
import br.com.argus.argus.services.DisciplinaService;

@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinaController {

	@Autowired
	DisciplinaService disciplinaService;

	@GetMapping
	public ResponseEntity<List<Disciplina>> index() {
		List<Disciplina> disciplinas = disciplinaService.findByAll();
		return ResponseEntity.status(HttpStatus.OK).body(disciplinas);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<Disciplina>> show(@PathVariable("id") long id) {
		Disciplina disciplina = disciplinaService.findBy(id);
		Response<Disciplina> response = new Response<Disciplina>();
		response.setData(disciplina);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@Transactional
	@PostMapping
	@ResponseBody
	public ResponseEntity<Response<Disciplina>> create(@Valid @RequestBody Disciplina disciplina,
			BindingResult result) {

		Response<Disciplina> response = new Response<Disciplina>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Disciplina obj = disciplinaService.save(disciplina);
		response.setData(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(disciplina.getId())
				.toUri();
		return ResponseEntity.created(uri).body(response);
	}

}
