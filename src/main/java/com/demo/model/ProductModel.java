package com.demo.model;

public class ProductModel {
	private String id;
	private String name;
	private String desc;
	private String authId;
	private int price;
	
	public ProductModel() {
		
	}

	public ProductModel(String id, String name, String desc, int price) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
	}
	
	public ProductModel(String id, String name, String desc, int price, String authId) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.authId = authId;
	}

	public String getAuthId() {
		return authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
