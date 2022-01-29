package com.gamecom.GameCon.repository;

import java.util.List;

import com.gamecom.GameCon.model.Produto;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	public List<Produto> findAllByTituloContainingIgnoreCase(String titulo);

}
