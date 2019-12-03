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
import br.com.argus.argus.responses.Response;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController implements IController<Aluno>{// extends Controller<Aluno>{

	@Autowired
	private FacadeService facadeService;
	
//	@Autowired
//	AlunoService alunoService; 
//	
//	@Override
//	public ServiceGeneric<Aluno> getService() {
//		return alunoService;
//	}
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Aluno>> index() {
		List<Aluno> alunos = facadeService.indexAluno();
		return ResponseEntity.status(HttpStatus.OK).body(alunos);
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<Response<Aluno>> create(@Valid @RequestBody Aluno alunoDto, BindingResult result) {
		Response<Aluno> response = new Response<Aluno>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Aluno aluno = this.facadeService.createAluno(alunoDto);
		response.setData(aluno);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(alunoDto.getId())
				.toUri();
		return ResponseEntity.created(uri).body(response);

	}
	
	@CrossOrigin
	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<Aluno>> show(@PathVariable("id") Long id) {
		Response<Aluno> response = new Response<Aluno>();
		Aluno aluno = facadeService.showAluno(id);
		response.setData(aluno);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@CrossOrigin
	@PutMapping(value = "/{id}")
	public ResponseEntity<Response<Aluno>> update(@PathVariable("id") Long id, @RequestBody Aluno alunoDto) {
		Response<Aluno> response = new Response<Aluno>();
		
		Aluno aluno = this.facadeService.updateAluno(id, alunoDto);
		response.setData(aluno);
				
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@CrossOrigin
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Aluno>> remove(@PathVariable Long id) {
//		alunoService.findById(id).map(record -> {
//			alunoService.delete(id);
//			return ResponseEntity.ok().build();
//		}).orElse(ResponseEntity.notFound().build());
		return null;
		
	}

	@CrossOrigin
	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<List<Aluno>> delete(@PathVariable Long id) {
//		alunoService.findById(id).map(record -> {
//			alunoService.delete(id);
//			return ResponseEntity.ok().build();
//		}).orElse(ResponseEntity.notFound().build());
		return null;

	}

}









































