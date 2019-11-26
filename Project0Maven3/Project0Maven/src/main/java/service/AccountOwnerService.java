package service;

import java.util.List;

import dao.AOD;
import doaImplementation.AODIMPL;
import model.AccountOwner;

public class AccountOwnerService {
	
	private AOD aod = new AODIMPL();
	
	public AccountOwner getAccountOwner(String fullName){
		return aod.getAccountOwner(fullName);
	}
	
	public List<AccountOwner> findAccountOwner(){
		return aod.findAccountOwner();
	}
	
	public int createAccountOwner(AccountOwner owner) {
		return aod.createAccountOwner(owner);
	}
	

}
