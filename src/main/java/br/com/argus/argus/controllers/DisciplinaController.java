package br.com.argus.argus.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.com.argus.argus.models.Disciplina;
import br.com.argus.argus.responses.Response;
import br.com.argus.argus.services.DisciplinaService;
import br.com.argus.argus.services.ServiceGeneric;

@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinaController extends Controller<Disciplina> {

	@Autowired
	DisciplinaService disciplinaService;

	@Override
	public ServiceGeneric<Disciplina> getService() {
		return disciplinaService;
	}

	@Override
	@GetMapping
	public ResponseEntity<List<Disciplina>> index() {
		return super.index();
	}

	@Override
	@PostMapping
	public ResponseEntity<Response<Disciplina>> create(@Valid @RequestBody Disciplina objetoDto, BindingResult result) {
		System.out.println(objetoDto.toString());
		return super.create(objetoDto, result);
	}

	@Override
	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Optional<Disciplina>>> show(@PathVariable("id") Long id) {
		return super.show(id);
	}

	@Override
	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<Disciplina>> update(@PathVariable("id") Long id, @Valid @RequestBody Disciplina objetoDto) {
		return super.update(id, objetoDto);
	}

	@Override
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Disciplina>> delete(@PathVariable("id") Long id) {
		return super.delete(id);
	}

}
