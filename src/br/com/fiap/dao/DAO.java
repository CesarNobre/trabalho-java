package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.exceptions.DBCommitException;
import br.com.fiap.exceptions.IdNotFoundException;

public interface DAO<T,K> {
	
	void insert(T entity) throws DBCommitException;
	
	T find(K id) throws DBCommitException, IdNotFoundException;
	
	List<T> list();
}
