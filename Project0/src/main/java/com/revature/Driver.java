package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.revature.model.Users;
import com.revature.model.Balance;
import com.revature.service.UsersService;
import com.revature.service.BalanceService;
import com.revature.util.ConnectionUtil;
import com.revature.builder.AccountBuilding;

public class Driver {
	

	public static void main(String[] args){

		try {
			String driverName = ConnectionUtil.getConnection().getMetaData().getDriverName();
			System.out.println(driverName);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		AccountBuilding.bankStart();

	}

}
