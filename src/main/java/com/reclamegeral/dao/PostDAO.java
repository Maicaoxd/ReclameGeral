package com.reclamegeral.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.reclamegeral.model.Post;
import com.reclamegeral.util.JPAUtil;

public class PostDAO implements IPostDAO {

	EntityManager em = JPAUtil.getEntityManager();

	@Override
	public void salvar(Post post) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.persist(post);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public Post buscarPorId(long id) {
		return em.find(Post.class, id);
	}

	@Override
	public void atualizar(Post post) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.merge(post);
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void remover(Post post) {
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			em.remove(em.contains(post) ? post : em.merge(post));
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public List<Post> listarTodos() {
		return em.createQuery("SELECT p FROM Post p", Post.class).getResultList();
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
