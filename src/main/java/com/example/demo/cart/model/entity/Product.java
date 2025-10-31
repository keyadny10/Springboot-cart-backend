package com.example.demo.cart.model.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	@Column
	private Integer price;
	
	@OneToOne(cascade =  CascadeType.ALL)//連結 ALL 即表示 我如何他就如何，通常使用在remove
	@JoinColumn(name = "product_image_id")
	private ProductImage productImage;
	
	@OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
	private List<OrderItem> OrderItems;
	

	@ManyToMany(mappedBy = "favoriteProducts")
	private Set<User> favoriteUsers;
}
