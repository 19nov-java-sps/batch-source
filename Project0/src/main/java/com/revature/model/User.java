package com.revature.model;

import java.io.Serializable;

// Makes the object 'User' Serializable ; which means to convert its state into a byte stream
// so that the byte stream can be converted back into a copy of the object. To persist the data.

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private int userId;
	
	public User() {
		super();
	}
	
	
	public User(String username, String password, int userId) {
		super();
		this.username = username;
		this.password = password;
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getUser_id() {
		return userId;
	}
	
	public void setUser_id(int userId) {
		this.userId= userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + userId;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId != other.userId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", userId=" + userId + "]";
	}

	
	
	
	

}
