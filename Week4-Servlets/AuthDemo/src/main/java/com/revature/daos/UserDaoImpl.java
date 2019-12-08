package com.revature.daos;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;

public class UserDaoImpl implements UserDao {
	
	private List<User> users = new ArrayList<>();
	
	public UserDaoImpl() {
		users.add(new User(1, "sallyjenkins", "pass123", "general"));
		users.add(new User(2, "tomsmith", "supersecret", "admin"));
		users.add(new User(3, "timpeppers", "p3pp3r5", "general"));
		users.add(new User(4, "nichmitchell", "keysmash", "general"));
	}

	@Override
	public List<User> getAll() {
		return new ArrayList<>(users);
	}

	@Override
	public User getUserById(int id) {
		for(User u: users) {
			if(u.getId() == id) {
				return u;
			}
		}
		return null;
	}

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		for(User u: users) {
			if(u.getUsername() != null && u.getUsername().equals(username)) {
				if(u.getPassword() != null && u.getPassword().equals(password)) {
					return u;
				}
			}
		}
		return null;
	}

}
