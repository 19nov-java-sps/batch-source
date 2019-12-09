package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Expenses;
import com.revature.models.UserLogin;
import com.revature.service.ExpenseService;
import com.revature.service.UserLogInService;

public class ExpDelegate {
	private ExpenseService employeeService = new ExpenseService();

public void getExpenses(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String idStr = request.getParameter("id");
		if (idStr == null) {
			List<Expenses> employees = employeeService.getAllExpenses();
			
			try(PrintWriter pw = response.getWriter();){
				pw.write(new ObjectMapper().writeValueAsString(employees));
			}	
		} else {
			if(idStr.matches("^\\d+$")) {
				List<Expenses> e = employeeService.getExpenseById(Integer.parseInt(idStr));
				
				if (e == null) {
					response.sendError(404, "No employee with given ID");
				} else {
					try(PrintWriter pw = response.getWriter()){
						pw.write(new ObjectMapper().writeValueAsString(e));
					}
				}
			} else {
				response.sendError(400, "Invalid ID param");
			}
		}
	}
	

public void resolvedExpenses(HttpServletRequest request, HttpServletResponse response) throws IOException {

	String idStr = request.getParameter("id");
	
	if (idStr == null) {
		System.out.println("null id");
		List<Expenses> expenses = employeeService.resolvedExpenses();
//		System.out.println("paramter id is= "+idStr);
		try(PrintWriter pw = response.getWriter();){
//			System.out.println("axtually doesnt work");
			pw.write(new ObjectMapper().writeValueAsString(expenses));
		}
	} else {
		if (idStr.matches("^\\d+$")) {
			List<Expenses>expenses = employeeService.getExpenseById((Integer.parseInt(idStr)));
			try(PrintWriter pw = response.getWriter()){
//				System.out.println("somehow work");
				pw.write(new ObjectMapper().writeValueAsString(expenses));
//				System.out.println(expenses);
			}
		} else {
			response.sendError(400, "Invalid ID param");
		}
	}
	
}

public void resolvedExpenses2(HttpServletRequest request, HttpServletResponse response) throws IOException {

	String idStr = request.getParameter("id");
	
	if (idStr == null) {
		System.out.println("null id");
		List<Expenses> expenses = employeeService.resolvedExpenses();
//		System.out.println("paramter id is= "+idStr);
		try(PrintWriter pw = response.getWriter();){
			pw.write(new ObjectMapper().writeValueAsString(expenses));
		}
	} else {
		if (idStr.matches("^\\d+$")) {
			System.out.println("set up single id getexpense");
			List<Expenses>expenses = employeeService.getIndividualsExpenseById((Integer.parseInt(idStr)));
			try(PrintWriter pw = response.getWriter()){
//				System.out.println("somehow work");
				pw.write(new ObjectMapper().writeValueAsString(expenses));
//				System.out.println(expenses);
			}
		} else {
			response.sendError(400, "Invalid ID param");
		}
	}
}


public void pendingExpenses(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
	String idStr = request.getParameter("id");
	if (idStr == null) {
		List<Expenses> expenses = employeeService.pendingExpenses();
		try(PrintWriter pw = response.getWriter();){
			pw.write(new ObjectMapper().writeValueAsString(expenses));
		}
	} else {
		if (idStr.matches("^\\d+$")) {
			List<Expenses> expenses = employeeService.getPendingById((Integer.parseInt(idStr)));
			try(PrintWriter pw = response.getWriter()){
				pw.write(new ObjectMapper().writeValueAsString(expenses));
			}
		} else {
			response.sendError(400, "Invalid ID param");
		}
	}
	
}



public void addExpenses(HttpServletRequest request, HttpServletResponse response) throws IOException {
	String amount = request.getParameter("amount");
	String type = request.getParameter("type");
	String userid = request.getParameter("emplId");
//	System.out.println(userid+"userid");
//	System.out.println(amount+"amount");
//	System.out.println(type+"type");
	
	int success = employeeService.submitExp(Double.parseDouble(amount), Integer.parseInt(userid), type);
	if (success == 1) {
		response.setStatus(201);
	} else {
		response.sendError(400);
	}
}


public void updateExpensesById(HttpServletRequest request, HttpServletResponse response) throws IOException {
	

	String Expenses = request.getReader().readLine();
	String[] single = Expenses.split("=");
	String[] parameters = new String[3];
	System.out.println(single+"this is reim");
	for (int i = 1; i <= 3; i++) {
		String aString = single[i].split("&")[0];
		parameters[i-1] = aString;
	}

	int expenseid = Integer.parseInt(parameters[0]);
	int managerid = Integer.parseInt(parameters[1]);
	String approvalstatus = parameters[2];
	
	System.out.println(expenseid+"exp id");
	System.out.println(managerid+"man id");
	System.out.println(approvalstatus+"app status");

	int updatedReim = employeeService.updateExpense(expenseid, managerid, approvalstatus);
	if (updatedReim == 1) {
		response.setStatus(204);
	} else {
		response.sendError(400);
	}
	
	
}


	
	
}
