package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.daos.EmployeeDao;
import com.revature.models.Employee;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {
	
	@InjectMocks
	private EmployeeService es;
	
	@Mock
	private EmployeeDao ed;
	
	@Test
	public void testGettingEmployees() {
		
		List<Employee> employees = new ArrayList<>();
		
		employees.add(new Employee());
		employees.add(new Employee());
		
		when(ed.getEmployees()).thenReturn(employees);
		
		assertEquals(es.getEmployees().size(), 2);
	}
	
	@Test
	public void testGettingEmployeeByUsername() {
		
		Employee expected = new Employee("adonis", "cabreja", "adonisc", "password", 1);
		
		when(ed.getEmployeeByUsername("adonisc")).thenReturn(new Employee("adonis", "cabreja", "adonisc", "password", 1));
		
		Employee actual = es.getEmployeeByUsername("adonisc");
		
		assertEquals(expected, actual);
	}
}
