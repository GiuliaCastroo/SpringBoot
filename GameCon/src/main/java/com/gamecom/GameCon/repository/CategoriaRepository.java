package com.gamecom.GameCon.repository;

import java.util.List;

import com.gamecom.GameCon.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	public List<Categoria> findAllByTituloContainingIgnoreCase(String titulo);

}
