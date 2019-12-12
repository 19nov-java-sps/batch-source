package com.revature.daos;

import java.util.List;

import com.revature.models.Department;

public interface DepartmentDao {
	public List<Department> getDepts();
	public Department getDeptById(int id);
}
