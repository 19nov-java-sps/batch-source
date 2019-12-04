package com.revature.daos.impls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.daos.UserProfileDao;
import com.revature.models.UserProfile;
import com.revature.util.ConnectionUtil;

public class UserProfileDaoImpl implements UserProfileDao{

	@Override
	public List<UserProfile> getOne(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from user_profile where user_id = ?";
		List<UserProfile> myUserProfile = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){

			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String address = rs.getString("address");
				int phoneNumber = rs.getInt("phonenumber");
				UserProfile up = new UserProfile(id,address,phoneNumber);
				myUserProfile.add(up);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return myUserProfile;
	}

	@Override
	public void updateProfile(String address, int phonenumber, int id) {
		// TODO Auto-generated method stub
		String sql = "update user_profile set address=?, phonenumber=? where user_id=?";
		
		try(Connection c = ConnectionUtil.getConnection();
				PreparedStatement ps = c.prepareStatement(sql)){
			
			ps.setString(1, address);
			ps.setInt(2, phonenumber);
			ps.setInt(3, id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
}
