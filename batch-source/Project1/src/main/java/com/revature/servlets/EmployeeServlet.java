package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDao;
import com.revature.daoimpl.EmployeeDaoImpl;
import com.revature.model.Employee;


public class EmployeeServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EmployeeDao emplDao = new EmployeeDaoImpl();
	
	public EmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper om = new ObjectMapper();
		
		String idStr = request.getParameter("Id");
		
		if(idStr!=null) {
			if(idStr.matches("^\\d+$")) {
				int id = Integer.parseInt(idStr);
				Employee e = emplDao.getEmployeeById(id);
				if(e==null) {
					response.sendError(404);
				} else {
					String emplJSON = om.writeValueAsString(e);
					try(PrintWriter pw = response.getWriter()){
						pw.write(emplJSON);
					}
				}
			} else {
				response.sendError(400);
			}
		} else {
			List<Employee> employees = emplDao.getAllEmployee();	
			
			String emplJSON = om.writeValueAsString(employees);
			
			try(PrintWriter pw = response.getWriter()){
				pw.write(emplJSON);
			}
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String depart = request.getParameter("depart");
			
		Employee e = new Employee();
		e.setFirstName(firstName);  
		e.setLastName(lastName); 
		e.setDepart(depart);
	
	
		
		emplDao.createNewEmployee(e);
		
		response.sendRedirect("employees");
		
	}

	

}
