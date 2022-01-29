package com.gamecom.GameCon.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size; //IMPORTANDO AS BIBLIOTECAS//

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@Entity
	@Table(name = "tb_categoria") // CRIANDO A TABELA CATEGORIA
	public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; // RESTREANDO PELO ID

	@NotNull // DEFININDO SE VAI SER NULO E O TAMANHO
	@Size(min = 5, max = 100)
	private String titulo;

	@NotNull
	@Size(min = 5, max = 100)
	private String descricao;

	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL) // DEFININDO O RELACIONAMENTO DA TABELAs
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
}