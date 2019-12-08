package delegates;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Department;
import services.DepartmentService;

public class DepartmentDelegate {

		private DepartmentService departmentService = new DepartmentService();
		
		public void getDepartments(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
			List<Department> depts = departmentService.getDepartments();
			
			try(PrintWriter pw = response.getWriter();){
				pw.write(new ObjectMapper().writeValueAsString(depts));	
			} 
		}
}
