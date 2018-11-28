package com.demo.model;

public class ItemModel {
	private String id;
	private String name;
	private String desc;
	private int price;
	private int quantity;
	private int total;
	
	public ItemModel() {
		
	}

	public ItemModel(String id, String name, String desc, int price, int quantity, int total) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.quantity = quantity;
		this.total = total;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
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
