package com.revature.delegates;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDao;
import com.revature.daoimpl.EmployeeDaoImpl;
import com.revature.model.Employee;

public class AuthDelegate {

		private EmployeeDao emplDao = new EmployeeDaoImpl();
		
		public boolean isAuthorized (HttpServletRequest request) {
			String authToken = request.getHeader("Autorisation");
			if(authToken!=null) {
				String[] tokenArr = authToken.split(":");
				if(tokenArr.length == 2) {
					String idStr = tokenArr[0];
					String depart = tokenArr[1];
					if(idStr.matches("^\\d+&")) {
						Employee e = emplDao.getEmployeeById(Integer.parseInt(idStr));
						if(e!=null && e.getDepart().equals(depart)) {
							return true;
						}
					}
				}
			}
			return false;
	}

		
		public void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String username = request.getParameter("userName");
			String password = request.getParameter("passWord");
			
			Employee e = emplDao.getEmployeeByUserNameAndPassWord(username, password);
				if(e!=null) {
					String token = e.getEmplId() + ":" + e.getDepart();
					response.setStatus(200);
					response.setHeader("Authorization", token);
					
				}else {
					response.sendError(401);
				}
			}
		}

