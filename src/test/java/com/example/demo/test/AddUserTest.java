package com.example.demo.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.model.entity.User;
import com.example.demo.cart.repository.UserRepository;

@SpringBootTest
public class AddUserTest {
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	void add() {
		
	/*User user1 = new User();
		user1.setUsername("admin");
		user1.setPassword("1234");
		userRepository.save(user1);
		
		User user2 = new User();
		user2.setUsername("andy");
		user2.setPassword("456");
		userRepository.save(user2);
	}*/
	 if (userRepository.findByUsername("admin").isPresent()) {
	        System.out.println("⚠️ 使用者已存在，請不要重複新增！");
	    } else {
	        User user = new User();
	        user.setUsername("admin");
	        user.setPassword("1324");
	        userRepository.save(user);
	        System.out.println(" 新增成功！");
	    }

	}
}
