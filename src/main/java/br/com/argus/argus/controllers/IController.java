package br.com.argus.argus.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import br.com.argus.argus.responses.Response;

public interface IController<T> {

	public ResponseEntity<List<T>> index();

	public ResponseEntity<Response<T>> create(T t, BindingResult result);

	public ResponseEntity<Response<T>> show(Long id);

	public ResponseEntity<Response<T>> update(Long id, T t);

	public ResponseEntity<Response<T>> remove(Long id);

	public ResponseEntity<List<T>> delete(Long id);

}
