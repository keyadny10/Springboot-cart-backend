package com.example.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.model.entity.Product;
import com.example.demo.cart.model.entity.ProductImage;
import com.example.demo.cart.repository.ProductImageRepository;
import com.example.demo.cart.repository.ProductRepository;

@SpringBootTest
public class AddProductTest {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductImageRepository productImageRepository;
	
	@Test
	void add() {
		ProductImage productImage = new ProductImage();
		String base64Apple = "iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAMAAAAoLQ9TAAAANlBMVEUAAAD///+ZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmZmXmQE53AAAAD3RSTlMAEiAjJCQhOx8dNx4/8NrpAAAAUklEQVQYV2NgoCbgYGBgGGBoYGBiE2SJYOJk5mRgYGRgYHDoYmJhYBgxkN4c0BCQ1JTA78jFAWZmQGAjUU9PLv4+gTsMASt+BhHghphmIMADbNAFf+8spTAAAAAElFTkSuQmCC";
		productImage.setImageBase64(base64Apple);
		
		Product product = new Product();
		product.setName("Apple");
		product.setPrice(100);
		product.setProductImage(productImage);
		productRepository.save(product);
	}
	
}
