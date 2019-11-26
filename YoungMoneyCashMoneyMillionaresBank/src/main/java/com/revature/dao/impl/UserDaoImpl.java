package com.revature.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.UserDao;
import com.revature.model.User;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public List<User> getUser() {
		List<User> user = new ArrayList<>();

		String sql = "select * from users";

		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)) {

			while (rs.next()) {
				int userId = rs.getInt("user_id");
				String userName = rs.getString("username");
				String password = rs.getString("pass_word");
				User u = new User(userName, userId, password);
				user.add(u);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User getUserById(int id) {
		String sql = "select * from users where user_id = ?";
		User u = null;

		try (Connection c = ConnectionUtil.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery(sql)) {

			while (rs.next()) {
				int userId = rs.getInt("user_id");
				String userName = rs.getString("username");
				String password = rs.getString("pass_word");
				u = new User(userName, userId, password);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;

	}

	@Override
	public int createUser(User u) {
		String sql = "insert into users (user_id, username, pass_word) values (?, ?, ?)";

		int userCreated = 0;

		try (Connection c = ConnectionUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

			ps.setInt(1, u.getUserId());
			ps.setString(2, u.getUserName());
			ps.setString(3, u.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userCreated;
	}

	@Override
	public int updateUser(User u) {
		String sql = "update users set user_id = ?, username = ?, pass_word = ?";
		int userUpdated = 0;

		try (Connection c = ConnectionUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, u.getUserId());
			ps.setString(2, u.getUserName());
			ps.setString(3, u.getPassword());

			userUpdated = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userUpdated;
	}

	@Override
	public int deleteUser(User u) {
		int userDeleted = 0;
		String sql = "delete from users where user_id = ?";

		try (Connection c = ConnectionUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setInt(1, u.getUserId());
			userDeleted = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userDeleted;
	}

}
