package com.revature.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDao;
import com.revature.daoimpl.EmployeeDaoImpl;
import com.revature.model.Employee;



public abstract class EmployeeService {
	
	public abstract List<Employee> getManagersEmployeesByEmployeeId (int empId);
	
	public abstract Employee getManagerByEmployeeId (int empId);
	
	
	private EmployeeDao emplDao = new EmployeeDaoImpl();
	
	public boolean isAuthorized(HttpServletRequest request) {
		String authToken = request.getHeader("Authorization");
		if(authToken!=null) {
			String[] tokenArr = authToken.split(":");
				if(tokenArr.length == 2) {
				String idStr = tokenArr[0];
				String emplReportTo = tokenArr[1];
				if(idStr.matches("^\\d+$")) {
						Employee e = emplDao.getEmployeeById(Integer.parseInt(idStr));
					if(e!=null && e.getReportTo()==(Integer.parseInt(emplReportTo))){
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
		String token = e.getEmplId()+":"+e.getReportTo();
		response.setStatus(200);
		response.setHeader("Authorization", token);
	} else {
		response.sendError(401);
	}
	
}

}


