package com.revature.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.dao.EmployeeDao;
import com.revauture.model.Employee;



@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

	@InjectMocks
	private EmployeeService es;
	
	@Mock
	private EmployeeDao ed;
	
	@Test
	public void testGetEmployees() {
		
		List<Employee> employeesList = new ArrayList<>();
		employeesList.add(new Employee());
		employeesList.add(new Employee());
		employeesList.add(new Employee());
		when(ed.getEmployees()).thenReturn(employeesList);
		assertEquals(es.getEmployees().size(),3);
		
	}

	@Test
	public void testGetEmployeeById() {
		
		Employee employee = new Employee(5, "pnguye17", "1234", "Peter Nguyen", true);
		when(ed.getEmployeeById(5)).thenReturn(employee);
		assertEquals(es.getEmployeeById(5), ed.getEmployeeById(5));
		
		
	}
	
	
	@Test
	public void testUpdateEmployee() {
		boolean expected = true;
		Employee employee = new Employee();
		employee.setUserId(1);
		employee.setUsername("pnguye17");
		
		when(ed.updateEmployee(employee)).thenReturn(1);
		boolean actual = es.updateClient(employee);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDeleteBankAcct() {
		boolean expected = true;
		Employee employee = new Employee();
		employee.setUserId(1);
		employee.setUsername("pnguye17");
		
		when(ed.updateEmployee(employee)).thenReturn(1);
		boolean actual = es.updateClient(employee);
		assertEquals(expected, actual);
	}
	

}
