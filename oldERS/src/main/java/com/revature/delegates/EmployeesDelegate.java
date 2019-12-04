package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeesDao;
import com.revature.daoimpl.EmployeesDaoImpl;
import com.revature.model.Employees;

public class EmployeesDelegate {

//	private EmployeesDao employeesDao = new EmployeesDaoImpl();
	private EmployeesDao employeesDao = new EmployeesDaoImpl();

	public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idStr = request.getParameter("id");
		if (idStr == null) {
			List<Employees> employees = employeesDao.getAllDummies();
			try (PrintWriter pw = response.getWriter();) {
				pw.write(new ObjectMapper().writeValueAsString(employees));
			}
		} else {
			if (idStr.matches("^\\d+$")) {
				Employees e = employeesDao.getDummiesById(Integer.parseInt(idStr));
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
}
