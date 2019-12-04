package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDao;
import com.revature.daoimpl.EmployeeDaoImpl;
import com.revature.models.Employee;

public class EmployeeDelegate {

	private EmployeeDao employeeDao = new EmployeeDaoImpl();

	public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idStr = request.getParameter("id");
		if (idStr == null) {
			List<Employee> employee = employeeDao.getAllEmployees();
			try (PrintWriter pw = response.getWriter();) {
				pw.write(new ObjectMapper().writeValueAsString(employee));
			}
		} else {
			if (idStr.matches("^\\d+$")) {
				Employee e = employeeDao.getEmployeeById(Integer.parseInt(idStr));
				if (e == null) {
					response.sendError(404, "No user with given ID");
				} else {
					try (PrintWriter pw = response.getWriter()) {
						pw.write(new ObjectMapper().writeValueAsString(e));
					}
				}
			} else {
				response.sendError(400, "Invalid ID param");
			}
		}

	}
	
	

//	List<Employee> employee = employeeDao.getAllEmployees();
//	try (PrintWriter pw = response.getWriter();) {
//		pw.write(new ObjectMapper().writeValueAsString(employee));
//		pw.close();
//	}
//}
//
//public void getEmployeeById(HttpServletRequest request, HttpServletResponse response) throws IOException {
//	
//	Employee employee = employeeDao.getEmployeeById(1);
//	try (PrintWriter pw = response.getWriter();) {
//		pw.write(new ObjectMapper().writeValueAsString(employee));
//		pw.close();
//	}
//}

}
