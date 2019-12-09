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
			System.out.println("I am in AuthDeligate isAutorized method");
			String authToken = request.getHeader("Authorization");
			System.out.println("AuthToken = " +authToken);
			if(authToken!=null) {
				System.out.println("I am in AuthDeligate isAutorized method if authToken!=0");
				String[] tokenArr = authToken.split(":");
				System.out.println("tokenArr = " + tokenArr[0]+tokenArr[1]);
				if(tokenArr.length == 2) {
					System.out.println("I am in AuthDeligate isAutorized method if authToken==2");
					String idStr = tokenArr[0];
					String reportTo = tokenArr[1];
					System.out.println("idStr and reportTo = "+ idStr +" " + reportTo );
					
					if(idStr.matches("^\\d+$")) {
						System.out.println("I am in AuthDeligate isAutorized method if idStr mathes ^\\\\d+$");
						System.out.println("idStr = " + idStr);
						System.out.println(Integer.parseInt(idStr));
						Employee e = emplDao.getEmployeeById(Integer.parseInt(idStr));
						
						System.out.println(e);
			
						if(e!=null && e.getReportTo()==(Integer.parseInt(reportTo))) {
							System.out.println("I am in AuthDeligate isAutorized method where userRoleStr validates");
							System.out.println("Here is equality " + e.getReportTo()+Integer.parseInt(reportTo)+" not parsing reportTo " + reportTo);
							
							return true;
						}
					}
				}
			}
			System.out.println("I am in AuthDeligate isAutorized method false statement when token =0");
			return false;
	}

		
		public void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println("I am in AuthDeligate authenticate method");
			System.out.println("user = " + username+" password = " + password);
			
			Employee e = emplDao.getEmployeeByUserNameAndPassWord(username, password);
				if(e!=null) {
					System.out.println("I am in AuthDeligate authenticate method if u!=0");
					String token = e.getEmplId() + ":" + e.getReportTo();
					System.out.println("token =" +e.getEmplId()+":"+e.getReportTo());
					
					response.setStatus(200);
					response.setHeader("Authorization", token);
					System.out.println(token);
								}else {
				//	System.out.println("AuthDeligate authenticate else");
					response.sendError(401);
				}
			}
		}

