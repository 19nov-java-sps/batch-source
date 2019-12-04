package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.services.EmployeeService;

public class EmployeeDelegate {
	
	private EmployeeService employeeService = new EmployeeService();
	
	public void Employees(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
			List<Employee> employees = employeeService.getEmployees();
			try(PrintWriter pw = response.getWriter();){
				pw.write(new ObjectMapper().writeValueAsString(employees));
				pw.close();
			}	
		} 
	
	
	public void getEmployeeById(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		Employee employees = employeeService.getById(1);
		try(PrintWriter pw = response.getWriter();){
			pw.write(new ObjectMapper().writeValueAsString(employees));
		}	
	} 
	
	
	public void updateInfo(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email= request.getParameter("email");
		String password= request.getParameter("password");
		String id= request.getParameter("id");
		int id1= Integer.parseInt(id);

		Employee e= employeeService.getById(id1);
	
		if(firstname!="" && firstname!=null) {
			e.setFirstName(firstname);
		}
		
		
		 if(lastname!="" && lastname!=null) {
			
			e.setLastName(lastname);
			
			
		}
		 else {
			 e.setLastName(e.getLastName());
		 }
		
		if(email!="" && email!=null) {
			
			e.setEmailAddress(email);
			
			
		}
		else {
			e.setEmailAddress(e.getEmailAddress());
		}
		
		
		if(password!="" && password!=null) {
			
			e.setPassword(password);
			
			
		}
		else {
			e.setPassword(e.getPassword());
		}
		
		


	employeeService.updateEmployee(e);
		
		
		
		
		

		
	}
	
	
	
	
	
	
	
	
	
}