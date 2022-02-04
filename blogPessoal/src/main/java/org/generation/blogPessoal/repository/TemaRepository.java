package org.generation.blogPessoal.repository;

import java.util.List;

import org.generation.blogPessoal.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemaRepository extends JpaRepository< Tema, Long> {                                           //CRIANDO A INTERFACE DO NOSSO REPOSITORIO PARA O TEMA
		public List <Tema> findAllByDescricaoContainingIgnoreCase(String descricao );

}
