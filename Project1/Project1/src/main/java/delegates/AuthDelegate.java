package delegates;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import dao.impl.EmployeeDaoImpl;
import models.Employee;
import services.EmployeeService;

public class AuthDelegate {
	
	private EmployeeService employeeService = new EmployeeService();
	
	public boolean isAuthorized(HttpServletRequest request) {
		String authToken = request.getHeader("Authorization");
		if(authToken != null) {
			String[] tokenArr = authToken.split(":");
			
			if (tokenArr.length == 2) {
				String idStr = tokenArr[0];
				//String isManager = tokenArr[1];
				if (idStr.matches("^\\d+$")) {
					Employee e = employeeService.getEmplById(Integer.parseInt(idStr));
				}
			}
		}
		return false;
	}
	
	public void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		System.out.println("email is " +  email); 
		System.out.println("password is : " + pass); 
		
		Employee empl = employeeService.getLogin(email, pass); 
		System.out.println("pooop:" + empl);

		if (empl != null) {
			String token = empl.getEmplId()+ ":" + empl.isManager();
			response.setStatus(200);
			response.setHeader("Authorization", token);
		} else {
			response.sendError(401);
		}
	}

}