package br.com.argus.argus.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
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

import br.com.argus.argus.models.Usuario;
import br.com.argus.argus.responses.Response;
import br.com.argus.argus.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Usuario>> index() {
		List<Usuario> usuarios = usuarioService.findByAll();
		return ResponseEntity.status(HttpStatus.OK).body(usuarios);
	}

	@CrossOrigin
	@Transactional
	@PostMapping
	public ResponseEntity<Response<Usuario>> create(@Valid @RequestBody Usuario usuario, BindingResult result,
			Model model) {
		Response<Usuario> response = new Response<Usuario>();
		System.out.println(model);

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Usuario obj = this.usuarioService.save(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		response.setData(obj);
		return ResponseEntity.created(uri).body(response);

	}

	@CrossOrigin
	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Optional<Usuario>>> show(@PathVariable("id") long id) {
		Optional<Usuario> usuario = usuarioService.findById(id);
		Response<Optional<Usuario>> response = new Response<Optional<Usuario>>();
		response.setData(usuario);

		if (response.getData() != null) {
			return ResponseEntity.status(HttpStatus.OK).body(response);

		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
	}

	@CrossOrigin
	@PutMapping(value = "/{id}")
	public ResponseEntity<Response<Usuario>> update(@PathVariable("id") long id, @RequestBody Usuario usuario) {
		Response<Usuario> response = new Response<Usuario>();

		return usuarioService.findById(id).map(record -> {
			Usuario updated = usuarioService.save(usuario);
			response.setData(updated);
			return ResponseEntity.accepted().body(response);
		}).orElse(ResponseEntity.notFound().build());

	}

	@CrossOrigin
	@DeleteMapping(path = "/{id}")
	public void remove(@PathVariable Long id) {

	}

	@CrossOrigin
	@DeleteMapping(path = "/delete/{id}")
	public void destroy(@PathVariable long id) {

	}
}
