package com.revature.database.JDBCDemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.revature.model.Department;
import com.revature.service.DepartmentService;
import com.revature.util.ConnectionUtil;

public class Driver {
	
	/*
	 * Creating a new Maven Project:
	 * 1. Go to the File tab (or Right Click in the Package Explorer) and 
	 * 		select "New" -> "Maven Project"
	 * 2. Within the setup wizard, check the "Create a Simple Project (no 
	 * 		archetype selection)" and click "Next"
	 * 3. Provide an identifier for the "GroupId" and "ArtifactId" 
	 * 		such as "com.revature" and "JDBCDemo" and click "Finish"
	 * 
	 * --- configure your project object model ---
	 * 4. Update your Maven Project - Right click on the project folder in 
	 * 		the "Package Explorer" -> "Maven" -> "Update Project"
	 */
	
	public static void main(String[] args){
		/* testing connection:
		try {
			String driverName = ConnectionUtil.getConnection().getMetaData().getDriverName();
			System.out.println(driverName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		DepartmentService ds = new DepartmentService();
		List<Department> depts = ds.getDepartments();
		for(Department d: depts) {
			System.out.println(d);
		}
		
		Department myDept = ds.getDepartmentById(5);
		System.out.println(myDept);

		Department newDepartment = new Department();
		newDepartment.setName("JDBC Department");
		newDepartment.setmonthlyBudget(3000);
		boolean success = ds.createDepartment(newDepartment);
		System.out.println("success? "+success);
		
		Department previouslyCreatedDepartment = ds.getDepartmentById(8);
		System.out.println(previouslyCreatedDepartment);
		previouslyCreatedDepartment.setName("Cool Updated Department");
		@SuppressWarnings("unused")
		boolean s = ds.updateDepartment(previouslyCreatedDepartment);
		System.out.println("success? "+ success);
		Department postUpdate = ds.getDepartmentById(8);
		System.out.println(postUpdate);
		
		
		
	}

}