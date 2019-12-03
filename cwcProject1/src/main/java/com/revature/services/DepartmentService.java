package com.revature.services;

import java.util.List;

import com.revature.dao.DepartmentDao;
import com.revature.dao.impl.DepartmentDaoImpl;
import com.revature.models.Department;

public class DepartmentService {
	
	DepartmentDao departmentDao = new DepartmentDaoImpl();
	
	public List<Department> getDepartments() {
		return departmentDao.getAllDept();
	}
	
	public Department getDeptById(int id) {
		return departmentDao.getDeptById(id);
	}
}
