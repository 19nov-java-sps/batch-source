package com.revauture.model;

public class Invoice {
	
	private int invoiceId;
	private Double amount;
	private String description;
	private boolean pending;
	private boolean approved;
	private boolean rejected;
	private boolean resolved;
	private int userId;
	
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Invoice(int invoiceId, Double amount, String description, boolean pending, boolean approved,
			boolean rejected, boolean resolved, int userId) {
		super();
		this.invoiceId = invoiceId;
		this.amount = amount;
		this.description = description;
		this.pending = pending;
		this.approved = approved;
		this.rejected = rejected;
		this.resolved = resolved;
		this.userId = userId;
	}



	public Invoice(Double amount, String description, boolean pending, boolean approved, boolean rejected,
			boolean resolved, int userId) {
		super();
		this.amount = amount;
		this.description = description;
		this.pending = pending;
		this.approved = approved;
		this.rejected = rejected;
		this.resolved = resolved;
		this.userId = userId;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public boolean isRejected() {
		return rejected;
	}

	public void setRejected(boolean rejected) {
		this.rejected = rejected;
	}

	public boolean isResolved() {
		return resolved;
	}

	public void setResolved(boolean resolved) {
		this.resolved = resolved;
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
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + (approved ? 1231 : 1237);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + invoiceId;
		result = prime * result + (pending ? 1231 : 1237);
		result = prime * result + (rejected ? 1231 : 1237);
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
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (approved != other.approved)
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
		if (rejected != other.rejected)
			return false;
		if (resolved != other.resolved)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", amount=" + amount + ", description=" + description + ", pending="
				+ pending + ", approved=" + approved + ", rejected=" + rejected + ", resolved=" + resolved + ", userId="
				+ userId + "]";
	}
	
	
}
