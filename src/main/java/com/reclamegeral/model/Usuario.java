package com.reclamegeral.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long codIdentificacao;
	private LocalDate nascimento;
	private String nome;
	private String estado;
	private String cidade;
	private String contato;
	private String email;
	private String senha;

	@OneToMany(mappedBy = "usuario")
	private Set<Post> posts;

	public Usuario() {
	}

	public Usuario(long id, long codIdentificacao, LocalDate nascimento, String nome, String estado, String cidade,
			String contato, String email, String senha, Set<Post> posts) {
		super();
		this.id = id;
		this.codIdentificacao = codIdentificacao;
		this.nascimento = nascimento;
		this.nome = nome;
		this.estado = estado;
		this.cidade = cidade;
		this.contato = contato;
		this.email = email;
		this.senha = senha;
		this.posts = posts;
	}

	public long getId() {
		return id;
	}

	public void SetId(long id) {
		this.id = id;
	}

	public long getCodIdentificacao() {
		return codIdentificacao;
	}

	public void SetCodIdentificacao(long codIdentificacao) {
		this.codIdentificacao = codIdentificacao;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void SetNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public String getNome() {
		return nome;
	}

	public void SetNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void SetEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void SetCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getContato() {
		return contato;
	}

	public void SetContato(String contato) {
		this.contato = contato;
	}

	public String getEmail() {
		return email;
	}

	public void SetEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void SetSenha(String senha) {
		this.senha = senha;
	}

	public Set<Post> getPosts() {
		return posts;
	}

	public void SetPosts(Set<Post> posts) {
		this.posts = posts;
	}

}
