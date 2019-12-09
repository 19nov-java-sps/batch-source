package delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.EmployeeDao;
import dao.impl.EmployeeDaoImpl;
import models.Department;
import models.Employee;
import services.EmployeeService;

public class EmployeeDelegate {

	private EmployeeService employeeService = new EmployeeService();
	
	public void getEmployees(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String idStr = request.getParameter("id");
		System.out.println(idStr);
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
		for (int i = 0; i < 4; ++i) {
//			String param = emplArr[i+1].split("&")[0];
//			parameters[i] = param;
			parameters[i] = emplArr[i+1].split("&")[0]; 
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
	
	public void registerEmpl(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String position = request.getParameter("position");
		int managerId = Integer.parseInt(request.getParameter("managerId"));
		
		Department dept = new Department();
		dept.setDeptId(Integer.parseInt(request.getParameter("deptId")));
		
		Employee empl = new Employee(0, firstname, lastname, email, phone, "12345", managerId, 0, dept, position);
		
		int emplCreated = employeeService.registerEmpl(empl);
		if (emplCreated == 1) {
			response.setStatus(201);
		} else {
			response.sendError(400);
		}
	}
}