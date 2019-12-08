package com.revature.servicelayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.daoimpl.ReimbursementDaoImpl;
import com.revature.models.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementService {

	ReimbursementDao reimDao = new ReimbursementDaoImpl();

	public int createReimbursement(Reimbursement r) {
		return reimDao.createReimbursement(r);
	}

	public List<Reimbursement> getPendingReimbursements() {
		return reimDao.getPendingReimbursements();
	}
	
	public List<Reimbursement> getResolvedReimbursements() {
		return reimDao.getResolvedReimbursements();
	}

}
