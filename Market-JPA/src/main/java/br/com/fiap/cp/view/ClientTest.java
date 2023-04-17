package br.com.fiap.cp.view;

import java.util.NoSuchElementException;

import br.com.fiap.cp.dao.ClientDao;
import br.com.fiap.cp.dao.ClientDaoImpl;
import br.com.fiap.cp.entities.Client;
import br.com.fiap.cp.exceptions.CommitErrorException;
import br.com.fiap.cp.singleton.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;

public class ClientTest {

	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		ClientDao clientDao = new ClientDaoImpl(em);
		
		Client client = new Client(1, "marcos", "marcosbilobram@hotmail.com", "1234567", null, null);
		
		try {
			clientDao.save(client);
			clientDao.commit();
			System.out.println("Cliente cadastrado!");
		}
		catch(CommitErrorException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Client search = clientDao.findById(1);
			System.out.println(search.getName());
		
			search.setEmail("client@hotmail.com");
			clientDao.save(search);
			clientDao.commit();
			System.out.println("Cliente atualizado!");
			
		} 
		catch (CommitErrorException e) {
			System.out.println(e.getMessage());
		} 
		catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			clientDao.deleteById(1);
			clientDao.commit();
			System.out.println("Cliente removido");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
