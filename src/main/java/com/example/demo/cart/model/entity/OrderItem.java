package com.example.demo.cart.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "order_item")
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column
	private int qty;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	// order_iten 與 order 多對一關聯
		@ManyToOne
		@JoinColumn(name = "order_id")
		private Order order;
}
