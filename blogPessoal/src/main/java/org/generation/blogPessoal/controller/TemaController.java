package org.generation.blogPessoal.controller;

import java.util.List;

import org.generation.blogPessoal.model.Tema;
import org.generation.blogPessoal.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // informando que se trata de um controller
@CrossOrigin(origins = "*", allowedHeaders = "*") // liberando a origem e os headers
@RequestMapping("/tema") // para acessar esse controller
public class TemaController {

	@Autowired
	private TemaRepository repository;

	@GetMapping
	public ResponseEntity<List<Tema>> getAll() {
		return ResponseEntity.ok(repository.findAll());

	}

	@GetMapping("/{id}")
	public ResponseEntity<Tema> getById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Tema>> getByDescricao(@PathVariable String descricao) {
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
	}

	@PostMapping // Método post que vai fazer a request via Body e devolver no
	public ResponseEntity<Tema> post(@RequestBody Tema tema) { // ResponseEntity
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}

	@PutMapping
	public ResponseEntity<Tema> put(@RequestBody Tema tema) { // Mesma coisa no método PUT
		return ResponseEntity.ok(repository.save(tema));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) { // Mesma coisa no método Delete
		repository.deleteById(id);
	}

}
