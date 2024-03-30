package com.reclamegeral.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa extends Usuario {

	private String genero;
	private boolean isBlackSet;

	@OneToMany(mappedBy = "pessoa")
	private Set<Reclamacao> reclamacoes;

	public Pessoa() {
	}

	public Pessoa(String genero, boolean isBlackSet, Set<Reclamacao> reclamacoes) {
		super();
		this.genero = genero;
		this.isBlackSet = isBlackSet;
		this.reclamacoes = reclamacoes;
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

	public Set<Reclamacao> getReclamacoes() {
		return reclamacoes;
	}

	public void setReclamacoes(Set<Reclamacao> reclamacoes) {
		this.reclamacoes = reclamacoes;
	}

}
