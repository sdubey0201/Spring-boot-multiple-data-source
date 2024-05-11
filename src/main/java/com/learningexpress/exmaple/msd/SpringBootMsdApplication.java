package com.learningexpress.exmaple.msd;

import com.learningexpress.exmaple.msd.mysqlentity.Product;
import com.learningexpress.exmaple.msd.mysqlentity.ProductDAO;
import com.learningexpress.exmaple.msd.prostgresentity.Order;
import com.learningexpress.exmaple.msd.prostgresentity.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMsdApplication implements CommandLineRunner {

	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private OrderDAO orderDAO;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMsdApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("insert start..");
		Product product = new Product(5,"bottel",300.00);
		productDAO.save(product);
		System.out.println("insert completed..");
		System.out.println("Order insert start");
		Order order = new Order(1,product.getId());
		orderDAO.save(order);
		System.out.println("Order insert completed");

	}
}
