package org.generation.blogPessoal.controller;

import java.util.List;

import org.generation.blogPessoal.model.postagem;
import org.generation.blogPessoal.repository.PostagemRepository;
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

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagemController {

		@Autowired
		private PostagemRepository repository;
	
		@GetMapping
		public ResponseEntity<List<postagem>> GetALL(){
			
				return ResponseEntity.ok(repository.findAll());
		}

		@GetMapping("/{id}")
		public ResponseEntity<postagem> getById (@PathVariable long id) { //CAPTURA A VARIAVÉL
			return repository.findById(id)                        //CHAMA MÉTODO E DEVOLVE  O OBJETO
					.map(resposta -> ResponseEntity.ok(resposta))     //OBJETO DO TIPO POSTAGEM
					.orElse(ResponseEntity.notFound().build());			// POSTAGEM NO CASO DO OBT N EXISTIR OU TIVER COM ERRO
		}
		
		
		
		// METÓDO GET - OBTER OU DESENVOLVER O RECURSO 
		@GetMapping ("/titulo/{titulo}")    //Paramentro para busca
		public ResponseEntity<List<postagem>> getByTitulo(@PathVariable String titulo){   //pegar a variavél no caminho da url
			return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo)); // método para não levar consideração maisculo ou minusculo
			
		}
		
		
		// MÉTODO POST - INSERIR INFORMAÇÃO 
		
		
		@PostMapping
		public ResponseEntity<postagem> post (@RequestBody postagem postagem) {     //é o recurso que vai pegar a informação pelo corpo da requisiçaõ 
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
			
		}
		
// MÉTODO PUT- ATUALIZAR INFORMAÇÃO 
		
		@PutMapping
		public ResponseEntity<postagem> put (@RequestBody postagem postagem) {     //o método foi alterado de post para put
			return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));   // ele irá pegar o método e ... dentro dele usar o recuso para receber o parametro (postagem)
			                                                                                // e passar o retorno de save - postagem (Eu chamo o mesmo método por que o enviar é semelhante)   
		}
		
		// METODO DELETE	- semelhante ao get com o paramentro que será deletado 
		
		@DeleteMapping ("/{id}")
		public void delete (@PathVariable long id) {      // parametro para deletar a informação no caso o ID
			repository.deleteById(id);                      
			
			
		}
		
		
} 
