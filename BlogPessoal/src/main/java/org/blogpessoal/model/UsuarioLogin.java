package org.blogpessoal.model;

public class UsuarioLogin {
	
private long id;

private String nome_completo;

private String usuario;

private String senha;

private String token;

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

public String getToken() {
	return token;
}

public void setToken(String token) {
	this.token = token;
}


}
