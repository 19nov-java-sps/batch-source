package com.revature.model;

import java.io.Serializable;

public class Employees implements Serializable {

	private static final long serialVersionUID = 1L;
	private int employeeID;
	private String userName;
	private String passWord;
	private String fullName;
	private boolean isManager;

	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employees(int employeeID, String userName, String passWord, String fullName, boolean isManager) {
		super();
		this.employeeID = employeeID;
		this.userName = userName;
		this.passWord = passWord;
		this.fullName = fullName;
		this.isManager = isManager;
	}

	protected int getEmployeeID() {
		return employeeID;
	}

	protected void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	protected String getUserName() {
		return userName;
	}

	protected void setUserName(String userName) {
		this.userName = userName;
	}

	protected String getPassWord() {
		return passWord;
	}

	protected void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	protected String getFullName() {
		return fullName;
	}

	protected void setFullName(String fullName) {
		this.fullName = fullName;
	}

	protected boolean isManager() {
		return isManager;
	}

	protected void setManager(boolean isManager) {
		this.isManager = isManager;
	}

	protected static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeID;
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + (isManager ? 1231 : 1237);
		result = prime * result + ((passWord == null) ? 0 : passWord.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Employees)) {
			return false;
		}
		Employees other = (Employees) obj;
		if (employeeID != other.employeeID) {
			return false;
		}
		if (fullName == null) {
			if (other.fullName != null) {
				return false;
			}
		} else if (!fullName.equals(other.fullName)) {
			return false;
		}
		if (isManager != other.isManager) {
			return false;
		}
		if (passWord == null) {
			if (other.passWord != null) {
				return false;
			}
		} else if (!passWord.equals(other.passWord)) {
			return false;
		}
		if (userName == null) {
			if (other.userName != null) {
				return false;
			}
		} else if (!userName.equals(other.userName)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Employees [employeeID=" + employeeID + ", userName=" + userName + ", passWord=" + passWord
				+ ", fullName=" + fullName + ", isManager=" + isManager + "]";
	}

}
