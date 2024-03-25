package com.reclamegeral.controller;

import java.util.List;

import com.reclamegeral.dao.PostDAO;
import com.reclamegeral.model.Post;

public class PostController {
	private PostDAO postDao = new PostDAO();

	public void inserirPost(Post post) {
		postDao.salvar(post);
	}

	public List<Post> pesquisarTodos() {
		return postDao.listarTodos();
	}

	public Post pesquisarUmPost(long id) {
		return postDao.buscarPorId(id);
	}

	public void apagar(Post post) {
		postDao.remover(post);
	}

	public void atualizar(Post post) {
		postDao.atualizar(post);
	}

}
