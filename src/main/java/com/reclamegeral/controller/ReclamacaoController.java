package com.reclamegeral.controller;

import java.util.List;

import com.reclamegeral.dao.ReclamacaoDAO;
import com.reclamegeral.model.Reclamacao;

public class ReclamacaoController {
	private ReclamacaoDAO reclamacaoDao = new ReclamacaoDAO();

	public void inserirReclamacao(Reclamacao reclamacao) {
		reclamacaoDao.salvar(reclamacao);
	}

	public List<Reclamacao> pesquisarTodos() {
		return reclamacaoDao.listarTodos();
	}

	public Reclamacao pesquisarUmReclamacao(long id) {
		return reclamacaoDao.buscarPorId(id);
	}

	public void apagar(Reclamacao reclamacao) {
		reclamacaoDao.remover(reclamacao);
	}

	public void atualizar(Reclamacao reclamacao) {
		reclamacaoDao.atualizar(reclamacao);
	}

}
