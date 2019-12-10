package com.revature;

import java.util.List;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.services.EmployeeService;
import com.revature.services.ReimbursementService;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		
		EmployeeService es = new EmployeeService();
		ReimbursementService rs = new ReimbursementService();
//		List<Employee> employees = es.getEmployees();
//		for (Employee e : employees) {
//			System.out.println(e);
//		}
		
//		System.out.println(es.getEmployees());
//		System.out.println(es.getEmployeeByUsername("adonisc"));
		
//		System.out.println(rs.getReimbursementById(4));
//		
//		rs.updateReimbursement(4, "testing", "Resolved");
//		HibernateUtil.closeSessionFactory();
	}
}

