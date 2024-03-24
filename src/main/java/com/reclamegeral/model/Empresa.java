package com.reclamegeral.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;

@Entity(name = "empresa")
public class Empresa extends Usuario {
	private String nomeFantasia;
	private String sobre;

	public Empresa() {
	}

	public Empresa(long id, long codIdentificacao, LocalDate nascimento, String nome, String estado, String cidade,
			String contato, String email, String senha, Set<Post> posts, String nomeFantasia, String sobre) {
		super(id, codIdentificacao, nascimento, nome, estado, cidade, contato, email, senha, posts);
		this.nomeFantasia = nomeFantasia;
		this.sobre = sobre;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}

}
