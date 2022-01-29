package org.generation.blogPessoal.repository;

import java.util.List;

import org.generation.blogPessoal.model.postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<postagem,Long>{
		public List<postagem> findAllByTituloContainingIgnoreCase (String titulo);


}
