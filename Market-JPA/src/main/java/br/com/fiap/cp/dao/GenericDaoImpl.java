package br.com.fiap.cp.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.NoSuchElementException;

import br.com.fiap.cp.exceptions.CommitErrorException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public abstract class GenericDaoImpl<T, K> implements GenericDao<T, K> {

	private EntityManager em;

	private Class<T> clss;

	@SuppressWarnings("all")
	public GenericDaoImpl(EntityManager em) {
		this.em = em;
		this.clss = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public List<T> findAll() {
	    String queryStr = "SELECT e FROM " + clss.getSimpleName() + " e";
	    TypedQuery<T> query = em.createQuery(queryStr, clss);
	    return query.getResultList();
	}
	
	public T findById(K id){
		T entidade = em.find(clss, id);
		if (entidade == null) {
			throw new NoSuchElementException("Entidade n�o encontrada");
		}
		return entidade;
	}

	public T save(T entidade) {
		return em.merge(entidade);
	}

	public void deleteById(K id){
		T entidade = findById(id);
		em.remove(entidade);
	}

	public void commit() throws CommitErrorException{
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new CommitErrorException("Error executing commmit");
		}
	}

}
