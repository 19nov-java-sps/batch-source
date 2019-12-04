package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import com.revature.dao.impl.EmployeeDaoImpl;
import com.revature.dao.impl.ReimbursementDaoImpl;
import com.revature.daos.EmployeeDao;
import com.revature.daos.ReimbursementDao;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;

public class ReimbursementService {

	
	ReimbursementDao red= new ReimbursementDaoImpl();
	
	public List<Reimbursement> getPendingReimbursements(){
		
		
		return red.getPendingReimbursements();
		
		
		
	}
	public List<Reimbursement> getResolvedReimbursements(){
		
		return red.getResolvedReimbursements();
		
		
	}
	
	
	public List<Reimbursement> getPendingReimbursementById(int id){
		
		return red.getPendingReimbursementById( id);
		
		
	}
	
	
	
	
	public List<Reimbursement> getResolvedReimbursementById(int id){
		
		return red.getResolvedReimbursementById(id);
		
	}
	
	
	
	
	public boolean createReimbursement(Reimbursement re) throws SQLException{
		
		
		
		return red.createReimbursement(re);
		
	}
	
	
	public void resolveReimbursement(int id, int managerid, String status) throws SQLException {
		
		red.resolveReimbursement(id, managerid, status);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
