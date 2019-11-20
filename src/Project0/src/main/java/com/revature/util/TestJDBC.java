package com.revature.util;

import java.sql.SQLException;

public class TestJDBC {

	public static void main(String[] args) {
		try {
			System.out.println(ConnectionUtil.getConnection().getMetaData().getDriverName());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
