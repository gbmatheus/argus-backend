package br.com.argus.argus.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.argus.argus.dtos.AlunoDto;
import br.com.argus.argus.models.Aluno;
import br.com.argus.argus.responses.Response;
import br.com.argus.argus.services.AlunoService;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {
	
	@Autowired
	AlunoService alunoService;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> findByAll(){
		 List<Aluno> alunos = alunoService.findByAll();
		 return ResponseEntity.status(HttpStatus.OK).body(alunos);
	}
	
	@PostMapping
	public ResponseEntity<Response<Aluno>> create(@Valid @RequestBody AlunoDto alunoDto, BindingResult result){
		Response<Aluno> response = new Response<Aluno>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Aluno obj = this.alunoService.save(alunoDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();	
		response.setData(obj);
		return ResponseEntity.created(uri).body(response);
		
	}

}
