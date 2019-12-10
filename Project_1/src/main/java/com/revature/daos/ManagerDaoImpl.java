package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Manager;
import com.revature.util.ConnectionUtil;

public class ManagerDaoImpl implements ManagerDao {

	@Override
	public List<Manager> getManagers() {
		
		String sql = "select * from man_table";
		List<Manager> managers = new ArrayList<>();
		
		try(Connection c = ConnectionUtil.getConnection();
						Statement s = c.createStatement();
						ResultSet rs = s.executeQuery(sql)) {

			while(rs.next()) {
				
				Manager m = new Manager();
				m.setfName(rs.getString("first_name"));
				m.setlName(rs.getString("last_name"));
				m.setUsername(rs.getString("user_name"));
				m.setPassword(rs.getString("pass_word"));
				m.setMan_id(rs.getInt("man_id"));
				
				managers.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return managers;
	}

	@Override
	public Manager getManagerByUsername(String username) {
		
		String sql = "select * from man_table where user_name = ?";
		Manager m = new Manager();
		
		try(Connection c = ConnectionUtil.getConnection();
					PreparedStatement ps = c.prepareStatement(sql)) {
			
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				m.setfName(rs.getString("first_name"));
				m.setlName(rs.getString("last_name"));
				m.setUsername(rs.getString("user_name"));
				m.setPassword(rs.getString("pass_word"));
				m.setMan_id(rs.getInt("man_id"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return m;
	}
}
