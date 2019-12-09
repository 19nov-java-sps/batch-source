package com.revature.models;

import java.io.Serializable;

public class Expenses implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int expenseId;
	private String approvalStatus;
	private double expenseAmount;
	private int userId;
	private String expenseType;
	private int managerId;
	public Expenses(int expenseId, String approvalStatus, double expenseAmount, int userId, String expenseType,
			int managerId) {
		super();
		this.expenseId = expenseId;
		this.approvalStatus = approvalStatus;
		this.expenseAmount = expenseAmount;
		this.userId = userId;
		this.expenseType = expenseType;
		this.managerId = managerId;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public Expenses() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Expenses(int expenseId, String approvalStatus, double expenseAmount, int userId, String expenseType) {
		super();
		this.expenseId = expenseId;
		this.approvalStatus = approvalStatus;
		this.expenseAmount = expenseAmount;
		this.userId = userId;
		this.expenseType = expenseType;
	}
	@Override
	public String toString() {
		return "Expenses [expenseId=" + expenseId + ", approvalStatus=" + approvalStatus + ", expenseAmount="
				+ expenseAmount + ", userId=" + userId + ", expenseType=" + expenseType + ", managerId=" + managerId
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((approvalStatus == null) ? 0 : approvalStatus.hashCode());
		long temp;
		temp = Double.doubleToLongBits(expenseAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + expenseId;
		result = prime * result + ((expenseType == null) ? 0 : expenseType.hashCode());
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
		Expenses other = (Expenses) obj;
		if (approvalStatus == null) {
			if (other.approvalStatus != null)
				return false;
		} else if (!approvalStatus.equals(other.approvalStatus))
			return false;
		if (Double.doubleToLongBits(expenseAmount) != Double.doubleToLongBits(other.expenseAmount))
			return false;
		if (expenseId != other.expenseId)
			return false;
		if (expenseType == null) {
			if (other.expenseType != null)
				return false;
		} else if (!expenseType.equals(other.expenseType))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	public int getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(int expenseId) {
		this.expenseId = expenseId;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public double getExpenseAmount() {
		return expenseAmount;
	}
	public void setExpenseAmount(double expenseAmount) {
		this.expenseAmount = expenseAmount;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
