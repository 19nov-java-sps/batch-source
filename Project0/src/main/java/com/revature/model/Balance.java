package com.revature.model;

import java.io.Serializable;

public class Balance implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private double balance = 0;

	
	public Balance() {
		super();
	}

	public Balance(int id, double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Balance other = (Balance) obj;
		if (id != other.id)
			return false;
		if (balance != other.balance)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Balance of User [id=" + id + ", balance=" + balance + "]";
	}
	
}
