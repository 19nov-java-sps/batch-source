package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDao;
import com.revature.dao.impl.EmployeeDaoImpl;
import com.revauture.model.Employee;

public class EmployeeDelegate {
	
	private EmployeeDao employeeDao = new EmployeeDaoImpl();
	
	public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String idStr = request.getParameter("id");
		String uri = request.getServletPath();
		System.out.println("in our view delegate; resolving uri: "+ uri);
		if(idStr == null) {
			List<Employee> employees = employeeDao.getEmployees();
			try(PrintWriter pw = response.getWriter();){
				pw.write(new ObjectMapper().writeValueAsString(employees));
			}	
		} else {
			if(idStr.matches("^\\d+$")) {
				Employee employee = employeeDao.getEmployeeById(Integer.parseInt(idStr));
				if(employee==null) {
					response.sendError(404, "No employee with given ID");
				} else {
					try(PrintWriter pw = response.getWriter()){
						pw.write(new ObjectMapper().writeValueAsString(employee));
					}
				}
			} else {
				response.sendError(400, "Invalid ID param");
			}
		}
	}
	

	public void postEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		String employeeID = request.getParameter("userId");

		Employee employee = employeeDao.getEmployeeById(Integer.parseInt(employeeID));
		employee.setPassword(password);
		employee.setUsername(username);
		employee.setFullname(fullname);
		
		employeeDao.updateEmployee(employee);
	}
	
	
	public void deleteEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Employee employee = employeeDao.getUserByUsernameAndPassword(username, password);
		employeeDao.deleteEmployee(employee);
	}
		
}

	

