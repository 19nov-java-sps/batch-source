package com.revature.models;

import java.io.Serializable;

public class UserLogin implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserLogin(int user_id, String email, String passWord, String name, String employeetype, int reportsto) {
		super();
		this.user_id = user_id;
		this.email = email;
		this.passWord = passWord;
		this.name = name;
		this.employeetype = employeetype;
		this.reportsto = reportsto;
	}
	@Override
	public String toString() {
		return "UserLogin [user_id=" + user_id + ", email=" + email + ", passWord=" + passWord + ", name=" + name
				+ ", employeetype=" + employeetype + ", reportsto=" + reportsto + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((employeetype == null) ? 0 : employeetype.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((passWord == null) ? 0 : passWord.hashCode());
		result = prime * result + reportsto;
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
		UserLogin other = (UserLogin) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (employeetype == null) {
			if (other.employeetype != null)
				return false;
		} else if (!employeetype.equals(other.employeetype))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (passWord == null) {
			if (other.passWord != null)
				return false;
		} else if (!passWord.equals(other.passWord))
			return false;
		if (reportsto != other.reportsto)
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmployeetype() {
		return employeetype;
	}
	public void setEmployeetype(String employeetype) {
		this.employeetype = employeetype;
	}
	public int getReportsto() {
		return reportsto;
	}
	public void setReportsto(int reportsto) {
		this.reportsto = reportsto;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private int user_id;
	private String email;
	private String passWord;
	private String name;
	private String employeetype;
	private int reportsto;
}
