package com.revature.services;

import java.util.List;

import com.revature.daos.ReimbursementDao;
import com.revature.daos.ReimbursementDaoImpl;
import com.revature.models.Reimbursement;

public class ReimbursementService {
	
	ReimbursementDao reimbursementDao = new ReimbursementDaoImpl();

	public List<Reimbursement> viewPendingReim() {
		return reimbursementDao.getPendingReim();
	}
	
	public List<Reimbursement> viewResolvedReim() {
		return reimbursementDao.getResolvedReim();
	}
	
	public List<Reimbursement> viewPendingReimById(int emplId) {
		return reimbursementDao.getPendingReimById(emplId);
	}
	
	public List<Reimbursement> viewResolvedReimById(int emplId) {
		return reimbursementDao.getResolvedReimById(emplId);
	}
	
	public Reimbursement viewReimbursementById(int reimId) {
		return reimbursementDao.getReimById(reimId);
	}
	
	public int resolveReim(int id) {
		return reimbursementDao.updateReim(id);
	}
	
	public int submitReim(Reimbursement reim) {
		return reimbursementDao.createReim(reim);
	}
}
