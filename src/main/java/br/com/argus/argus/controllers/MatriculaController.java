package br.com.argus.argus.controllers;

import java.util.List;
import java.util.Optional;

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

import br.com.argus.argus.models.Matricula;
import br.com.argus.argus.responses.Response;
import br.com.argus.argus.services.MatriculaService;
import br.com.argus.argus.services.ServiceGeneric;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController extends Controller<Matricula> {

	@Autowired
	MatriculaService matriculaService;

	@Override
	public ServiceGeneric<Matricula> getService() {
		return matriculaService;
	}

	@Override
	@GetMapping
	public ResponseEntity<List<Matricula>> index() {
		return super.index();
	}

	@Override
	@PostMapping
	public ResponseEntity<Response<Matricula>> create(@Valid Matricula objetoDto, BindingResult result) {
		return super.create(objetoDto, result);
	}

	@Override
	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Optional<Matricula>>> show(@PathVariable("id") Long id) {
		return super.show(id);
	}

	@Override
	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<Matricula>> update(@PathVariable("id") Long id,
			@Valid @RequestBody Matricula objetoDto) {
		return super.update(id, objetoDto);
	}

	@Override
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Matricula>> delete(@PathVariable("id") Long id) {
		return super.delete(id);
	}

	@PutMapping(path = "/{t_id}/alunos/{a_id}")
	public ResponseEntity<Response<Matricula>> registerMatricula(@PathVariable("t_id") Long turmaID,
			@PathVariable("id") Long alunoID) {
		Response<Matricula> response = new Response<Matricula>();
		Matricula matricula = matriculaService.registerMatricula(turmaID, alunoID);

		response.setData(matricula);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);

	}

}
