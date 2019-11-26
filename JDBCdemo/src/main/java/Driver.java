import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.revature.model.Department;
import com.revature.service.DepartmentService;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) throws SQLException {

//		try {
//			String driverName = ConnectionUtil.getConnection().getMetaData().getDriverName();
//			System.out.println(driverName);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		DepartmentService ds = new DepartmentService();
//		List<Department> depts = ds.getDepartments();
//		for (Department d : depts) {
//			System.out.println(d);
//		}

//		Department myDept = ds.getDepartmentById(5);
//		System.out.println(myDept);

			Department newDepartment = new Department();
			newDepartment.setId(5);
			newDepartment.setName("Public Relations");
			newDepartment.setmonthlyBudget(4000);
			boolean success = ds.createDepartment(newDepartment);
			System.out.println("success? " + success);

//		Department previouslyCreatedDepartment = ds.getDepartmentById(8);
//		System.out.println(previouslyCreatedDepartment);
//		previouslyCreatedDepartment.setName("Cool Updated Department");
//		boolean success = ds.updateDepartment(previouslyCreatedDepartment);
//		System.out.println("success? "+ success);
//		Department postUpdate = ds.getDepartmentById(8);
//		System.out.println(postUpdate);

	}
}
