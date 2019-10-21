package br.com.argus.argus.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.argus.argus.exception.ValidarColunaException;
import br.com.argus.argus.responses.Response;
import br.com.argus.argus.services.GenericService;

@RestController
public abstract class ControllerGeneric<T> {

//	GenericService<T> service;

	public abstract GenericService<T> getService();

	@GetMapping
	public ResponseEntity<List<T>> index() {
		List<T> objetos = getService().findByAll();
		return ResponseEntity.status(HttpStatus.OK).body(objetos);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Response<T>> show(@PathVariable("id") long id) {
		T obj = getService().findBy(id);
		Response<T> response = new Response<T>();
		response.setData(obj);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping
	public ResponseEntity<Response<T>> create(@Valid @RequestBody T objetoDto, BindingResult result) {
		Response<T> response = new Response<T>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		T obj;

		try {
			obj = this.getService().save(objetoDto);
			response.setData(obj);
		} catch (ValidarColunaException e) {
			e.printStackTrace();
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand().toUri();
		return ResponseEntity.created(uri).body(response);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Response<T>> update(@PathVariable("id") long id, @RequestBody T objetoDto) {
//			Response<T> response = new Response<T>();

//			return getService().findById(id).map(record -> {
//				T updated = getService().save(T);
//				response.setData(updated);
//				return ResponseEntity.accepted().body(response);
//			}).orElse(ResponseEntity.notFound().build());
		return ResponseEntity.notFound().build();

	}

	@DeleteMapping(path = "/{id}")
	public void remove(@PathVariable long id) {

	}

	@DeleteMapping(path = "/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) {
		return getService().findById(id).map(record -> {
			getService().deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());

	}

}
