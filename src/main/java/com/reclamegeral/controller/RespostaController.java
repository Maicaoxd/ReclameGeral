package com.reclamegeral.controller;

import java.util.List;

import com.reclamegeral.dao.RespostaDAO;
import com.reclamegeral.model.Resposta;

public class RespostaController {
	private RespostaDAO respostaDao = new RespostaDAO();

	public void inserirResposta(Resposta resposta) {
		respostaDao.salvar(resposta);
	}

	public List<Resposta> pesquisarTodos() {
		return respostaDao.listarTodos();
	}

	public Resposta pesquisarUmResposta(long id) {
		return respostaDao.buscarPorId(id);
	}

	public void apagar(Resposta resposta) {
		respostaDao.remover(resposta);
	}

	public void atualizar(Resposta resposta) {
		respostaDao.atualizar(resposta);
	}

}
