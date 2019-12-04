package com.revature.util;

import java.sql.SQLException;

public class driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(ConnectionUtil.getConnection().getMetaData().getDriverName());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
