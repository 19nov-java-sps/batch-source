package com.revature.delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Department;
import com.revature.services.DepartmentService;

public class DepartmentDelegate {
	
	private DepartmentService departmentService = new DepartmentService();
	
	public void getDepartments(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Department> departments = departmentService.getAll();
		
		try(PrintWriter pw = response.getWriter()){
			pw.write(new ObjectMapper().writeValueAsString(departments));
		}
	}

}
