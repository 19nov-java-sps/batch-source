package model;


public class AccountOwner
{
	// variables
	private String fullName;
	private String userName;
	private String userEmail;
	private int phoneNumber;
	
	
	public AccountOwner() {
	super();
	}
	// constructor

	public AccountOwner(String fullName, String userName, String userEmail, int phoneNumber) {
		super();
		this.fullName = fullName;
		this.userName = userName;
		this.userEmail = userEmail;
		this.phoneNumber = phoneNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return   fullName + " " + userName + " " + userEmail + " " +phoneNumber;

//		return "AccountOwner [ fullName= " + fullName + ", userName= " + userName + ",userEmail = " + userEmail + ", phoneNumber= " + phoneNumber+ "] ";
	}
	

	
}
