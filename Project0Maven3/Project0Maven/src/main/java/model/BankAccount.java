package model;


public class BankAccount  
{
	
	 private int idAccount;
	 private String userName;
	 private int accountNumber;
	 private int accountBalance;
	 

	
public BankAccount() 
{
	super();
}



public BankAccount(int idAccount, String userName, int accountNumber, int accountBalance) {
	super();
	this.idAccount = idAccount;
	this.userName = userName;
	this.accountNumber = accountNumber;
	this.accountBalance = accountBalance;
}

public int getIdAccount() {
	return idAccount;
}

public void setIdAccount(int idAccount) {
	this.idAccount = idAccount;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public int getAccountNumber() {
	return accountNumber;
}

public void setAccountNumber(int accountNumber) {
	this.accountNumber = accountNumber;
}

public int getAccountBalance() {
	return accountBalance;
}

public int setAccountBalance(int accountBalance) {
	return this.accountBalance = accountBalance;
}
@Override
public String toString() {
	return   idAccount + " " + userName + " " + accountNumber + " " +accountBalance;

//	return "AccountOwner [ fullName= " + fullName + ", userName= " + userName + ",userEmail = " + userEmail + ", phoneNumber= " + phoneNumber+ "] ";
}


}
