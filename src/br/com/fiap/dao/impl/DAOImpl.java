package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.DAO;
import br.com.fiap.exceptions.DBCommitException;
import br.com.fiap.exceptions.IdNotFoundException;

public class DAOImpl<T, K> implements DAO<T, K>{
	
	protected EntityManager em;
	
	private Class<T> classe;

	@SuppressWarnings("unchecked")
	public DAOImpl(EntityManager em){
		this.em = em;
		classe = 
				(Class<T>) ((ParameterizedType)
						getClass().getGenericSuperclass())
							.getActualTypeArguments()[0];
	}
	
	@Override
	public void insert(T entity) throws DBCommitException {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw new DBCommitException("Erro ao persistir");
		}
	}

	@Override
	public T find(K id) throws DBCommitException, IdNotFoundException {
		return em.find(classe, id);
	}

	@Override
	public List<T> list() {
		TypedQuery<T> query = 
				em.createQuery("from " + classe.getName(),classe);
			return query.getResultList();
	}

}
