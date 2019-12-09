package com.revature.dao;

import java.util.List;

import com.revature.model.Reimbursement;

public interface ReimbursementDao {
	
	public static List<Reimbursement> getAllReimbursement() {
		// TODO Auto-generated method stub
		return null;
	}
	public	Reimbursement getReimbursementById(int rId);
	public	int createReimbursement(Reimbursement r);
	public int deleteReimbursement(Reimbursement r);
	public int updateReimbursement(Reimbursement r);

}
