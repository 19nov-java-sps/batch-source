package com.revature.dao;

import java.util.List;

import com.revature.model.Employees;

public interface EmployeesDao {

	public List<Employees> getEmployees();

	public Employees getEmployeesById(int id);

//	public Employees getUserPass(String userName);

	public int createCustomer(Employees e);

	public int updateCustomer(Employees e);

	public int deleteCustomer(Employees e);

//	public void depositFunds(Employees e, double increase);
//
//	public void withdrawFunds(Employees e, double decrease);
//
//	public int generateCustomerId();
}
