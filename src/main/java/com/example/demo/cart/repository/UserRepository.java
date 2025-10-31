package com.example.demo.cart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.cart.model.entity.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	//自訂方法
	Optional<User>  findByUsername(String username);
	
	boolean existsByUsername(String username);
	
	@Query(value = "select id , username,password from `user` where username = :username",nativeQuery = true)
	Optional<User> findByUsernameNativSQL(String username);
	
	@Query(value = "select u from User u where u.username = :username",nativeQuery = false)
	Optional<User> findByUsernameJPQL(String username);
	
}
