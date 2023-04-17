package br.com.fiap.cp.dao;

import br.com.fiap.cp.entities.Category;
import jakarta.persistence.EntityManager;

public class CategoryDaoImpl extends GenericDaoImpl<Category, Integer> implements CategoryDao{

	public CategoryDaoImpl(EntityManager em) {
		super(em);
	}

}
