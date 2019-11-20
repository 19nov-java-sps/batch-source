package com.revature.model;

public class BankAcc {

	private int bankID;
	private int userID;
	private int balance;
	
	public BankAcc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankAcc(int bankID, int userID, int balance) {
		super();
		this.bankID = bankID;
		this.userID = userID;
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + balance;
		result = prime * result + bankID;
		result = prime * result + userID;
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
		BankAcc other = (BankAcc) obj;
		if (balance != other.balance)
			return false;
		if (bankID != other.bankID)
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}

	public int getBankID() {
		return bankID;
	}

	public void setBankID(int bankID) {
		this.bankID = bankID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAcc [bankID=" + bankID + ", userID=" + userID + ", balance=" + balance + "]";
	}
	
	
}
