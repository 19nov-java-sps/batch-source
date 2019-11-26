package com.bankdriver;

import java.sql.SQLException;
import java.util.List;

import com.commandview.CommandView;
import com.model.Customer;
import com.servicelayer.CustomerService;
import com.util.ConnectionUtil;

public class BankDriver {

	public static void main(String[] args) {

		// starts program
		CommandView cv = new CommandView();
		cv.startMenu();

		// Query all rows and columns from bankuser tables
//		CustomerService cs = new CustomerService();
//		List<Customer> acct = cs.getCustomer();
//		for (Customer cc : acct) {
//			System.out.println(cc);
//		}

		// Query row containing customer id of 1
//		Customer myacct = cs.getCustomerId(1);
//		System.out.println(myacct);2

		// create new customer account
//		Customer newCustomer = new Customer();
//		newCustomer.setCustomerId(1);
//		newCustomer.setBalance(250.00);
//		newCustomer.setUserName("tinov123");
//		newCustomer.setPassWord("iluvtocode");
//		newCustomer.setFirstName("Ivan");
//		newCustomer.setLastName("Tinov");
//		boolean success = cs.createCustomer(newCustomer);
//		System.out.println("success? " + success);

		// updating a customer account
//		Customer previousCustomer = cs.getCustomerId(1);
//		System.out.println(previousCustomer);
//		System.out.print("============================");
//		previousCustomer.setCustomerId(1);
//		previousCustomer.setBalance(100);
//		previousCustomer.setUserName("tinov123");
//		previousCustomer.setPassWord("ilivecoding");
//		previousCustomer.setFirstName("Ivan");
//		previousCustomer.setLastName("Tinov");
//		boolean success = cs.updateCustomer(previousCustomer);
//		System.out.println("success? " + success);
//		Customer postUpdate = cs.getCustomerId(1);
//		System.out.println(postUpdate);

		// deleting a customer account
//		boolean success = cs.deleteCustomer(new Customer(364));
//		System.out.println("success? " + success);

//		// deposit funds
//		System.out.println(cs.getCustomerId(1));
//		cs.deposit(new Customer(1), 1000);
//		System.out.println(cs.getCustomerId(1));

		// withdraw funds
//		System.out.println(cs.getCustomerId(1));
//		cs.withdraw(new Customer(1), 1000);
//		System.out.println(cs.getCustomerId(1));

	}

}
