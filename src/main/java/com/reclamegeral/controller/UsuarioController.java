package com.reclamegeral.controller;

import java.util.List;

import com.reclamegeral.dao.UsuarioDAO;
import com.reclamegeral.model.Usuario;

public class UsuarioController {
	private UsuarioDAO usuarioDao = new UsuarioDAO();

	public void inserirUsuario(Usuario usuario) {
		usuarioDao.salvar(usuario);
	}

	public List<Usuario> pesquisarTodos() {
		return usuarioDao.listarTodos();
	}

	public Usuario pesquisarUmUsuario(long id) {
		return usuarioDao.buscarPorId(id);
	}

	public void apagar(long id) {
		usuarioDao.remover(id);
	}

	public void atualizar(Usuario usuario) {
		usuarioDao.atualizar(usuario);
	}

}
