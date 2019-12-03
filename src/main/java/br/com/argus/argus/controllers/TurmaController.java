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
import br.com.argus.argus.models.Aluno;
import br.com.argus.argus.models.Turma;
import br.com.argus.argus.responses.Response;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController implements IController<Turma> {

	@Autowired
	FacadeService facadeService;

	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Turma>> index() {
		List<Turma> turmas = facadeService.indexTurma();
		return ResponseEntity.status(HttpStatus.OK).body(turmas);
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<Response<Turma>> create(@Valid @RequestBody Turma turmaDto, BindingResult result) {
		Response<Turma> response = new Response<Turma>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Turma turma = this.facadeService.createTurma(turmaDto);
		response.setData(turma);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(turmaDto.getId())
				.toUri();
		return ResponseEntity.created(uri).body(response);

	}

	@CrossOrigin
	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<Turma>> show(@PathVariable("id") Long id) {
		Response<Turma> response = new Response<Turma>();
		Turma turma = facadeService.showTurma(id);
		response.setData(turma);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@CrossOrigin
	@PutMapping(value = "/{id}")
	public ResponseEntity<Response<Turma>> update(@PathVariable("id") Long id, @RequestBody Turma turmaDto) {
		Response<Turma> response = new Response<Turma>();

		Turma Turma = this.facadeService.updateTurma(id, turmaDto);
		response.setData(Turma);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@CrossOrigin
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Turma>> remove(@PathVariable Long id) {
//		TurmaService.findById(id).map(record -> {
//			TurmaService.delete(id);
//			return ResponseEntity.ok().build();
//		}).orElse(ResponseEntity.notFound().build());
		return null;

	}

	@CrossOrigin
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<List<Turma>> delete(@PathVariable Long id) {
//		TurmaService.findById(id).map(record -> {
//			TurmaService.delete(id);
//			return ResponseEntity.ok().build();
//		}).orElse(ResponseEntity.notFound().build());
		return null;

	}

	@CrossOrigin
	@GetMapping(path = "/{id}/alunos")
	public ResponseEntity<List<Aluno>> indexAlunos(@PathVariable("id") Long id) {
		List<Aluno> alunos = facadeService.listAlunos(id);
		return ResponseEntity.status(HttpStatus.OK).body(alunos);
	}

	@CrossOrigin
	@PutMapping(path = "/{t_id}/alunos")
	public ResponseEntity<Response<List<Aluno>>> matricular(@PathVariable("t_id") Long turmaID,
			@Valid @RequestBody Aluno alunoDto) {
		Response<List<Aluno>> response = new Response<List<Aluno>>();
		Turma turma = this.facadeService.matricular(turmaID, alunoDto);

		response.setData(turma.getAlunos());

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@CrossOrigin
	@PutMapping(path = "/{t_id}/alunos/{a_id}")
	public ResponseEntity<Response<List<Aluno>>> matricula(@PathVariable("t_id") Long turmaID,
			@PathVariable("a_id") Long alunoID) {
		Response<List<Aluno>> response = new Response<List<Aluno>>();
		Turma turma = this.facadeService.matricular(turmaID, alunoID);

		response.setData(turma.getAlunos());

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@CrossOrigin
	@GetMapping(path = "/{id}/alunos")
	public ResponseEntity<List<Aluno>> indexDisciplinas(@PathVariable("id") Long id) {
		List<Aluno> alunos = facadeService.listAlunos(id);
		return ResponseEntity.status(HttpStatus.OK).body(alunos);
	}

	@CrossOrigin
	@PutMapping(path = "/{t_id}/alunos")
	public ResponseEntity<Response<List<Aluno>>> registrarDisciplina(@PathVariable("t_id") Long turmaID,
			@Valid @RequestBody Aluno alunoDto) {
		Response<List<Aluno>> response = new Response<List<Aluno>>();
		Turma turma = this.facadeService.matricular(turmaID, alunoDto);

		response.setData(turma.getAlunos());

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@CrossOrigin
	@PutMapping(path = "/{t_id}/disciplinas/{d_id}")
	public ResponseEntity<Response<List<Aluno>>> registrarDisciplina(@PathVariable("t_id") Long turmaID,
			@PathVariable("d_id") Long disciplinaID) {
		Response<List<Aluno>> response = new Response<List<Aluno>>();
		Turma turma = this.facadeService.matricular(turmaID, disciplinaID);

		response.setData(turma.getAlunos());

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
