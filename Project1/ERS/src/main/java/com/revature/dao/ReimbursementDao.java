package com.revature.dao;

import java.util.List;

import com.revature.models.Reimbursement;

public interface ReimbursementDao {

	public int createReimbursement(Reimbursement r);

	public int updateReimbursement(Reimbursement r);

	public int deleteReimbursement(Reimbursement r);

	public List<Reimbursement> getPendingReimbursements();

	public List<Reimbursement> getResolvedReimbursements();

	public List<Reimbursement> getPendingReimbursementById(int id);

	public List<Reimbursement> getResolvedReimbursementById(int id);

	public int approved(boolean pending, boolean approved, boolean denied, boolean resolved,
			int reimbursementID);

	public int denied(boolean pending, boolean approved, boolean denied, boolean resolved, int reimbursementID);
}
