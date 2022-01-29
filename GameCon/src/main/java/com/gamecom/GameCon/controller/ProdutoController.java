package com.gamecom.GameCon.controller;

import java.util.List;

import javax.validation.Valid;

import org.generation.GameCon.model.Produto;
import org.generation.GameCon.repository.ProdutoRepository;
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


//IMPORTANDO BIBLIOTECAS//


@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;        //CRIANDO REPOSITORIO

	@GetMapping
	public ResponseEntity<List<Produto>> getAll() {
		return ResponseEntity.ok(repository.findAll());

	}

	@GetMapping("/{id}")                    //MAPEANDO PELO ID
	public ResponseEntity<Produto> getById(@PathVariable long id) {
		return repository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Produto>> getByTitulo(@PathVariable String titulo)

	{
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}

	@PostMapping                 //METODO POST//
	public ResponseEntity<Produto> postProduto(@Valid @RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}

	@PutMapping              //METODO PUT//
	public ResponseEntity<Produto> putProduto(@Valid @RequestBody Produto produto) {
		return repository.findById(produto.getId_produto())
				.map(resposta -> ResponseEntity.ok().body(repository.save(produto)))
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")                  //METODO DELETE//
	public ResponseEntity<?> deleteProduto(@PathVariable long id) {
		return repository.findById(id).map(resposta -> {
			repository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());
	}
}