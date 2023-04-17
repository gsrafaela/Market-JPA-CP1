package br.com.fiap.cp.dao;

import br.com.fiap.cp.entities.Client;
import jakarta.persistence.EntityManager;

public class ClientDaoImpl extends GenericDaoImpl<Client, Integer> implements ClientDao{
	
	public ClientDaoImpl(EntityManager em) {
		super(em);
	}
}
