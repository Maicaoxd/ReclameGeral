package com.reclamegeral.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resposta")
public class Resposta extends Post {
	@ManyToOne
	private Reclamacao reclamacao;

	public Resposta() {
	}

	public Resposta(long id, String texto, LocalDateTime dataHora, Usuario usuario, Reclamacao reclamacao) {
		super(id, texto, dataHora, usuario);
		this.reclamacao = reclamacao;
	}

	public Reclamacao getReclamacao() {
		return reclamacao;
	}

	public void setReclamacao(Reclamacao reclamacao) {
		this.reclamacao = reclamacao;
	}

}
