package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String pname;
	private String ptype;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public Product(String pname, String ptype) {
		super();
		this.pname = pname;
		this.ptype = ptype;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
