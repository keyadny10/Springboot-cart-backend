package com.example.demo.test;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.cart.model.entity.User;
import com.example.demo.cart.repository.UserRepository;

@SpringBootTest
public class SelectUesrTest {

	
	@Autowired
	UserRepository userRepository;
	
	@Test
	void select() {
		Optional<User> optUse1 = userRepository.findById(1L);
		if (optUse1.isPresent()) {
			User user = optUse1.get();
			System.out.println("user1 =>" +user.getId() +", "+user.getUsername()+","+user.getPassword());;
		}
		Optional<User> optUse2 = userRepository.findByUsername("andy");
		if (optUse1.isPresent()) {
			User user = optUse2.get();
			System.out.println("user1 =>" +user.getId() +", "+user.getUsername()+","+user.getPassword());;
		}
		
		List<User> users = userRepository.findAll();
		for(User user : users) {
			System.out.println(user.getId() + "," + user.getUsername() + "," + user.getPassword());
		}
	}
	
	}
	

