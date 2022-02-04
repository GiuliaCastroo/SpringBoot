
package org.generation.blogPessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.generation.blogPessoal.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest (webEnvironment = WebEnvironment.RANDOM_PORT )   //Indica que é uma classe teste e no caso da 8080 estar ocupada
@TestInstance(TestInstance.Lifecycle.PER_CLASS)                 //ele direciona para outra porta
public class UsuarioRepositoryTest {

		@Autowired
		private UsuarioRepository usuarioRepository;
		
		@BeforeAll //inicializa o objeto
		void start() {
			
			usuarioRepository.save(new Usuario(0L,"João da Silva","joao@email.com.br","123456"));
			usuarioRepository.save(new Usuario(0L,"Manuela da Silva","manuela@email.com.br","123456"));	
			usuarioRepository.save(new Usuario(0L,"Adriana da Silva","adriana@email.com.br","123456"));
			usuarioRepository.save(new Usuario(0L,"Paulo Antunes","paulo@email.com.br","123456"));	
		}

			@Test                                                         // indica que este método executará um teste    
			@DisplayName ("Retorna 3 usuários")                   //configura uma mensagem que será exibida ao invés do nome do método          
			public void deveRetornarTresUsuarios() {
				
				List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
				assertEquals(3, listaDeUsuarios.size());
				assertTrue(listaDeUsuarios.get(0).getNome().equals("João da Silva"));
				assertTrue(listaDeUsuarios.get(1).getNome().equals("Manuela da Silva"));
				assertTrue(listaDeUsuarios.get(2).getNome().equals("Adriana da Silva"));
				
			}

}
