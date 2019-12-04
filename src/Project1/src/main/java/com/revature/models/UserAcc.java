package com.revature.models;

import java.io.Serializable;

public class UserAcc implements Serializable{

	private static final long serialVersionUID = 1L;
	private int user_id;
	private String user_name;
	private String pass_word;
	private String user_role;
	
	public UserAcc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAcc(int user_id, String user_name, String pass_word, String user_role) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.pass_word = pass_word;
		this.user_role = user_role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pass_word == null) ? 0 : pass_word.hashCode());
		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
		result = prime * result + user_id;
		result = prime * result + ((user_role == null) ? 0 : user_role.hashCode());
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
		UserAcc other = (UserAcc) obj;
		if (pass_word == null) {
			if (other.pass_word != null)
				return false;
		} else if (!pass_word.equals(other.pass_word))
			return false;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		if (user_id != other.user_id)
			return false;
		if (user_role == null) {
			if (other.user_role != null)
				return false;
		} else if (!user_role.equals(other.user_role))
			return false;
		return true;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getuser_name() {
		return user_name;
	}

	public void setuser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPass_word() {
		return pass_word;
	}

	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	@Override
	public String toString() {
		return "UserAcc [user_id=" + user_id + ", user_name=" + user_name + ", pass_word=" + pass_word + ", user_role="
				+ user_role + "]";
	}
	
	
}
