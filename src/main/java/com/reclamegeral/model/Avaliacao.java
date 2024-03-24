package com.reclamegeral.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "avaliacao")
public class Avaliacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private float pontuacao;
	private boolean isResolved;

	@OneToOne
	@JoinColumn(name = "reclamacao_id")
	private Reclamacao reclamacao;

	public Avaliacao() {
	}

	public Avaliacao(long id, float pontuacao, boolean isResolved, Reclamacao reclamacao) {
		super();
		this.id = id;
		this.pontuacao = pontuacao;
		this.isResolved = isResolved;
		this.reclamacao = reclamacao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(float pontuacao) {
		this.pontuacao = pontuacao;
	}

	public boolean isResolved() {
		return isResolved;
	}

	public void setResolved(boolean isResolved) {
		this.isResolved = isResolved;
	}

	public Reclamacao getReclamacao() {
		return reclamacao;
	}

	public void setReclamacao(Reclamacao reclamacao) {
		this.reclamacao = reclamacao;
	}
}
