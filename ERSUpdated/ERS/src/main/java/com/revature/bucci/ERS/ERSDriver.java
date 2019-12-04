package com.revature.bucci.ERS;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.services.EmployeeService;
import com.revature.services.ReimbursementService;
import com.revature.util.ConnectionUtil;
public class ERSDriver {
	public static void main(String[] args) throws SQLException{
		EmployeeService emp= new EmployeeService();
		ReimbursementService re= new ReimbursementService();
		//Employee e= new Employee(4, "Justin", "Bucci", "jboocqh@aol.com","BOOCH","General");
		
		//Reimbursement rem= new Reimbursement("Transportation",10000.00, true, 2);
	//emp.create(e);


	//System.out.print(emp.Login("jbooch@aol.com", "BOOCH"));
		
	System.out.print(re.getPendingReimbursements());	

	//System.out.print(re.getResolvedReimbursements());
		
		//System.out.print(re.getPendingReimbursementById(2));
		
		//System.out.print(re.getResolvedReimbursementById(1));
		
		
		//System.out.print(re.createReimbursement(rem));
		
		
		//re.resolveReimbursement(1, 1);
	
	
	}
	
	
	
	
}

