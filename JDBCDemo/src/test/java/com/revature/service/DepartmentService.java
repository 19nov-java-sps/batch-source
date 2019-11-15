package com.revature.service;

import java.util.List;

import com.revature.dao.DepartmentDao;
import com.revature.dao.impl.DepartmentDaoImpl;
import com.revature.model.Department;

public class DepartmentService {
	
	private DepartmentDao departmentDao = new DepartmentDaoImpl();
	
	public List<Department> getDepartments(){
		return departmentDao.getDepartments();
	}
	
	public Department getDepartmentById(int id) {
		return departmentDao.getDepartmentById(id);
	}
	
	public boolean createDepartment(Department d) {
		int deptCreated = departmentDao.createDepartment(d);
		if(deptCreated != 0) {
			return true;
		}
		return false;
	}
	
	public boolean updateDepartment(Department d) {
		int deptUpdated = departmentDao.updateDepartment(d);
		if(deptUpdated != 0) {
			return true;
		}
		return false;
	}

}