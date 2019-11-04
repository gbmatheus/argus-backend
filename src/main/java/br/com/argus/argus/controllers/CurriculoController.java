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

import br.com.argus.argus.models.Curriculo;
import br.com.argus.argus.responses.Response;
import br.com.argus.argus.services.CurriculoService;

@RestController
@RequestMapping("/api/curriculos")
public class CurriculoController {

	@Autowired
	CurriculoService curriculoService;

	@GetMapping
	ResponseEntity<List<Curriculo>> index() {
		List<Curriculo> curriculos = curriculoService.findByAll();
		return ResponseEntity.status(HttpStatus.OK).body(curriculos);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Curriculo>> show(@PathVariable("id") long id) {
		Curriculo curriculo = curriculoService.findBy(id);
		Response<Curriculo> response = new Response<Curriculo>();
		response.setData(curriculo);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@Transactional
	@PostMapping
	@ResponseBody
	public ResponseEntity<Response<Curriculo>> create(@Valid @RequestBody Curriculo curriculo,
			BindingResult result) {

		Response<Curriculo> response = new Response<Curriculo>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Curriculo obj = curriculoService.save(curriculo);
		response.setData(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(curriculo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(response);
	}

}
