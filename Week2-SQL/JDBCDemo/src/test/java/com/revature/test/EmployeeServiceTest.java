package com.revature.test;

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
import com.revature.model.Department;
import com.revature.model.Employee;
import com.revature.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {
	
	@InjectMocks
	private EmployeeService es;
	
	@Mock
	private EmployeeDao ed;

	@Test
	public void testGettingAllEmployees() {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee());
		empList.add(new Employee());
		empList.add(new Employee());
		when(ed.getEmployees()).thenReturn(empList);
		assertEquals(es.getEmployees().size(),3);
	}
	
	@Test
	public void testGettingEmployeeById() {
		when(ed.getEmployeeById(6)).thenReturn(new Employee(6,"Jemie Duffin", 3484, "MKT Rep",5, new Department(2, "Marketing", 12200)));
		Employee expected = new Employee(6,"Jemie Duffin", 3484, "MKT Rep",5, new Department(2, "Marketing", 12200));
		Employee actual = es.getEmployeeById(6);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testUpdatingEmployee() {
		boolean expected = true;
		Employee e = new Employee();
		e.setId(10);
		e.setName("Harold");
		
		when(ed.updateEmployee(e)).thenReturn(1);
		boolean actual = es.updateEmployee(e);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testUpdatingNullEmployee() {
		boolean expected = false;
		
		when(ed.updateEmployee(null)).thenReturn(0);
		boolean actual = es.updateEmployee(null);
		assertEquals(expected, actual);
	}
}
