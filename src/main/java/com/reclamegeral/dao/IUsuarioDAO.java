package com.reclamegeral.dao;

import java.util.List;

import com.reclamegeral.model.Usuario;

public interface IUsuarioDAO {

	void salvar(Usuario usuario);

	Usuario buscarPorId(long id);

	void atualizar(Usuario usuario);

	void remover(long id);

	List<Usuario> listarTodos();

	void fecharConexao();
}
