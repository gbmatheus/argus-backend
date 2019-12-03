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
import br.com.argus.argus.models.Disciplina;
import br.com.argus.argus.responses.Response;

@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinaController implements IController<Disciplina>{

	@Autowired
	FacadeService facadeService;

	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Disciplina>> index() {
		List<Disciplina> registros = facadeService.indexDisciplina();
		return ResponseEntity.status(HttpStatus.OK).body(registros);
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<Response<Disciplina>> create(@Valid @RequestBody Disciplina disciplinaDto, BindingResult result) {
		Response<Disciplina> response = new Response<Disciplina>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Disciplina disciplina = this.facadeService.createDisciplina(disciplinaDto);
		response.setData(disciplina);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(disciplinaDto.getId())
				.toUri();
		return ResponseEntity.created(uri).body(response);

	}

	@CrossOrigin
	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<Disciplina>> show(@PathVariable("id") Long id) {
		Response<Disciplina> response = new Response<Disciplina>();
		Disciplina disciplina = facadeService.showDisciplina(id);
		response.setData(disciplina);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}


	@CrossOrigin
	@PutMapping(value = "/{id}")
	public ResponseEntity<Response<Disciplina>> update(@PathVariable("id") Long id, @RequestBody Disciplina disciplinaDto) {
		Response<Disciplina> response = new Response<Disciplina>();
		
		Disciplina disciplina = this.facadeService.updateDisciplina(id, disciplinaDto);
		response.setData(disciplina);
				
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}


	@CrossOrigin
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Disciplina>> remove(@PathVariable Long id) {
//		DisciplinaService.findById(id).map(record -> {
//			DisciplinaService.delete(id);
//			return ResponseEntity.ok().build();
//		}).orElse(ResponseEntity.notFound().build());
		return null;
		
	}

	@CrossOrigin
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<List<Disciplina>> delete(@PathVariable Long id) {
//		DisciplinaService.findById(id).map(record -> {
//			DisciplinaService.delete(id);
//			return ResponseEntity.ok().build();
//		}).orElse(ResponseEntity.notFound().build());
		return null;

	}
	
}










































