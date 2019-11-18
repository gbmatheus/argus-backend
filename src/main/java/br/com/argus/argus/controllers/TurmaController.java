package br.com.argus.argus.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.argus.argus.models.Turma;
import br.com.argus.argus.responses.Response;
import br.com.argus.argus.services.ServiceGeneric;
import br.com.argus.argus.services.TurmaService;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController extends Controller<Turma> {

	@Autowired
	TurmaService turmaService;

	@Override
	public ServiceGeneric<Turma> getService() {
		return turmaService;
	}

	@Override
	@GetMapping
	public ResponseEntity<List<Turma>> index() {
		return super.index();
	}

	@PostMapping
	public ResponseEntity<Response<Turma>> create(@Valid @RequestBody Turma objetoDto, BindingResult result) {
		return super.create(objetoDto, result);
	}

	@Override
	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Optional<Turma>>> show(@PathVariable("id") Long id) {
		return super.show(id);
	}

}
