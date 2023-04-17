package br.com.fiap.cp.singleton;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactorySingleton {

	private static EntityManagerFactory unique;

	private EntityManagerFactorySingleton() {
	}

	public static EntityManagerFactory getInstance() {
		if (unique == null) {
			unique = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		}

		return unique;
	}

}
