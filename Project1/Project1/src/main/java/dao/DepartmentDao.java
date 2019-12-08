package dao;

import java.util.List;
import models.Department; 


public interface DepartmentDao {
	public List<Department> getAllDept(); 
	public Department getDeptById(int id); 
}
