package com.revature;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;


import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.model.Reimbursements;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) throws SQLException {
		EmployeeDaoImpl emp= new EmployeeDaoImpl();
		//System.out.print(emp.getEmployees());
		
		ReimbursementDaoImpl reim= new ReimbursementDaoImpl();
		
	//System.out.print(reim.getResolvedReimbursements());
		
		System.out.print(reim.getPendingReimbursements());
		//System.out.print(emp.getEmployeeById1(1));
		
		//Reimbursements re= new Reimbursements();
		;
		/*
		 * 
		 * 		this.reasonForReimbursement = reasonForReimbursement;
		this.reimbursementAmount = reimbursementAmount;
		this.isPending = isPending;
		this.userId = userId;
		
		this.status = status;
		
		*/
		/*
	Reimbursements re= new Reimbursements("Transportation", 100, false, 1, "Pending");
		
		reim.createReimbursement(re);
		HibernateUtil.closeSessionFactory();
		
		*/
	}

}
