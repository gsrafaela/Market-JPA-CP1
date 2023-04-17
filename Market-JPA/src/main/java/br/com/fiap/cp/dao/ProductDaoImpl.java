package br.com.fiap.cp.dao;

import br.com.fiap.cp.entities.Product;
import jakarta.persistence.EntityManager;

public class ProductDaoImpl extends GenericDaoImpl<Product, Integer> implements ProductDao{

	public ProductDaoImpl(EntityManager em) {
		super(em);
	}

}
