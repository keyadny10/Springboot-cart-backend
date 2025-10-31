package com.example.demo.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.model.entity.Order;
import com.example.demo.cart.model.entity.OrderItem;
import com.example.demo.cart.model.entity.Product;
import com.example.demo.cart.model.entity.User;
import com.example.demo.cart.repository.OrderItemRepository;
import com.example.demo.cart.repository.OrderRepository;
import com.example.demo.cart.repository.ProductRepository;
import com.example.demo.cart.repository.UserRepository;

@SpringBootTest
public class AddOrderTest {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Test
	public void Add() {
		User user = userRepository.findById(1L).get();
		Product apple = productRepository.findById(1L).get();
		Product banana = productRepository.findById(2L).get();
		
		Order order = new Order();
		
		OrderItem orderItem = new OrderItem();
		OrderItem orderItem2 = new OrderItem();
		
		order.setUser(user);
		orderRepository.save(order);
		
		orderItem.setOrder(order);
		orderItem.setProduct(apple);
		orderItem.setQty(10);
		orderItemRepository.save(orderItem);
		
		orderItem2.setOrder(order);
		orderItem2.setProduct(apple);
		orderItem2.setQty(20);
		orderItemRepository.save(orderItem2);
		
		
		System.out.println("Order is ok");
		
	}
}
