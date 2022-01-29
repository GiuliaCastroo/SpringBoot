package org.generation.blogPessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_tema")
public class Tema { // criando a nossa model tema

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Para gerar a identidade da tabela
	private long id;

	private String descricao; // adicionando caracteristicas como descrição e id para tema

	@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL) // Designação da tabela de um para muitas e comando para
																// ela não ser deletada
	@JsonIgnoreProperties("tema")
	private List<postagem> postagem; // criando a lista de postagens

	public long getId() { // add gets and seters
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<postagem> postagem) {
		this.postagem = postagem;
	}

}
