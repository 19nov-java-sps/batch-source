package com.revature.model;

import java.io.Serializable;

public class Reimbursement implements Serializable {

	private static final long serialVersionUID = 1L;

	private int reimbursementID;
	private int employeeID;
	private double amount;
	private String description;
	private String dateSubmission;
	private String dateApproval;
	private boolean rejected;

	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int reimbursementID, int employeeID, double amount, String description, String dateSubmission,
			String dateApproval, boolean rejected) {
		super();
		this.reimbursementID = reimbursementID;
		this.employeeID = employeeID;
		this.amount = amount;
		this.description = description;
		this.dateSubmission = dateSubmission;
		this.dateApproval = dateApproval;
		this.rejected = rejected;
	}

	public int getReimbursementID() {
		return reimbursementID;
	}

	public void setReimbursementID(int reimbursementID) {
		this.reimbursementID = reimbursementID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
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

	public String getDateSubmission() {
		return dateSubmission;
	}

	public void setDateSubmission(String dateSubmission) {
		this.dateSubmission = dateSubmission;
	}

	public String getDateApproval() {
		return dateApproval;
	}

	public void setDateApproval(String dateApproval) {
		this.dateApproval = dateApproval;
	}

	public boolean getisRejected() {
		return rejected;
	}

	public void setRejected(boolean rejected) {
		this.rejected = rejected;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dateApproval == null) ? 0 : dateApproval.hashCode());
		result = prime * result + ((dateSubmission == null) ? 0 : dateSubmission.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + employeeID;
		result = prime * result + reimbursementID;
		result = prime * result + (rejected ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Reimbursement)) {
			return false;
		}
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount)) {
			return false;
		}
		if (dateApproval == null) {
			if (other.dateApproval != null) {
				return false;
			}
		} else if (!dateApproval.equals(other.dateApproval)) {
			return false;
		}
		if (dateSubmission == null) {
			if (other.dateSubmission != null) {
				return false;
			}
		} else if (!dateSubmission.equals(other.dateSubmission)) {
			return false;
		}
		if (description == null) {
			if (other.description != null) {
				return false;
			}
		} else if (!description.equals(other.description)) {
			return false;
		}
		if (employeeID != other.employeeID) {
			return false;
		}
		if (reimbursementID != other.reimbursementID) {
			return false;
		}
		if (rejected != other.rejected) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementID=" + reimbursementID + ", employeeID=" + employeeID + ", amount=" + amount
				+ ", description=" + description + ", dateSubmission=" + dateSubmission + ", dateApproval="
				+ dateApproval + ", rejected=" + rejected + "]";
	}

}
