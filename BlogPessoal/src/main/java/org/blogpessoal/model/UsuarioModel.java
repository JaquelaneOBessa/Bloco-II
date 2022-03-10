package org.blogpessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuario")

public class UsuarioModel {
	
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
private long id;

@NotBlank
@Size(min = 1, max = 255)
private String nome_completo;

@NotBlank
@Size(min = 1, max = 350)
private String usuario;

@NotBlank
@Size(min = 8, max = 255)
private String senha;

@OneToMany (mappedBy = "usuario", cascade = CascadeType.REMOVE)
@JsonIgnoreProperties("usuario")
private List<PostagemModel> postagem;

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getNome_completo() {
	return nome_completo;
}

public void setNome_completo(String nome_completo) {
	this.nome_completo = nome_completo;
}

public String getUsuario() {
	return usuario;
}

public void setUsuario(String usuario) {
	this.usuario = usuario;
}

public String getSenha() {
	return senha;
}

public void setSenha(String senha) {
	this.senha = senha;
}

public List<PostagemModel> getPostagem() {
	return postagem;
}

public void setPostagem(List<PostagemModel> postagem) {
	this.postagem = postagem;
}


}
