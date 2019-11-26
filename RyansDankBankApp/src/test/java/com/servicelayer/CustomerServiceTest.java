package com.servicelayer;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.dao.CustomerDao;
import com.model.Customer;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

	/* 
	 * Tested all my CRUD methods through JUnit and Mockito
	 */
	
	
	@InjectMocks
	private CustomerService cs;

	@Mock
	private CustomerDao cd;

	// tests getCustomer method
	@Test
	public void testGetAllCustomers() {
		List<Customer> customerList = new ArrayList<>();
		customerList.add(new Customer());
		customerList.add(new Customer());
		customerList.add(new Customer());
		when(cd.getCustomer()).thenReturn(customerList);
		assertEquals(cs.getCustomer().size(), 3);
	}

	// tests createCustomer method
	@Test
	public void testCreateCustomer() {
		boolean expected = true;
		Customer c = new Customer(3, 25, "username", "password", "firstname", "lastname");
		when(cd.createCustomer(c)).thenReturn(1);
		boolean actual = cs.createCustomer(c);
		assertEquals(expected, actual);

	}

	// tests getCustomerId method
	@Test
	public void testGetCustomerId() {
		when(cd.getCustomerId(1)).thenReturn(new Customer(1, 250000, "MrHung", "pword", "Ryan", "Carstons"));
		Customer expected = new Customer(1, 250000, "MrHung", "pword", "Ryan", "Carstons");
		Customer actual = cs.getCustomerId(1);
		assertEquals(expected, actual);
	}

	// tests updateCustomer method
	@Test
	public void testUpdateCustomer() {
		boolean expected = true;
		Customer c = new Customer(3, 50, "nameuser", "wordpass", "namefirst", "namelast");
		when(cd.updateCustomer(c)).thenReturn(1);
		boolean actual = cs.updateCustomer(c);
		assertEquals(expected, actual);
	}

	// tests deleteCustomerId
	@Test
	public void testDeleteCustomer() {
		boolean expected = true;
		Customer c = new Customer(1, 25, "username", "pword", "ryan", "carstons");
		when(cd.deleteCustomer(c)).thenReturn(1);
		boolean actual = cs.deleteCustomer(c);
		assertEquals(expected, actual);
	}

}
