package br.com.argus.argus.controllers;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.argus.argus.models.Usuario;
import br.com.argus.argus.responses.Response;
import br.com.argus.argus.services.UsuarioService;

/**
 * UsuarioController possuí os endpoint da api onde os recursos estão
 * disponíveis, com diferentes métodos para interagir com os recursos
 *
 */
@RestController // Marca a classe como um controlador, não é preciso adicionar o @RequestBody
@RequestMapping("/api/usuarios") // prefixo da rota, definição da rota padrão
public class UsuarioController {
	/**
	 * Get - pede ao servidor o recusro Post - pede ao servidor que crie um recurso
	 * novo Delete - pede ao servidor que apague um recurso Put - pede ao servidor a
	 * atualização ou edição de um recurso
	 */

	@Autowired // Marcar ponto de injeção na class
	private UsuarioService usuarioService;

//	@GetMapping
//	public String index() {
//		return "Api Funcionando";
//	}

	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> usuarios = usuarioService.findByAll();
		return ResponseEntity.status(HttpStatus.OK).body(usuarios);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Usuario>> findById(@PathVariable long id) {
		Usuario usuario = usuarioService.findById(id);
		Response<Usuario> response = new Response<Usuario>();
		response.setData(usuario);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping
	public ResponseEntity<Response<Usuario>> create(@Valid @RequestBody Usuario usuario, BindingResult result) {
		Response<Usuario> response = new Response<Usuario>();
		
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Usuario obj = this.usuarioService.save(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		response.setData(obj);
		return ResponseEntity.created(uri).body(response);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Response<Usuario>> update(@PathVariable("id") long id,
			@RequestBody Usuario usuario) {
		
//		return usuarioService.findById(id).map(
//				record -> {
//					record.setLogin(usuario.getLogin());
//					record.setSenha(usuario.getSenha());
//					record.setEmail(usuario.getEmail());
//					Usuario updated = usuarioService.save(record);
//					return ResponseEntity.accepted().body(updated);
//				}).orElse(ResponseEntity.notFound().build());
		return null;
	}

//	@PutMapping("/{id}")
//	public void remove(@PathVariable Long id) {
//		
//	}

	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable long id) {

	}

}
