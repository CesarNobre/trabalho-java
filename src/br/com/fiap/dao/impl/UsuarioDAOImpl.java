package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.entity.Usuario;
import br.com.fiap.exceptions.DBCommitException;


public class UsuarioDAOImpl extends DAOImpl<Usuario,Integer> implements UsuarioDAO{

	public UsuarioDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void inserir(Usuario usuario) {
		// TODO Auto-generated method stub
		try{
			
			EntityTransaction tx = this.em.getTransaction();
			
			if (!tx.isActive()) {  
	            tx.begin();  
	        }  
			this.em.persist(usuario);
			this.em.getTransaction().commit();	
		}catch(Exception ex){
			throw ex;
		}
	}

	@Override
	public Usuario buscarUsuario(String nome) {
		TypedQuery<Usuario> query = em.createQuery(
				"from Usuario u where u.nome = :n", Usuario.class);
			query.setParameter("n", nome);
			return query.getSingleResult();
	}

}
