package com.example.demo.test;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.example.demo.cart.model.entity.Product;
import com.example.demo.cart.repository.ProductRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
public class UpdateProductTest {

	@Autowired
	private ProductRepository productRepository;
	
	
	@Test
	//@Transactional//恩位會使用到jpa的@modifying 方法，所以要設定
	//@Commit//防止rollback
	public void updateProduct() {
		Optional<Product> upProduct =productRepository.findById(1L);
		if (upProduct.isEmpty()) {
			System.out.println("無此資料");
			return;
		}
		Product product = upProduct.get();
		product.setPrice(200);
		product.setName("富士蘋果");
		productRepository.save(product);
		System.out.println("更新完畢");
	
		
		/*Long id = 1L;
		Integer price = 199;
		String name= "青森蘋果";
		
		// 
		int rowcount = productRepository.updatePriceAndNameById(id, price, name);
		if(rowcount>0) {
			System.out.println("更新完畢");
			
		}else {
			System.out.println("修改失敗，查無資料");
		}*/
	}
}
