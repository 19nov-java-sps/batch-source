package com.revature.dao;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDao {
	
	public List<Reimbursement> getPendingReim();
	public List<Reimbursement> getResolvedReim();
	public List<Reimbursement> getPendingReimById(int emplId);
	public List<Reimbursement> getResolvedReimById(int emplId);
	public Reimbursement getReimById(int reimId);
	public int updateReim(int reimId, int managerId, String result, String reason);
	public int createReim(double amount, int emplId, String description);
}
