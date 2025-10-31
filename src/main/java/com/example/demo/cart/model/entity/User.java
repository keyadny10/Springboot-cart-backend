package com.example.demo.cart.model.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data//有tostring 不建議使用
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity//告訴她是一個資料表
@Table(name = "`user`")//強迫建置user
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true,nullable = false , length = 50)
	private String username;
	
	@Column(nullable = false , length = 255)//length = 255 預設即是255可寫可不寫
	private String password;
	
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<Order> orders;
	
	//建立用戶可以關注商品多對多關係
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_product",// 關聯表明稱
	joinColumns = @JoinColumn(name ="user_id"), //用戶的主鍵
	inverseJoinColumns = @JoinColumn(name ="product_id"))//商品的主鍵	
	private Set<Product> favoriteProducts;
}
