package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reimbursements {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	

	
	@Column(name="reasonfor")
	private String reasonForReimbursement;
	
	
	
	@Column(name="reimbursementAmount")
	private double reimbursementAmount;
	
	
	@Column(name="ispending")
	private boolean isPending;
	
	@Column(name="employeeid")
	private int userId;


	private int resolvedBy;
	
	
	
	
	@Column(name="status")
	private String status;
	
	
	
	public Reimbursements() {
		super();
	}



	public Reimbursements(String reasonForReimbursement, double reimbursementAmount, boolean isPending,
			int userId, String status) {
		super();
		
		this.reasonForReimbursement = reasonForReimbursement;
		this.reimbursementAmount = reimbursementAmount;
		this.isPending = isPending;
		this.userId = userId;
		
		this.status = status;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "Reimbursements [id=" + id + ", reasonForReimbursement=" + reasonForReimbursement
				+ ", reimbursementAmount=" + reimbursementAmount + ", isPending=" + isPending + ", userId=" + userId
				+ ", resolvedBy=" + resolvedBy + ", status=" + status + "]";
	}
	
	
	
	
	

	
}
	
