package com.revature.dao.impl;

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

public class ClientDaoImpl implements  ClientDao{

	@Override
	public List<Client> getClient() {
		String sqlString =  "select * from Client";
		List<Client> c = new ArrayList<>();
		
		try (Connection connection = ConnectionUtil.getConnection();
				Statement statement = connection.createStatement();
				ResultSet  rSet = statement.executeQuery(sqlString)) {
			
			while(rSet.next()) {
				int userId = rSet.getInt("user_id");
				String username = rSet.getString("username");
				String password = rSet.getString("passwordString");
				Client client = new Client(username, password, userId);
				c.add(client);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}

	@Override
	public int createClient(Client c) {
		String sqString = "insert into Client (username, passwordString, user_id) values (?,?,?)";
		int success = 0;
		
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pStatement = connection.prepareStatement(sqString)){
						pStatement.setString(1, c.getUsername());
						pStatement.setString(2, c.getPassword());
						pStatement.setInt(3, c.getUserId());
						success = pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		
		return success;					
		
	}

	@Override
	public int updateClient(Client c) {
		String sqString = "update * from Client set username = ?, passwordString = ?, where Client.user_id = ?";
		int updatedClient = 0;
		
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pStatement =  connection.prepareStatement(sqString)){
			pStatement.setString(1, c.getUsername());
			pStatement.setString(2, c.getPassword());
			pStatement.setInt(3, c.getUserId());
			updatedClient =  pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updatedClient;
	}
	
	@Override
	public int deleteClient(Client c) {
		String sqString = "delete from Client where Client.user_id = ?";
		int deletedClient = 0;
		
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pStatement =  connection.prepareStatement(sqString)){
			pStatement.setInt(1, c.getUserId());
			deletedClient =  pStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deletedClient;

	}

	@Override
	public int createBankAcctWhenClientEnrolls(Client c) {
		String sqString = "insert into BankAcct (firstname, lastname, balance, user_id) values (?,?,?,?)";
		int createdBankAcct = 0;
		
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement pStatement = connection.prepareStatement(sqString)){
			try {
				pStatement.setString(1, c.getBankAcct().getFirstName());
				pStatement.setString(2, c.getBankAcct().getLastName());
				pStatement.setInt(3, 0);
				pStatement.setInt(4, c.getUserId());
				createdBankAcct = pStatement.executeUpdate();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return createdBankAcct;
		
				
			
	}

	@Override
	public Client getClientByUserId(int id) {
		String sqlString =  "select * from Client where Client.user_id = ?";
		Client c = null;
		
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(sqlString)){
			statement.setInt(1, id);
			ResultSet rSet = statement.executeQuery();
			
			while(rSet.next()) {
				int userId = rSet.getInt("user_id");
				String username = rSet.getString("username");
				String password = rSet.getString("passwordString");
				c = new Client(username, password, userId);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}


}
