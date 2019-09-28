package br.com.argus.argus.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.argus.argus.models.Usuario;
import br.com.argus.argus.services.UsuarioService;

/**
 * UsuarioController
 *  possuí os endpoint da api
 * 	onde os recursos estão disponíveis,
 *  com diferentes métodos para interagir com os recursos
 *
 */
@RestController
@RequestMapping("/usuario")//prefixo da rota, definição da rota padrão
public class UsuarioController {
	/**
	 * Get - pede ao servidor o recusro
	 * Post - pede ao servidor que crie um recurso novo
	 * Delete - pede ao servidor que apague um recurso
	 * Put - pede ao servidor a atualização ou edição de um recurso
	 */
	
	@Autowired
	private UsuarioService usuarioService;
	
//	@GetMapping
//	public String index() {
//		return "Api Funcionando";
//	}
	
	/**
	 * Método Get
	 * 	index - retorna todos do usuários
	 * @return
	 */
	@GetMapping
	public List<Usuario> findAll(){
		return usuarioService.findByAll();
	}
	
	/**
	 * Método Post
	 * 	recebe um usuário na requisição, 
	 * 	retorna um usuário criado do convertido em json
	 * @param usuario
	 * @return usuario
	 */
	@PostMapping
	public ResponseEntity<Usuario> create(@Valid @RequestBody Usuario usuario){
		Usuario obj = usuarioService.save(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
		
	}
	

}
