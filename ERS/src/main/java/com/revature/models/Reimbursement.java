package com.revature.models;

public class Reimbursement {
	
	private String reasonForReimbursement;
	private double reimbursementAmount;
	private boolean isPending;
	private int userId;
	private int resolvedBy;
	private String status;
	public Reimbursement(String reasonForReimbursement, double reimbursementAmount, boolean isPending, int userId,
			int resolvedBy) {
		super();
		this.reasonForReimbursement = reasonForReimbursement;
		this.reimbursementAmount = reimbursementAmount;
		this.isPending = isPending;
		this.userId = userId;
		this.resolvedBy = resolvedBy;
	}
	public Reimbursement(String reasonfor, double amount, boolean ispending2, int userId2) {
		reasonForReimbursement=reasonfor;
		reimbursementAmount=amount;
		isPending= ispending2;
		userId=userId2;
	}
	public Reimbursement(String reasonfor, double amount, boolean ispending2, int userId2,int resolvedBy1,String status1) {
		reasonForReimbursement=reasonfor;
		reimbursementAmount=amount;
		isPending= ispending2;
		userId=userId2;
		resolvedBy=resolvedBy1;
		status=status1;
	}
	public Reimbursement(String reasonForReimbursement, double reimbursementAmount, boolean isPending, int userId,String status1) {
		super();
		this.reasonForReimbursement = reasonForReimbursement;
		this.reimbursementAmount = reimbursementAmount;
		this.isPending = isPending;
		this.userId = userId;
		this.status=status1;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getReasonForReimbursement() {
		return reasonForReimbursement;
	}
	public void setReasonForReimbursement(String reasonForReimbursement) {
		this.reasonForReimbursement = reasonForReimbursement;
	}
	public double getReimbursementAmount() {
		return reimbursementAmount;
	}
	public void setReimbursementAmount(double reimbursementAmount) {
		this.reimbursementAmount = reimbursementAmount;
	}
	public boolean isPending() {
		return isPending;
	}
	public void setPending(boolean isPending) {
		this.isPending = isPending;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getResolvedBy() {
		return resolvedBy;
	}
	public void setResolvedBy(int resolvedBy) {
		this.resolvedBy = resolvedBy;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isPending ? 1231 : 1237);
		result = prime * result + ((reasonForReimbursement == null) ? 0 : reasonForReimbursement.hashCode());
		long temp;
		temp = Double.doubleToLongBits(reimbursementAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + resolvedBy;
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
		Reimbursement other = (Reimbursement) obj;
		if (isPending != other.isPending)
			return false;
		if (reasonForReimbursement == null) {
			if (other.reasonForReimbursement != null)
				return false;
		} else if (!reasonForReimbursement.equals(other.reasonForReimbursement))
			return false;
		if (Double.doubleToLongBits(reimbursementAmount) != Double.doubleToLongBits(other.reimbursementAmount))
			return false;
		if (resolvedBy != other.resolvedBy)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Reimbursement [reasonForReimbursement=" + reasonForReimbursement + ", reimbursementAmount="
				+ reimbursementAmount + ", isPending=" + isPending + ", userId=" + userId + ", resolvedBy=" + resolvedBy
				+ ", status=" + status + "]";
	}
	
	
	
}
	
