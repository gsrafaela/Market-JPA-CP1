package br.com.fiap.cp.dao;

import java.util.List;
import java.util.NoSuchElementException;

import br.com.fiap.cp.exceptions.CommitErrorException;

public interface GenericDao<T, K> {
	
	List<T> findAll();
	
	T findById(K id) throws NoSuchElementException;
	
	T save(T entidade);
	
	void deleteById(K id);
	
	void commit() throws CommitErrorException;

}
