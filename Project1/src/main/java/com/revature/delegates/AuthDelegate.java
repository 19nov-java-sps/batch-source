package com.revature.delegates;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDao;
import com.revature.dao.impl.EmployeeDaoImpl;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class AuthDelegate {
	
	private EmployeeService employeeService = new EmployeeService();
	
	public boolean isAuthorized(HttpServletRequest request) {
		String authToken = request.getHeader("Authorization");
		if(authToken != null) {
			String[] tokenArr = authToken.split(":");
			
			if (tokenArr.length == 3) {
				String idStr = tokenArr[0];
				String isManager = tokenArr[1];
				if (idStr.matches("^\\d+$")) {
					Employee e = employeeService.getEmplById(Integer.parseInt(idStr));
					if(e != null && e.getIsManager() == Integer.parseInt(isManager)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		
		Employee empl = employeeService.getLogin(email, pass);

		if (empl != null) {
			String token = empl.getEmplId() + ":" + empl.getIsManager() + ":" + empl.getManagerId();
			response.setStatus(200);
			response.setHeader("Authorization", token);
		} else {
			response.sendError(401);
		}
	}

}
