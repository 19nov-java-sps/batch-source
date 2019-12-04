package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.impl.ReimbursementDaoImpl;
import com.revature.daos.ReimbursementDao;
import com.revature.models.Employee;
import com.revature.models.Reimbursement;

import com.revature.services.ReimbursementService;




public class ReimbursementDelegate {

	
	private ReimbursementService re= new ReimbursementService();
	private ReimbursementDao rem= new ReimbursementDaoImpl();
	public void Reimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
			List<Reimbursement> reimbursements = re.getPendingReimbursements();
			try(PrintWriter pw = response.getWriter();){
				pw.write(new ObjectMapper().writeValueAsString(reimbursements));
				pw.close();
			}	
		} 
	
	public void FinalReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		List<Reimbursement> reimbursements = re.getResolvedReimbursements();
		try(PrintWriter pw = response.getWriter();){
			pw.write(new ObjectMapper().writeValueAsString(reimbursements));
			pw.close();
		}	
	} 
	
	public void createReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String reasonfor = request.getParameter("reasonfor");
		String amount = request.getParameter("amount");
		int amountfor= Integer.parseInt(amount);
		String id= request.getParameter("id");
		int id1= Integer.parseInt(id);
		
		Reimbursement rea= new Reimbursement(reasonfor,amountfor, true, id1,"Pending");
		
		re.createReimbursement(rea);
		

		
	}
	
	public void amendReimbursement(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String id = request.getParameter("id");
		String status= request.getParameter("status");
		String managerid=request.getParameter("managerid");
		int id1= Integer.parseInt(id);
		int id2= Integer.parseInt(managerid);
		
		
re.resolveReimbursement(id1, id2, status);
		
	}
	
	
	
	
	/*
	public void getEmployeeById(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		Employee employees = employeeService.getById(1);
		try(PrintWriter pw = response.getWriter();){
			pw.write(new ObjectMapper().writeValueAsString(employees));
		}	
	} 
	*/
	
	
	
}
	













