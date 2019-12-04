package com.revature.models;

import java.io.Serializable;

public class Invoice implements Serializable{

	private static final long serialVersionUID = 1L;
	private int invoice_id;
	private int user_id;
	private int amount;
	private boolean status;
	private int manager_id;
	
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Invoice(int invoice_id, int user_id, int amount, boolean status, int manager_id) {
		super();
		this.invoice_id = invoice_id;
		this.user_id = user_id;
		this.amount = amount;
		this.status = status;
		this.manager_id = manager_id;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + invoice_id;
		result = prime * result + manager_id;
		result = prime * result + (status ? 1231 : 1237);
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
		Invoice other = (Invoice) obj;
		if (amount != other.amount)
			return false;
		if (invoice_id != other.invoice_id)
			return false;
		if (manager_id != other.manager_id)
			return false;
		if (status != other.status)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	public int getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	@Override
	public String toString() {
		return "Invoice [invoice_id=" + invoice_id + ", user_id=" + user_id + ", amount=" + amount + ", status="
				+ status + ", manager_id=" + manager_id + "]";
	}
	
	
}
