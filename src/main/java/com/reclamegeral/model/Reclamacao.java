package com.reclamegeral.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity (name="reclamacao")
@Table(name = "reclamacao")
public class Reclamacao extends Post {
	private boolean hasReply;

	@OneToOne
	@JoinColumn(name = "empresa_id")
	private Empresa empresa;

	@ManyToOne
	private Categoria categoria;

	@OneToMany(mappedBy = "reclamacao")
	private Set<Resposta> respostas;

	public Reclamacao() {
	}

	public Reclamacao(long id, String texto, LocalDateTime dataHora, Usuario usuario, boolean hasReply, Empresa empresa,
			Categoria categoria, Set<Resposta> respostas) {
		super(id, texto, dataHora, usuario);
		this.hasReply = hasReply;
		this.empresa = empresa;
		this.categoria = categoria;
		this.respostas = respostas;
	}

	public boolean isHasReply() {
		return hasReply;
	}

	public void setHasReply(boolean hasReply) {
		this.hasReply = hasReply;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Set<Resposta> getRespostas() {
		return respostas;
	}

	public void setRespostas(Set<Resposta> respostas) {
		this.respostas = respostas;
	}
}
