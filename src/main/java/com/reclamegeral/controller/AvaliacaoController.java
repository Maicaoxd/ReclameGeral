package com.reclamegeral.controller;

import java.util.List;

import com.reclamegeral.dao.AvaliacaoDAO;
import com.reclamegeral.model.Avaliacao;

public class AvaliacaoController {
	private AvaliacaoDAO avaliacaoDao = new AvaliacaoDAO();

	public void inserirAvaliacao(Avaliacao avaliacao) {
		avaliacaoDao.salvar(avaliacao);
	}

	public List<Avaliacao> pesquisarTodos() {
		return avaliacaoDao.listarTodos();
	}

	public Avaliacao pesquisarUmAvaliacao(long id) {
		return avaliacaoDao.buscarPorId(id);
	}

	public void apagar(Avaliacao avaliacao) {
		avaliacaoDao.remover(avaliacao);
	}

	public void atualizar(Avaliacao avaliacao) {
		avaliacaoDao.atualizar(avaliacao);
	}

}
