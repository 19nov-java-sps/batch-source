package com.dao;

import java.util.List;

import com.model.Customer;

public interface CustomerDao {

	public List<Customer> getCustomer();

	public Customer getCustomerId(int id);

	public Customer getUserPass(String username);

	public int createCustomer(Customer c);

	public int updateCustomer(Customer c);

	public int deleteCustomer(Customer c);

	public void depositFunds(Customer c, double increase);

	public void withdrawFunds(Customer c, double decrease);

	public int generateCustomerId();


}
