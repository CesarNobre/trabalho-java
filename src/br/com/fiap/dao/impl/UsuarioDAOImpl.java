package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.UsuarioDAO;
import br.com.fiap.entity.Usuario;

public class UsuarioDAOImpl extends DAOImpl<Usuario,Integer> implements UsuarioDAO{

	public UsuarioDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void inserir(Usuario usuario) {
		// TODO Auto-generated method stub
		this.em.getTransaction();
		this.em.persist(usuario);
		this.em.getTransaction().commit();
	}

	@Override
	public Usuario buscarUsuario(int codigo) {
		TypedQuery<Usuario> query = em.createQuery(
				"from Usuario u where c.codigo = :c",Usuario.class);
			query.setParameter("c", codigo);
			return query.getSingleResult();
	}

}
