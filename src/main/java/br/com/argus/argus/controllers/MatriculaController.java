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

import br.com.argus.argus.models.Matricula;
import br.com.argus.argus.responses.Response;
import br.com.argus.argus.services.MatriculaService;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

	@Autowired
	MatriculaService matriculaService;

	@GetMapping
	ResponseEntity<List<Matricula>> index() {
		List<Matricula> matriculas = matriculaService.findByAll();
		return ResponseEntity.status(HttpStatus.OK).body(matriculas);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<Matricula>> show(@PathVariable("id") long id) {
		Matricula matricula = matriculaService.findBy(id);
		Response<Matricula> response = new Response<Matricula>();
		response.setData(matricula);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@Transactional
	@PostMapping
	@ResponseBody
	public ResponseEntity<Response<Matricula>> create(@Valid @RequestBody Matricula matricula, BindingResult result) {

		Response<Matricula> response = new Response<Matricula>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Matricula obj = matriculaService.save(matricula);
		response.setData(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(matricula.getId())
				.toUri();
		return ResponseEntity.created(uri).body(response);
	}

}
