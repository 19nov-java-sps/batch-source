package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;

public class ReimbursementDaoImpl implements ReimbursementDao {

	@Override
	public List<Reimbursement> getPendingReim() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getResolvedReim() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getPendingReimById(int emplId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getResolvedReimById(int emplId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimbursement getReimById(int reimId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateReim(int reimId, int managerId, String result, String reason) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int createReim(double amount, int emplId, String description) {
		// TODO Auto-generated method stub
		return 0;
	}

}
