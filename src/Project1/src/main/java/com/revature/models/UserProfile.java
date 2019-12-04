package com.revature.models;

public class UserProfile {

	private int user_id;
	private String address;
	private int phoneNumber;
	
	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserProfile(int user_id, String address, int phoneNumber) {
		super();
		this.user_id = user_id;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + phoneNumber;
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
		UserProfile other = (UserProfile) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (phoneNumber != other.phoneNumber)
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "UserProfile [user_id=" + user_id + ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
}
