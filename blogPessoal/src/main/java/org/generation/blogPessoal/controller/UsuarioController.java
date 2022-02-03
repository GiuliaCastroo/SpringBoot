package org.generation.blogPessoal.controller;

import java.util.Optional;

import org.generation.blogPessoal.model.UserLogin;
import org.generation.blogPessoal.model.Usuario;
import org.generation.blogPessoal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController    //indica que a classe se trata de um controller
@RequestMapping ("/usuarios")     //o caminho que nós vamos acessar
@CrossOrigin(origins = "*", allowedHeaders = "*")   //As origens e a informação q será aceita
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping ("/logar")
	public ResponseEntity<UserLogin> Authenticatiion (@RequestBody Optional <UserLogin> user){
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());		
	}
	

	@PostMapping ("/cadastrar")
	public ResponseEntity<Optional<Usuario>> Post(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(usuarioService.CadastrarUsuario(usuario));
		
		
	}
	
	
	
	
}
