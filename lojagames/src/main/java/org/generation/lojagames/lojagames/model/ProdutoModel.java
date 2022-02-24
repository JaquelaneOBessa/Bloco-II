package org.generation.lojagames.lojagames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name="tb_produto")

public class ProdutoModel {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String produto;
	
	
	@NotNull
	@Size(min = 5, max = 100)
	private String descricaoCategoria;
	
	
	@OneToMany(mappedBy ="produto",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("produto")
	private List<CategoriaModel>categoria;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getProduto() {
		return produto;
	}


	public void setProduto(String produto) {
		this.produto = produto;
	}


	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}


	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}


	public List<CategoriaModel> getCategoria() {
		return categoria;
	}


	public void setCategoria(List<CategoriaModel> categoria) {
		this.categoria = categoria;
	}
	
	
	
}
