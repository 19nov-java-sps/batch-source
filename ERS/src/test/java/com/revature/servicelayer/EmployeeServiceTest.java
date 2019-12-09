package com.revature.servicelayer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.dao.EmployeeDao;
import com.revature.models.Employee;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

	@InjectMocks
	private EmployeeService es;

	@Mock
	private EmployeeDao ed;

	@Test
	public void testGetAllEmployees() {
		List<Employee> employee = new ArrayList<>();

		employee.add(new Employee());
		employee.add(new Employee());

		when(ed.getAllEmployees()).thenReturn(employee);

		assertEquals(es.getAllEmployees().size(), 2);
	}

	// tests getCustomerId method
	@Test
	public void testGetEmployeeById() {
		when(ed.getEmployeeById(1)).thenReturn(new Employee(1, "MrHung", "pword", "Ryan"));
		Employee expected = new Employee(1, "MrHung", "pword", "Ryan");
		Employee actual = es.getEmployeeById(1);
		assertEquals(expected, actual);
	}


}
