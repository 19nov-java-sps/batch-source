package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursementDao;
import com.revature.daos.ReimbursementDaoImpl;
import com.revature.models.Reimbursement;

public class ReimbursementService {
	
	private ReimbursementDao rd = new ReimbursementDaoImpl();
	
	// gets all the reimbursements
	public List<Reimbursement> getReimbursements() {
		
		return rd.getReimbursements();
	}
	
	// gets reimbursements by username
	public List<Reimbursement> getReimbursementsByUsername(String username) {
		
		return rd.getReimbursementsByUsername(username);
	}
	
	// gets reimbursements by status
	public List<Reimbursement> getReimbursementsByStatus(String status) {
		
		return rd.getReimbursementsByStatus(status);
	}
	
	// gets reimbursements by username and status
	public List<Reimbursement> getReimbursementsByStatusAndUsername(String status, String username) {
		
		return rd.getReimbursementsByStatusAndUsername(status, username);
	}
	
	// updates a reimbursement's status and manager name
	public int updateReimbursement(int reim_id, String managerName, String status) {
		
		return rd.updateReimbursement(reim_id, managerName, status);
	}
		
	// creates a reimbursement
	public int createReimbursement(Reimbursement r) {
		
		return rd.createReimbursement(r);
	}

}
