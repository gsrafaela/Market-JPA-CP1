package br.com.fiap.cp.view;

import java.util.NoSuchElementException;

import br.com.fiap.cp.dao.CategoryDao;
import br.com.fiap.cp.dao.CategoryDaoImpl;
import br.com.fiap.cp.entities.Category;
import br.com.fiap.cp.exceptions.CommitErrorException;
import br.com.fiap.cp.singleton.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;

public class CategoryTest {
	
	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		CategoryDao categoryDao = new CategoryDaoImpl(em);
		
		Category category = new Category(1L, "Frutas", "Categoria de frutas");
		
		try {
			categoryDao.save(category);
			categoryDao.commit();
			System.out.println("Categoria cadastrada!");
		}
		catch(CommitErrorException e) {
			System.out.println(e.getMessage());
		}
		
	
		try {
			Category search = categoryDao.findById(1);
			System.out.println(search.getName());
		
			search.setName("Frutas frescas");
			categoryDao.save(search);
			categoryDao.commit();
			System.out.println("Categoria atualizada!");
			
		} 
		catch (CommitErrorException e) {
			System.out.println(e.getMessage());
		} 
		catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			categoryDao.deleteById(1);
			categoryDao.commit();
			System.out.println("Categoria removida");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
