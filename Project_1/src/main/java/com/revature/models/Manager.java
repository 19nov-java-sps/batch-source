package com.revature.models;

import java.io.Serializable;

public class Manager implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String fName;
	private String lName;
	private String username;
	private String password;
	private int man_id;
	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(String fName, String lName, String username, String password, int man_id) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.username = username;
		this.password = password;
		this.man_id = man_id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
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

	public int getMan_id() {
		return man_id;
	}

	public void setMan_id(int man_id) {
		this.man_id = man_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());
		result = prime * result + man_id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Manager other = (Manager) obj;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		if (man_id != other.man_id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
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
		return "Manager [fName=" + fName + ", lName=" + lName + ", username=" + username + ", password=" + password
				+ ", man_id=" + man_id + "]";
	}
	
}
