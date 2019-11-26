package service;

import java.util.List;

import dao.AOD;
import dao.BAD;
import doaImplementation.AODIMPL;
import doaImplementation.BADIMPL;
import model.AccountOwner;
import model.BankAccount;

public class BankAccountService {
private static BAD bad = new BADIMPL();

public List<BankAccount> listBankAccount(){
	return bad.listBankAccount();
}
public static  int deposit(BankAccount accountX, int depositAmount) {
	return bad.deposit(accountX, depositAmount);
}
public static int withdraw(BankAccount accountX, int withdrawAmount) {
	return bad.withdraw(accountX, withdrawAmount);
}
public static int createBankAccount(BankAccount account) {
	return BAD.createBankAccount(account);
}
public static BankAccount checkBalance(String userName) {
	return checkBalance(userName);
}
	

}
