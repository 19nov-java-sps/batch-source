package com.revature.model;

import java.io.Serializable;

public class Invoice implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int invoiceId;
	private int userId;
	private double amount;
	private String description;
	private boolean pending;
	private boolean approved;
	private boolean denied;
	private boolean resolved;
	
	
	public Invoice() {
		super();
	}

	

	public Invoice(int invoiceId, int userId, double amount, String description, boolean pending, boolean approved,
			boolean denied, boolean resolved) {
		super();
		this.invoiceId = invoiceId;
		this.userId = userId;
		this.amount = amount;
		this.description = description;
		this.pending = pending;
		this.approved = approved;
		this.denied = denied;
		this.resolved = resolved;
	}



	public Invoice(int userId, double amount, String description, boolean pending, boolean approved, boolean denied,
			boolean resolved) {
		super();
		this.userId = userId;
		this.amount = amount;
		this.description = description;
		this.pending = pending;
		this.approved = approved;
		this.denied = denied;
		this.resolved = resolved;
	}

	

	public boolean isPending() {
		return pending;
	}


	public void setPending(boolean pending) {
		this.pending = pending;
	}


	public boolean isApproved() {
		return approved;
	}


	public void setApproved(boolean approved) {
		this.approved = approved;
	}


	public boolean isDenied() {
		return denied;
	}


	public void setDenied(boolean denied) {
		this.denied = denied;
	}


	public boolean isResolved() {
		return resolved;
	}


	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}


	public int getInvoiceId() {
		return invoiceId;
	}


	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (approved ? 1231 : 1237);
		result = prime * result + (denied ? 1231 : 1237);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + invoiceId;
		result = prime * result + (pending ? 1231 : 1237);
		result = prime * result + (resolved ? 1231 : 1237);
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
		Invoice other = (Invoice) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (approved != other.approved)
			return false;
		if (denied != other.denied)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (invoiceId != other.invoiceId)
			return false;
		if (pending != other.pending)
			return false;
		if (resolved != other.resolved)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", userId=" + userId + ", amount=" + amount + ", description="
				+ description + ", pending=" + pending + ", approved=" + approved + ", denied=" + denied + ", resolved="
				+ resolved + "]";
	}

	
	
	
}