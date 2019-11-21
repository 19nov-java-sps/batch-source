package com.revature.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.ClientDao;
import com.revature.model.Client;
import com.revature.util.ConnectionUtil;

public class ClientDaoImpl implements ClientDao {
	
	
	public List<Client> getClientTable(){
		String sql = "select * from clients"; // assigns SQL statement to a string
		List<Client> clientTable = new ArrayList<>(); // creates a new ArrayList type object to store result of the database query
		
		try (Connection c = ConnectionUtil.getConnection(); // establishes a connection to the database
				Statement s = c.createStatement(); // creates a statement which is used to send an SQL statement to be executed in our database
				ResultSet rs = s.executeQuery(sql)) { // stores the result when we execute the SQL query
			
			// while loop iterates thru the database 
			// gets all the column data & assigns values 
			// to object instance variables
			while(rs.next()) { 
				String username = rs.getString("user_name");
				String password = rs.getString("pass_word");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				double clientBalance = rs.getDouble("client_balance");
				
				Client client = new Client(username, password, firstName, lastName, clientBalance); // creates an object representation of the clients table rows
				clientTable.add(client);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clientTable; // returns an object with all the data from the SQL database query
							// which in this case would be all the client info in the clients table
	}
	
	
	@Override
	public Client getClient(String username) {
		String sql = "select * from clients where user_name = ?";
		Client client = new Client();
		
		try (Connection c = ConnectionUtil.getConnection(); 
				
				// Prepared Statement pre-compiles our SQL statement so we are able 
				// to parameterize our SQL statement without vulnerability to SQL Injection
				PreparedStatement ps = c.prepareStatement(sql)) { 
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			// if the query returns a result, set each result value 
			// and return the new object	
			if(rs.next()) {
				client.setUsername(rs.getString("user_name"));
				client.setPassword(rs.getString("pass_word"));
				client.setFirstName(rs.getString("first_name"));
				client.setLastName(rs.getString("last_name"));
				client.setClientBalance(rs.getDouble("client_balance"));
							
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return client;
	}
	

	@Override
	public int createClient(Client client) {
		String sql = "insert into clients (user_name, pass_word, first_name, last_name, client_balance ) values (?, ?, ?, ?, ?)";
		int clientsCreated = 0; // variable to store the number of updated rows
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setString(1, client.getUsername());
			ps.setString(2, client.getPassword());
			ps.setString(3, client.getFirstName());
			ps.setString(4, client.getLastName());
			ps.setDouble(5, client.getClientBalance());
			
			
			clientsCreated = ps.executeUpdate(); // stores 1 because we created a new row in the table
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clientsCreated; // returns 1 to let client know account was created successfully
	}


	
	@Override
	public boolean updateClient(String username, double newBalance) {
		String sql = "{call updateBalance(?,?)}";
		boolean clientUpdated = false;
		
		// Here we use a callable statement to call an SQL function
		// that performs an update on the client table
		try(Connection c = ConnectionUtil.getConnection();
			CallableStatement cs = c.prepareCall(sql)){
			cs.setString(1, username);
			cs.setDouble(2, newBalance);
			clientUpdated = cs.execute();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return clientUpdated;
		
	}
	
	@Override
	public int deleteClient(String username) {
		String sql = "delete from clients where user_name = ?";
		int clientsDeleted = 0;
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			ps.setString(1, username);
			
			clientsDeleted = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clientsDeleted;
	}

		
}
	
	

