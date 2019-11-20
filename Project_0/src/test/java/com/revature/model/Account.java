package com.revature.model;

import java.io.Serializable;

public class Account implements Serializable {
	
	
	private int acctNumber;
	private int userId;
	private double balance;
	private String accountType;
	private int accountpin;
	public int getAccountpin() {
		return accountpin;
	}
	public void setAccountpin(int accountpin) {
		this.accountpin = accountpin;
	}
	public int getAcctNumber() {
		return acctNumber;
	}
	public void setAcctNumber(int acctNumber) {
		this.acctNumber = acctNumber;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	@Override
	public String toString() {
		return "Account [acctNumber=" + acctNumber + ", userId=" + userId + ", balance=" + balance + ", accountType="
				+ accountType + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + acctNumber;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (acctNumber != other.acctNumber)
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	public Account(int userId, double balance, String accountType, int pin) {
		super();
	
		this.userId = userId;
		this.balance = balance;
		this.accountType = accountType;
		this.accountpin=pin;
	}
	


	

}
