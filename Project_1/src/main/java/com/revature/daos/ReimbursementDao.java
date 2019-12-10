package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDao {
	
	public List<Reimbursement> getReimbursements();
	public List<Reimbursement> getReimbursementsByUsername(String username);
	public List<Reimbursement> getReimbursementsByStatus(String status);
	public List<Reimbursement> getReimbursementsByStatusAndUsername(String status, String username);
	public Reimbursement getReimbursementById(int id);
	public int updateReimbursement(int reim_id, String managerName, String status);
	public int createReimbursement(Reimbursement reimbursement);
}
