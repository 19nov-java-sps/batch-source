package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Driver {
	
	/*
	 * Creating a new Maven Project:
	 * 1. Go to the File tab (or Right Click in the Package Explorer) and 
	 * 		select "New" -> "Maven Project"
	 * 2. Within the setup wizard, check the "Create a Simple Project (no 
	 * 		archetype selection)" and click "Next"
	 * 3. Provide an identifier for the "GroupId" and "ArtifactId" 
	 * 		such as "com.revature" and "JDBCDemo" and click "Finish"
	 * 
	 * --- configure your project object model ---
	 * 4. Update your Maven Project - Right click on the project folder in 
	 * 		the "Package Explorer" -> "Maven" -> "Update Project"
	 * 
	 * Setting up environment variables:
	 * --- (Option 1) In your system's environment variables ---
	 * 
	 * --- (Option 2) In STS ---
	 * 1. Right click on the project folder in the "Package Explorer"
	 * 		go to "Run As" and "Run Configurations"
	 * 2. Click on the "Environment" tab and configure your name value pairs
	 * 
	 * 
	 * Using System.getenv("key") returns the value of the environment 
	 * 	variable, whether set in the system or in STS
	 * 		
	 * 
	 */
	
	public static void main(String[] args) throws SQLException {
		// for more information on formatting this url or connecting to the db:
			// https://jdbc.postgresql.org/documentation/80/connect.html
		String url = "jdbc:postgresql://"+System.getenv("jdbc_db_host")+":5432/postgres";
		String username = System.getenv("jdbc_db_user");
		String password = System.getenv("jdbc_db_pass");
		
		Connection c = DriverManager.getConnection(url, username, password);
		String driver = c.getMetaData().getDriverName();
		System.out.println(driver);
		
	}

}
