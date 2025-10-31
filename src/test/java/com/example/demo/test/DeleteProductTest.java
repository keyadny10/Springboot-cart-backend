package com.example.demo.test;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.model.entity.Product;
import com.example.demo.cart.repository.ProductRepository;

@SpringBootTest
public class DeleteProductTest {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void deleteTest() {
		if (productRepository.existsById(3L)) {
			productRepository.deleteById(3L);
			System.out.println("已刪除該筆資料");
		}else {
			System.out.println("無該筆資料");
		}
	}

}
