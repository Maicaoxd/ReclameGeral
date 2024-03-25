package com.reclamegeral.dao;

import java.util.List;

import com.reclamegeral.model.Reclamacao;

public interface IReclamacaoDAO {

	void salvar(Reclamacao reclamacao);

	Reclamacao buscarPorId(long id);

	void remover(Reclamacao reclamacao);

	List<Reclamacao> listarTodos();

	void fecharConexao();
}
