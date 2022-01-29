package com.gamecom.GameCon.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties; //IMPORTANDO AS BIBLIOTECAS//

	@Entity // CRIANDO A TABELA DO NOSSO PRODUTO
	@Table(name = "tb_produto")
	public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_produto;

	@NotNull // INFORMANDO QUE NÃO PODE SER NULO
	@Size(min = 5, max = 100)
	private String titulo;

	@NotNull // INFORMANDO QUE NÃO PODE SER NULO
	@Size(min = 5, max = 100)
	private String descricao;

	@UpdateTimestamp
	private LocalDateTime date;

	@ManyToOne // DEFININDO O TIPO DA NOSSA TABELA
	@JsonIgnoreProperties("produto") // IGNORANDO AS PROPRIEDADES DE JSON
	private Categoria categoria;

	// PUXANDO OS GET AND SETTERS//

	public long getId_produto() {
		return id_produto;
	}

	public void setId_produto(long id_produto) {
		this.id_produto = id_produto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
