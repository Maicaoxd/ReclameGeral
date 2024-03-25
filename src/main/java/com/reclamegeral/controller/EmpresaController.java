package com.reclamegeral.controller;

import java.util.List;

import com.reclamegeral.dao.EmpresaDAO;
import com.reclamegeral.model.Empresa;

public class EmpresaController {
	private EmpresaDAO empresaDao = new EmpresaDAO();

	public void inserirEmpresa(Empresa empresa) {
		empresaDao.salvar(empresa);
	}

	public List<Empresa> pesquisarTodos() {
		return empresaDao.listarTodos();
	}

	public Empresa pesquisarUmEmpresa(long id) {
		return empresaDao.buscarPorId(id);
	}

	public void apagar(Empresa empresa) {
		empresaDao.remover(empresa);
	}

	public void atualizar(Empresa empresa) {
		empresaDao.atualizar(empresa);
	}

}
