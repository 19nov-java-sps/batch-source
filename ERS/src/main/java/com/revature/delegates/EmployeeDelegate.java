package com.revature.delegates;

import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDao;
import com.revature.daoimpl.EmployeeDaoImpl;
import com.revature.models.Employee;
import com.revature.servicelayer.EmployeeService;

public class EmployeeDelegate {

	private EmployeeDao employeeDao = new EmployeeDaoImpl();
	private EmployeeService employeeService = new EmployeeService();

	// gets list of employees or gets single employee by their id
	public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String path = request.getServletPath();
		System.out.println("I am in EmployeeDelegate" + path);
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

	// updates employee info
	public void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws IOException, SQLException {
		String path = request.getServletPath();
		System.out.println(path);
		String fullname = request.getParameter("fullName");
		String username = request.getParameter("userName");
		String password = request.getParameter("passWord");
		String id = request.getParameter("id");
		String stringIsManager = request.getParameter("manager");
		Boolean isManager = Boolean.parseBoolean(stringIsManager);
		int newId = Integer.parseInt(id);

		Employee e = employeeService.getEmployeeById(newId);
		System.out.println(employeeService.getEmployeeById(newId));

		// adds validation for update inputs
		e.setManager(isManager);
		if (fullname != "" && fullname != null) {
			e.setFullName(fullname);
		} else {
			e.setFullName(e.getFullName());
		}
		if (username != "" && username != null) {
			e.setUserName(username);
		} else {
			e.setUserName(e.getUserName());
		}
		if (password != "" && password != null) {
			e.setPassWord(password);
		} else {
			e.setPassWord(e.getPassWord());
		}
		System.out.println(employeeService.getEmployeeById(newId));
		System.out.println(e.getEmployeeID());
		e.setEmployeeID(newId);

		employeeService.updateEmployee(e);

	}

}
