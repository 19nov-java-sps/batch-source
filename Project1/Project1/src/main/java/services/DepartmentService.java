package services;

import java.util.List;

import dao.DepartmentDao;
import dao.impl.DepartmentDaoImpl;
import models.Department;

public class DepartmentService {
	
	DepartmentDao departmentDao = new DepartmentDaoImpl();
	
	public List<Department> getDepartments() {
		return departmentDao.getAllDept();
	}
	
	public Department getDeptById(int id) {
		return departmentDao.getDeptById(id);
	}
}