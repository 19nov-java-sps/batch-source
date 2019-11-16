package com.revature;

import java.sql.SQLException;

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
		//*/

	}

}
