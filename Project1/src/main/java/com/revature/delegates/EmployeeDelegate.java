package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDao;
import com.revature.dao.impl.EmployeeDaoImpl;
import com.revature.models.Department;
import com.revature.models.Employee;
import com.revature.sendmail.RegisterMail;
import com.revature.services.EmployeeService;

public class EmployeeDelegate {

	private EmployeeService employeeService = new EmployeeService();
	private RegisterMail registerMail = new RegisterMail();
	
	public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String idStr = request.getParameter("id");
		if (idStr == null) {
			List<Employee> employees = employeeService.getEmployees();
			
			try(PrintWriter pw = response.getWriter();){
				pw.write(new ObjectMapper().writeValueAsString(employees));
			}	
		} else {
			if(idStr.matches("^\\d+$")) {
				Employee e = employeeService.getEmplById(Integer.parseInt(idStr));
				
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
	
	public void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String emplString = request.getReader().readLine();
		String[] emplArr = emplString.split("=");
		String[] parameters = new String[4];
		for (int i = 1; i < 5; i++) {
			String aString = emplArr[i].split("&")[0];
			parameters[i-1] = aString;
		}

		int emplId = Integer.parseInt(parameters[0]);
		String password = parameters[1];
		String email = parameters[2];
		String phone = parameters[3];

		int emplUpdated = employeeService.updateEmplInfo(emplId, password, email, phone);
		if (emplUpdated == 1) {
			response.setStatus(204);
		} else {
			response.sendError(400);
		}
	}
	
	public void registeEmpl(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String position = request.getParameter("position");
		int managerId = Integer.parseInt(request.getParameter("managerId"));
		
		Department dept = new Department();
		dept.setDeptId(Integer.parseInt(request.getParameter("deptId")));
		
		String pass = "";
		for (int i = 0; i < 8; i++) {
			int random = ThreadLocalRandom.current().nextInt(0, 10);
			pass += random;
		}
		
		Employee empl = new Employee(0, firstname, lastname, email, phone, pass, managerId, 0, dept, position);
		
		int emplCreated = employeeService.registeEmpl(empl);
		
		if (emplCreated == 1) {
			registerMail.setEmplAuth(pass);
			registerMail.sendRegisterMail();

			response.setStatus(201);
		} else {
			response.sendError(400);
		}
	}
}


