package com.demo.model;

import java.util.Hashtable;
import java.util.Map;

public class ProductModel {
	private Map<String, String> errors;
	private String id;
	private String name;
	private String desc;
	private String authId;
	private String sPrice; 
	private int price;
	
	public ProductModel() {
		errors = new Hashtable<String, String>();
	}

	public ProductModel(String id, String name, String desc, int price) {
		errors = new Hashtable<String, String>();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
	}
	
	public String getsPrice() {
		return sPrice;
	}

	public void setsPrice(String sPrice) {
		this.sPrice = sPrice;
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

	public void validate() {
		if(this.id == null || this.id.trim().equals("") ) {
			setError("id", "TID required.");
		}
		
		if(this.name == null || this.name.trim().equals("") ) {
			setError("name", "Name required.");
		}
		
		if(this.desc == null || this.desc.trim().equals("") ) {
			setError("desc", "Description required.");
		}
		
		if(this.sPrice == null || this.sPrice.trim().equals("") ) {
			setError("price", "Price required.");
		} else{
			try {
				this.price = Integer.parseInt(sPrice);
				if(price <= 0) {
					setError("price", "Price should be greater than 0.");
				}
			} catch(NumberFormatException nfe) {
				setError("price", "Price should be an integer.");
			}
		}
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setError(String errorField, String errorMessage) {
		this.errors.put(errorField, errorMessage);
	}

	public String getError(String errorField) {
		String errorMessage = "";

		if (this.errors.get(errorField) != null) {
			errorMessage = this.errors.get(errorField);
		}

		return errorMessage;
	}	
	
	public boolean isFormValid() {
		return !(errors.size() > 0);
	}
}

