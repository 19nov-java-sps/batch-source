package com.servicelayer;

import java.util.List;

import com.dao.CustomerDao;
import com.daoimpl.CustomerDaoImpl;
import com.model.Customer;

public class CustomerService {

	private CustomerDao customerDao = new CustomerDaoImpl();

	public List<Customer> getCustomer() {
		return customerDao.getCustomer();
	}

	public Customer getCustomerId(int id) {
		return customerDao.getCustomerId(id);
	}

	public Customer getUserPass(String username) {
		return customerDao.getUserPass(username);

	}

	public boolean createCustomer(Customer c) {
		int customerCreated = customerDao.createCustomer(c);
		if (customerCreated != 0) {
			return true;
		}
		return false;
	}

	public boolean updateCustomer(Customer c) {
		int customerUpdated = customerDao.updateCustomer(c);
		if (customerUpdated != 0) {
			return true;
		}
		return false;
	}

	public boolean deleteCustomer(Customer c) {
		int customerDeleted = customerDao.deleteCustomer(c);
		if (customerDeleted != 0) {
			return true;
		}
		return false;
	}

	public void deposit(Customer c, double increase) {
		customerDao.depositFunds(c, increase);
	}

	public void withdraw(Customer c, double decrease) {

		customerDao.withdrawFunds(c, decrease);
	}

}
