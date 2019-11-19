package com.revature;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.BankAcct;
import com.revature.model.User;
import com.revature.service.BankAcctService;
import com.revature.service.UserService;
import com.revature.util.ConnectionUtil; //import connection utility class


public class Driver {

	public static void main(String[] args) {
		// testing connection:
		try {
			String driverName = ConnectionUtil.getConnection().getMetaData().getDriverName();
			System.out.println(driverName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//			BankAcctService bas = new BankAcctService();
//			List<BankAcct> b = bas.getBankAcct();
//			for ( BankAcct ac : b) {
//				System.out.println(ac);
//				
//			}
//			BankAcct locatedBankAcct = bas.getBankAcctByUserId(1);
//			System.out.print(locatedBankAcct);
//		

//			UserService us = new UserService();
			
		
			
			
	}

}
