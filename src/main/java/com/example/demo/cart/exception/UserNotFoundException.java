package com.example.demo.cart.exception;

public class UserNotFoundException extends RuntimeException{
	public UserNotFoundException (String message) {
		super(message);
	}
}
