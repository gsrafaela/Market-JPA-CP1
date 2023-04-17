package br.com.fiap.cp.view;

import java.util.NoSuchElementException;

import br.com.fiap.cp.dao.ProductDao;
import br.com.fiap.cp.dao.ProductDaoImpl;
import br.com.fiap.cp.entities.Product;
import br.com.fiap.cp.exceptions.CommitErrorException;
import br.com.fiap.cp.singleton.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;

public class ProductTest {
	
public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		ProductDao productDao = new ProductDaoImpl(em);
		
		Product product = new Product(1L, "Banana", "fruta nham nham", 2.0, null, null);
		
		try {
			productDao.save(product);
			productDao.commit();
			System.out.println("Produto cadastrado!");
		}
		catch(CommitErrorException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Product search = productDao.findById(1);
			System.out.println(search.getName());
		
			search.setName("Bananinha");
			productDao.save(search);
			productDao.commit();
			System.out.println("Produto atualizado!");
			
		} 
		catch (CommitErrorException e) {
			System.out.println(e.getMessage());
		} 
		catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			productDao.deleteById(1);
			productDao.commit();
			System.out.println("Produto removido");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
