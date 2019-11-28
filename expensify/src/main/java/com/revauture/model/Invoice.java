package com.revauture.model;

public class Invoice {
	
	private int invoiceId;
	private Double amount;
	private String description;
	private String dateSubmitted;
	private String dateApproved;
	private Boolean rejected;
	private int userId;
	
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Invoice(int invoiceId, Double amount, String description, String dateSubmitted, String dateApproved,
			Boolean rejected, int userId) {
		super();
		this.invoiceId = invoiceId;
		this.amount = amount;
		this.description = description;
		this.dateSubmitted = dateSubmitted;
		this.dateApproved = dateApproved;
		this.rejected = rejected;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", amount=" + amount + ", description=" + description
				+ ", dateSubmitted=" + dateSubmitted + ", dateApproved=" + dateApproved + ", rejected=" + rejected
				+ ", userId=" + userId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((dateApproved == null) ? 0 : dateApproved.hashCode());
		result = prime * result + ((dateSubmitted == null) ? 0 : dateSubmitted.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + invoiceId;
		result = prime * result + ((rejected == null) ? 0 : rejected.hashCode());
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
		if (dateApproved == null) {
			if (other.dateApproved != null)
				return false;
		} else if (!dateApproved.equals(other.dateApproved))
			return false;
		if (dateSubmitted == null) {
			if (other.dateSubmitted != null)
				return false;
		} else if (!dateSubmitted.equals(other.dateSubmitted))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (invoiceId != other.invoiceId)
			return false;
		if (rejected == null) {
			if (other.rejected != null)
				return false;
		} else if (!rejected.equals(other.rejected))
			return false;
		if (userId != other.userId)
			return false;
		return true;
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

	public String getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(String dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public String getDateApproved() {
		return dateApproved;
	}

	public void setDateApproved(String dateApproved) {
		this.dateApproved = dateApproved;
	}

	public Boolean getRejected() {
		return rejected;
	}

	public void setRejected(Boolean rejected) {
		this.rejected = rejected;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
		
	
}
