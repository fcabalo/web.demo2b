package com.demo.model;

public class AccountHolder {
	private String id;
	private int registrationId;
	private float balance;

	public AccountHolder() {
	}

	public AccountHolder(String id, int registrationId, float balance) {
		this.id = id;
		this.registrationId = registrationId;
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

}
