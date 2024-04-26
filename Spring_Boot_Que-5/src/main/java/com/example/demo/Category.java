package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Category {

	@Id
	private Long id;
	private String name;
	private String type;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Product> product = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Category(String name, String type, List<Product> product) {
		super();
		this.name = name;
		this.type = type;
		this.product = product;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
