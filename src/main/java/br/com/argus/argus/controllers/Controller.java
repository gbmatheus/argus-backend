package br.com.argus.argus.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.argus.argus.responses.Response;
import br.com.argus.argus.services.ServiceGeneric;

public abstract class Controller<T> {

	@Autowired
	public abstract ServiceGeneric<T> getService();

	public ResponseEntity<List<T>> index() {
		List<T> registros = getService().findByAll();
		return ResponseEntity.status(HttpStatus.OK).body(registros);
	}

	public ResponseEntity<Response<T>> create(@Valid T objetoDto, BindingResult result) {
		Response<T> response = new Response<T>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

//		T t = this.serviceGeneric.save(objetoDto);
		T t = this.getService().save(objetoDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objetoDto).toUri();

		response.setData(t);
		return ResponseEntity.created(location).body(response);

	}

	public ResponseEntity<Response<T>> show(Long id) {
		Response<T> response = new Response<T>();
		Optional<T> t = getService().findById(id);

		if (!t.isPresent()) {
			ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
		}
		response.setData(t.get());
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	public ResponseEntity<Response<T>> update(Long id, @Valid T objetoDto) {

		Response<T> response = new Response<T>();
		T t = this.getService().update(id, objetoDto);

		response.setData(t);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	public ResponseEntity<Response<T>> delete(Long id) {
		Response<T> response = new Response<T>();
		T t = getService().findById(id).get();
		getService().delete(id);

		response.setData(t);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
