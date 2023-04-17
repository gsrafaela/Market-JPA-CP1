package br.com.fiap.cp.dao;

import br.com.fiap.cp.entities.Order;

public interface OrderDao extends GenericDao<Order, Integer> {

	void deleteById(long l);

	Order findById(long l);

}
