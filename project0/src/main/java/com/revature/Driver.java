package com.revature;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.model.BankAcct;
import com.revature.model.Client;
import com.revature.service.BankAcctService;
import com.revature.service.ClientService;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		Client fakeClient = new Client("cashmoney", "12345", 10);
		BankAcct fakeBankAcct = new BankAcct("John", "Junior", 1000.00, 10);
		fakeClient.setBankAcct(fakeBankAcct);
		
		System.out.print(fakeClient.getBankAcct());
		
		BankAcctService basAcctService = new BankAcctService();
		ClientService  cService =  new ClientService();
		
		cService.createClient(fakeClient);
		
		basAcctService.createBankAcct(fakeBankAcct);
		
		
		
		
	
	}
	
	
}
