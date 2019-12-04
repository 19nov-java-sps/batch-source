package com.revature.daos;

import java.sql.SQLException;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;

public interface ReimbursementDao {

	public List<Reimbursement> getPendingReimbursements();
	public List<Reimbursement> getResolvedReimbursements();
	public List<Reimbursement> getPendingReimbursementById(int id);
	public List<Reimbursement> getResolvedReimbursementById(int id);
	public boolean createReimbursement(Reimbursement re) throws SQLException;
	public void resolveReimbursement(int i);

	void resolveReimbursement(int i, int manager, String status) throws SQLException;
	
	
}
