package com.reclamegeral.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.reclamegeral.model.Resposta;
import com.reclamegeral.util.JPAUtil;

public class RespostaDAO implements IRespostaDAO {
	
	EntityManager em = JPAUtil.getEntityManager();

	@Override
	public void salvar(Resposta resposta) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(resposta);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public Resposta buscarPorId(long id) {
		return em.find(Resposta.class, id);
	}

	@Override
	public void remover(Resposta resposta) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.remove(em.contains(resposta) ? resposta : em.merge(resposta));
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public List<Resposta> listarTodos() {
		return em.createQuery("SELECT u FROM Usuario u", Resposta.class).getResultList();
	}

	@Override
	public void fecharConexao() {
		if (em != null) {
			em.close();
		}
		if (em != null) {
			em.close();
		}
	}

}
