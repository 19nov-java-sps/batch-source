package com.rev.model;

import java.io.Serializable;

public class AccountInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8193178153231256449L;
	private int account_id;
	private double account_balance;
	private int user_id;
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public double getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(double account_balance) {
		this.account_balance = account_balance;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(account_balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + account_id;
		result = prime * result + user_id;
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
		AccountInfo other = (AccountInfo) obj;
		if (Double.doubleToLongBits(account_balance) != Double.doubleToLongBits(other.account_balance))
			return false;
		if (account_id != other.account_id)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AccountInfo [account_id=" + account_id + ", account_balance=" + account_balance + ", user_id=" + user_id
				+ "]";
	}
	public AccountInfo(int account_id, double account_balance, int user_id) {
		super();
		this.account_id = account_id;
		this.account_balance = account_balance;
		this.user_id = user_id;
	}
	public AccountInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
