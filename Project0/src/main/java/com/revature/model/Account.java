package com.revature.model;

import java.io.Serializable;

public class Account implements Serializable {
	
	private static final long serialVersionUID = -1293898282614285703L;
	
	private int accountId;
	private String type;
	private double balance;
	private int userId;
	
	
	public Account() {
		super();
	}


	public Account(int accountId, String type, double balance, int userId) {
		super();
		this.accountId = accountId;
		this.type = type;
		this.balance = balance;
		this.userId = userId;
	}


	public Account(String accountType, int userId, double ammount) {
		super();
		this.type = accountType;
		this.userId=userId;
		this.balance=ammount;
	}


	public int getAccountId() {
		return accountId;
	}


	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + userId;
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
		Account other = (Account) obj;
		if (accountId != other.accountId)
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", type=" + type + ", balance=" + balance + ", userId=" + userId
				+ "]";
	}
	
	

}
