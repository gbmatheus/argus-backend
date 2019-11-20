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

import br.com.argus.argus.facade.FacadeService;
import br.com.argus.argus.models.Curriculo;
import br.com.argus.argus.models.Disciplina;
import br.com.argus.argus.models.Turma;
import br.com.argus.argus.repositories.CurriculoRepository;
import br.com.argus.argus.repositories.DisciplinaRepositories;
import br.com.argus.argus.responses.Response;
import br.com.argus.argus.services.CurriculoService;
import br.com.argus.argus.services.ServiceGeneric;

@RestController
@RequestMapping("/api/curriculos")
public class CurriculoController extends Controller<Curriculo> {

	@Autowired
	CurriculoService curriculoService;

	@Autowired
	FacadeService facadeService;

	@Autowired
	CurriculoRepository curriculoRepository;
	@Autowired
	DisciplinaRepositories disciplinaRepositories;

	@Override
	public ServiceGeneric<Curriculo> getService() {
		return curriculoService;
	}

	@Override
	@GetMapping
	public ResponseEntity<List<Curriculo>> index() {
		return super.index();
	}

	@Override
	@PostMapping
	public ResponseEntity<Response<Curriculo>> create(@Valid @RequestBody Curriculo objetoDto, BindingResult result) {
		return super.create(objetoDto, result);
	}

	@Override
	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Optional<Curriculo>>> show(@PathVariable("id") Long id) {
		System.out.println(id);
		return super.show(id);
	}

	@Override
	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<Curriculo>> update(@PathVariable("id") Long id,
			@Valid @RequestBody Curriculo objetoDto) {
		return super.update(id, objetoDto);
	}

	@Override
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Curriculo>> delete(@PathVariable("id") Long id) {
		return super.delete(id);
	}

	@GetMapping(path = "/{c_id}/disciplinas")
	public ResponseEntity<List<Disciplina>> listDisciplinas(@PathVariable("c_id") Long curriculoID) {
		List<Disciplina> disciplinas = curriculoService.listDisciplina(curriculoID);
		return ResponseEntity.status(HttpStatus.OK).body(disciplinas);

	}

	@PutMapping(path = "/{c_id}/disciplinas/{d_id}") // , produces = "application/json")
	public ResponseEntity<Response<List<Disciplina>>> addDisciplina(@PathVariable("c_id") Long curriculoID,
			@PathVariable("d_id") Long disciplinaID) {
		System.out.println("Adicionnando disciplina \nCurriculo " + curriculoID + "\nDIsciplina" + disciplinaID);
		Response<List<Disciplina>> response = new Response<List<Disciplina>>();
		Curriculo curriculo = facadeService.addDisciplina(curriculoID, disciplinaID);

		response.setData(curriculo.getDisciplinas());

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping(path = "{c_id}/turmas")
	ResponseEntity<List<Turma>> listTurmas(@PathVariable("c_id") Long curriculoID) {
		List<Turma> turmas = curriculoService.listTurma(curriculoID);
		return ResponseEntity.status(HttpStatus.OK).body(turmas);
	}

	@PutMapping(path = "/{c_id}/turmas/{t_id}") // , produces = "application/json")
	public ResponseEntity<Response<Curriculo>> addCurriculo(@PathVariable("c_id") Long curriculoID,
			@PathVariable("t_id") Long turmaID) {
		System.out.println("Adicionanto turma");

		Response<Curriculo> response = new Response<Curriculo>();
		Curriculo curriculo = facadeService.addTurma(curriculoID, turmaID);

		response.setData(curriculo);

		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

}
