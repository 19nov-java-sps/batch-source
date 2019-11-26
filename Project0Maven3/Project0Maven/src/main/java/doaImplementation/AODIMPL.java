package doaImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.AOD;
import model.AccountOwner;
import util.ConnectionUtil;

public class AODIMPL implements AOD{

	@Override
	public AccountOwner getAccountOwner(String string) {
		String sql = "select * from AccountOwner where fullName = ?";
		AccountOwner ao = null;
		
		try (Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)) {
					ps.setString(1, string);
					ResultSet rs = ps.executeQuery();
					
					while (rs.next()) {
						String fullName = rs.getString("fullName");
						String userName = rs.getString("userName");
						String userEmail = rs.getString("userEmail");
						int phoneNumber = rs.getInt("phonenumber");
						
						ao = new AccountOwner(fullName, userName, userEmail, phoneNumber);
						
				}
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return ao;
	}

	@Override
	public List<AccountOwner> findAccountOwner() {
		String sql = "Select * from AccountOwner";
		List<AccountOwner> listAccountOwners = new ArrayList<>();
		
		try (Connection connection = ConnectionUtil.getConnection();
				Statement s = connection.createStatement();
				ResultSet rs = s.executeQuery(sql))
				{
					while (rs.next()) 
					{
						String fullName = rs.getString("fullName");
						String userName = rs.getString("userName");
						String userEmail = rs.getString("userEmail");
						int phoneNumber = rs.getInt("phonenumber");
						
						AccountOwner owner1 = new AccountOwner(fullName, userName, userEmail, phoneNumber);
						listAccountOwners.add(owner1);
					}
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return listAccountOwners;
				
	}

	@Override
	public int createAccountOwner(AccountOwner owner) {
		String sql = "insert into AccountOwner (fullName, userName, userEmail, phoneNumber) values(?,?,?,?)";
		int accountOwnerCreated = 0;
		
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement ps = connection.prepareStatement(sql))
				{
						ps.setString(1, owner.getFullName());
						ps.setString(2, owner.getUserName());
						ps.setString(3, owner.getUserEmail());
						ps.setInt(4, owner.getPhoneNumber());
						
						accountOwnerCreated = ps.executeUpdate();
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return accountOwnerCreated;
	}


}
