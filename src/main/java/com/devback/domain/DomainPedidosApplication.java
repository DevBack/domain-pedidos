package com.devback.domain;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devback.domain.entities.Client;
import com.devback.domain.entities.Order;
import com.devback.domain.entities.OrderItem;
import com.devback.domain.entities.OrderStatus;
import com.devback.domain.entities.Product;
import com.devback.domain.repositories.ClientRepository;
import com.devback.domain.repositories.OrderItemRepository;
import com.devback.domain.repositories.OrderRepository;
import com.devback.domain.repositories.ProductRepository;

@SpringBootApplication
public class DomainPedidosApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DomainPedidosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Client cliente = new Client(null, "Alex Green", "alex@gmail.com");
		clientRepository.save(cliente);
		
		Product produto1 = new Product(null, "TV", 1000.0);
		Product produto2 = new Product(null, "Mouse", 40.0);
		Product produto3 = new Product(null, "PC", 1200.0);

		productRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
		
		Order pedido1 = new Order(null, Instant.parse("2021-04-18T11:25:09Z"), OrderStatus.PAID, cliente);
		Order pedido2 = new Order(null, Instant.parse("2021-04-20T13:30:00Z"), OrderStatus.WAITING, cliente);
		
		orderRepository.saveAll(Arrays.asList(pedido1,pedido2));
		
		OrderItem item1 = new OrderItem(null, 1, 1000.0, produto1, pedido1);
		OrderItem item2 = new OrderItem(null, 2, 40.0, produto2, pedido1);
		OrderItem item3 = new OrderItem(null, 1, 40.0, produto2, pedido2);
		OrderItem item4 = new OrderItem(null, 1, 1200.0, produto3, pedido2);
		
		orderItemRepository.saveAll(Arrays.asList(item1, item2, item3, item4));
	}

}
