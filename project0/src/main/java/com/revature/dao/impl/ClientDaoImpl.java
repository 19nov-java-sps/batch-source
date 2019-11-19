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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
			// TODO: handle exception
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
			// TODO: handle exception
		}
		return deletedClient;

	}


}
