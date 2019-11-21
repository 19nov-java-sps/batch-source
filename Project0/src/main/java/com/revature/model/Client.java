package com.revature.model;

import java.io.Serializable;

// Makes the object 'Client' Serializable ; which means to convert its state into a byte stream
// so that the byte stream can be converted back into a copy of the object; to persist the data.

public class Client implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private double clientBalance;
	
	public Client() {
		super();
	}
	
	
	public Client(String username, String password, String firstName, String lastName, double clientBalance) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.clientBalance = clientBalance;
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


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public double getClientBalance() {
		return clientBalance;
	}


	public void setClientBalance(double clientBalance) {
		this.clientBalance = clientBalance;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(clientBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		Client other = (Client) obj;
		if (Double.doubleToLongBits(clientBalance) != Double.doubleToLongBits(other.clientBalance))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
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
		return "Client [username=" + username + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + ", clientBalance=" + clientBalance + "]";
	}


}
