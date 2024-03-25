package com.reclamegeral.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;

@Entity
public class Pessoa extends Usuario {
	private String genero;
	private boolean isBlackSet;

	public Pessoa() {
	}

	public Pessoa(long id, long codIdentificacao, LocalDate nascimento, String nome, String estado, String cidade,
			String contato, String email, String senha, Set<Post> posts, String genero, boolean isBlackSet) {
		super(id, codIdentificacao, nascimento, nome, estado, cidade, contato, email, senha, posts);
		this.genero = genero;
		this.isBlackSet = isBlackSet;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public boolean isBlackSet() {
		return isBlackSet;
	}

	public void setBlackSet(boolean isBlackSet) {
		this.isBlackSet = isBlackSet;
	}

}
