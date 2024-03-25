package com.reclamegeral.controller;

import java.util.List;

import com.reclamegeral.dao.CategoriaDAO;
import com.reclamegeral.model.Categoria;

public class CategoriaController {
	private CategoriaDAO categoriaDao = new CategoriaDAO();

	public void inserirCategoria(Categoria categoria) {
		categoriaDao.salvar(categoria);
	}

	public List<Categoria> pesquisarTodos() {
		return categoriaDao.listarTodos();
	}

	public Categoria pesquisarUmCategoria(long id) {
		return categoriaDao.buscarPorId(id);
	}

	public void apagar(Categoria categoria) {
		categoriaDao.remover(categoria);
	}

	public void atualizar(Categoria categoria) {
		categoriaDao.atualizar(categoria);
	}

}
