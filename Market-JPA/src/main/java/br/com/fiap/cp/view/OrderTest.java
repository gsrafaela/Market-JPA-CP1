package br.com.fiap.cp.view;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.cp.dao.OrderDao;
import br.com.fiap.cp.dao.OrderDaoImpl;
import br.com.fiap.cp.entities.Address;
import br.com.fiap.cp.entities.Client;
import br.com.fiap.cp.entities.Order;
import br.com.fiap.cp.entities.Product;
import br.com.fiap.cp.enums.OrderStatus;
import br.com.fiap.cp.exceptions.CommitErrorException;
import br.com.fiap.cp.singleton.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;

public class OrderTest {

    public static void main(String[] args) {

        EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

        OrderDao orderDao = new OrderDaoImpl(em);

        Address deliveryAddress = new Address();
       
        @SuppressWarnings("unused")
		Client client = new Client(0, "Fulano", "fulano@fiap.com.br", "11999999999", deliveryAddress, new ArrayList<Order>());
       
        List<Product> products = new ArrayList<Product>();
        Product product1 = new Product("Banana", "fruta nham nham", 2.0, new ArrayList<Order>(), new ArrayList<Order>());
        Product product2 = new Product("Maçã", "fruta do amor", 3.0, new ArrayList<Order>(), new ArrayList<Order>());
        products.add(product1);
        products.add(product2);

        Order order = new Order();
     
        try {
            orderDao.save(order);
            orderDao.commit();
            System.out.println("Pedido cadastrado!");
        } catch (CommitErrorException e) {
            System.out.println(e.getMessage());
        }

        try {
            Order search = orderDao.findById(1L);
            System.out.println(search.getId() + " " + search.getTotalValue() + " " + search.getStatus());
            search.setStatus(OrderStatus.CLOSED);
            orderDao.save(search);
            orderDao.commit();
            System.out.println("Pedido atualizado!");
        } catch (CommitErrorException e) {
            System.out.println(e.getMessage());
        }

        try {
            orderDao.deleteById(1L);
            orderDao.commit();
            System.out.println("Pedido removido");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        em.close();
        EntityManagerFactorySingleton.getInstance().close();
    }
}
