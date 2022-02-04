package org.generation.blogPessoal.repository;

import java.util.List;

import java.util.Optional;

import org.generation.blogPessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findByUsuario(String usuario); // Método para achar pelo usuario -
															// Opcional pos pode vir nulo

	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);

}
