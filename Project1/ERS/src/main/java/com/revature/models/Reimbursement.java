package com.revature.models;

import java.io.Serializable;

public class Reimbursement implements Serializable {

	private static final long serialVersionUID = 1L;

	private int reimbursementID;
	private int employeeID;
	private double amount;
	private String reason;
	private boolean pending;
	private boolean approved;
	private boolean denied;
	private boolean resolved;

	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reimbursement(int employeeID, double amount, String reason, boolean pending, boolean approved,
			boolean denied, boolean resolved) {
		super();
		this.employeeID = employeeID;
		this.amount = amount;
		this.reason = reason;
		this.pending = pending;
		this.approved = approved;
		this.denied = denied;
		this.resolved = resolved;
	}

	public Reimbursement(int reimbursementID, int employeeID, double amount, String reason, boolean pending,
			boolean approved, boolean denied, boolean resolved) {
		super();
		this.reimbursementID = reimbursementID;
		this.employeeID = employeeID;
		this.amount = amount;
		this.reason = reason;
		this.pending = pending;
		this.approved = approved;
		this.denied = denied;
		this.resolved = resolved;
	}

	public Reimbursement(int userID, int invoiceID, double amount2, String reason2) {
		// TODO Auto-generated constructor stub
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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
		result = prime * result + (approved ? 1231 : 1237);
		result = prime * result + (denied ? 1231 : 1237);
		result = prime * result + employeeID;
		result = prime * result + (pending ? 1231 : 1237);
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + reimbursementID;
		result = prime * result + (resolved ? 1231 : 1237);
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
		if (approved != other.approved) {
			return false;
		}
		if (denied != other.denied) {
			return false;
		}
		if (employeeID != other.employeeID) {
			return false;
		}
		if (pending != other.pending) {
			return false;
		}
		if (reason == null) {
			if (other.reason != null) {
				return false;
			}
		} else if (!reason.equals(other.reason)) {
			return false;
		}
		if (reimbursementID != other.reimbursementID) {
			return false;
		}
		if (resolved != other.resolved) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementID=" + reimbursementID + ", employeeID=" + employeeID + ", amount=" + amount
				+ ", reason=" + reason + ", pending=" + pending + ", approved=" + approved + ", denied=" + denied
				+ ", resolved=" + resolved + "]";
	}

}
