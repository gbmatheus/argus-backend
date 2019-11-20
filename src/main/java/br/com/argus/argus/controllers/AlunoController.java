package br.com.argus.argus.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.argus.argus.models.Aluno;
import br.com.argus.argus.responses.Response;
import br.com.argus.argus.services.AlunoService;
import br.com.argus.argus.services.EnderecoService;
import br.com.argus.argus.services.PessoaService;
import br.com.argus.argus.services.ResponsavelService;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

	@Autowired
	EnderecoService enderecoService;

	@Autowired
	PessoaService pessoaService;

	@Autowired
	AlunoService alunoService;

	@Autowired
	ResponsavelService responsavelService;

	@Transactional
	@PostMapping
	public ResponseEntity<Response<Aluno>> create(@Valid @RequestBody Aluno alunoDto, BindingResult result) {
		Response<Aluno> response = new Response<Aluno>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		Aluno aluno = new Aluno();

		System.out.println("Settaando dados pessoais de aluno");
		aluno.setPessoa(pessoaService.save(alunoDto.getPessoa()));
		System.out.println("Settou aluno");
		System.out.println("Settando dados do pai");
		aluno.setPai(pessoaService.save(alunoDto.getPai()));
		System.out.println("Settou pai");
		System.out.println("Settando dados do mae");
		aluno.setMae(pessoaService.save(alunoDto.getMae()));
		System.out.println("Settou mae");
		System.out.println("Settando dados do responsavel");
		aluno.setResponsavel(responsavelService.save(alunoDto.getResponsavel()));
		System.out.println("Settou responsavel");

		Aluno obj = this.alunoService.save(alunoDto);
		response.setData(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(alunoDto.getId())
				.toUri();
		return ResponseEntity.created(uri).body(response);

	}

	@GetMapping
	public ResponseEntity<List<Aluno>> index() {
		List<Aluno> alunos = alunoService.findByAll();
		return ResponseEntity.status(HttpStatus.OK).body(alunos);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<Aluno>> show(@PathVariable("id") long id) {
		Aluno aluno = alunoService.findBy(id);
		Response<Aluno> response = new Response<Aluno>();
		response.setData(aluno);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Response<Aluno>> update(@PathVariable("id") long id, @RequestBody Aluno aluno) {
//		Response<Aluno> response = new Response<Aluno>();

//		return alunoService.findById(id).map(record -> {
//			Aluno updated = alunoService.save(aluno);
//			response.setData(updated);
//			return ResponseEntity.accepted().body(response);
//		}).orElse(ResponseEntity.notFound().build());
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping(path = "/{id}")
	public void remove(@PathVariable long id) {

	}

	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) {
		return alunoService.findById(id).map(record -> {
			alunoService.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());

	}

}
