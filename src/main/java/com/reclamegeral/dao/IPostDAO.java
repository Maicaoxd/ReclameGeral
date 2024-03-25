package com.reclamegeral.dao;

import java.util.List;

import com.reclamegeral.model.Post;

public interface IPostDAO {

	void salvar(Post post);

	Post buscarPorId(long id);

	void atualizar(Post post);

	void remover(Post post);

	List<Post> listarTodos();

	void fecharConexao();
}
