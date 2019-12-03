package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDao;
import com.revature.daoimpl.EmployeeDaoImpl;
import com.revature.model.Employee;

public class EmplDelegate {
	
	private EmployeeDao emplDao = new EmployeeDaoImpl();
	
	public void getEmpl(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idStr = request.getParameter("id");
		if(idStr == null) {
			List<Employee> employees = emplDao.getAllEmployee();
			try(PrintWriter pw = response.getWriter();){
				pw.write(new ObjectMapper().writeValueAsString(employees));
			}
		}else {
			if(idStr.matches("^\\d+$")) {
				Employee e = emplDao.getEmployeeById(Integer.parseInt(idStr));
				if(e==null) {
					response.sendError(404, "No employee with given ID");
				}else {
					response.sendError(400, "Invalid ID param");
				}
			}
		}
	}



}
