package com.revature;

import java.sql.SQLException;
import java.util.List;

import com.revature.model.BankAcct;
import com.revature.service.BankAcctService;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		try {
			String driverName = ConnectionUtil.getConnection().getMetaData().getDriverName();
			System.out.println(driverName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("=======================================================");
		BankAcctService bas = new BankAcctService();
		List<BankAcct> acct = bas.getBankAcct();
		for (BankAcct a:  acct) {
			System.out.println(a);
		}

	}

}
