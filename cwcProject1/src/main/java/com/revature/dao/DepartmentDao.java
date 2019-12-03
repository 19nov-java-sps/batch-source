package com.revature.dao;

import java.util.List;

import com.revature.models.Department;

public interface DepartmentDao {

	public List<Department> getAllDept();
	public Department getDeptById(int id);
}
