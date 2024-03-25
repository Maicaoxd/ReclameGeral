package com.reclamegeral.controller;

import java.util.List;

import com.reclamegeral.dao.PessoaDAO;
import com.reclamegeral.model.Pessoa;

public class PessoaController {
	private PessoaDAO pessoaDao = new PessoaDAO();

	public void inserirPessoa(Pessoa pessoa) {
		pessoaDao.salvar(pessoa);
	}

	public List<Pessoa> pesquisarTodos() {
		return pessoaDao.listarTodos();
	}

	public Pessoa pesquisarUmPessoa(long id) {
		return pessoaDao.buscarPorId(id);
	}

	public void apagar(Pessoa pessoa) {
		pessoaDao.remover(pessoa);
	}

	public void atualizar(Pessoa pessoa) {
		pessoaDao.atualizar(pessoa);
	}

}
