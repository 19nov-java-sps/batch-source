package com.revature.dao;

import java.util.List;

import com.revature.model.BankAcct;

public interface BankAcctDao {
		
		public List<BankAcct> getBankAcct();
		public List<BankAcct> getBankAcctByUserId(int id);
		public int createBankAcct(BankAcct b);
		public int updateBankAcct(BankAcct b);
		public int deletBankAcct(BankAcct b);
}
