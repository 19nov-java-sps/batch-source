package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.Reimbursements;


public interface ReimbursementDao {

	public List<Reimbursements> getPendingReimbursements();
	public List<Reimbursements> getResolvedReimbursements();
	public List<Reimbursements> getPendingReimbursementById(int id);
	public List<Reimbursements> getResolvedReimbursementById(int id);
	public boolean createReimbursement(Reimbursements re) throws SQLException;
	public void resolveReimbursement(int i);

	void resolveReimbursement(int i, int manager, String status) throws SQLException;
	
	
}
