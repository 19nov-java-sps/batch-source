package com.rev.model;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7027648245987907295L;
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", userName=" + userName + ", passWord=" + passWord + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((passWord == null) ? 0 : passWord.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + user_id;
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
		if (passWord == null) {
			if (other.passWord != null)
				return false;
		} else if (!passWord.equals(other.passWord))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}
	private int user_id;
	private String userName;
	private String passWord;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public User(int user_id, String userName, String passWord) {
		super();
		this.user_id = user_id;
		this.userName = userName;
		this.passWord = passWord;
	}
	
	
	
	
	
}
