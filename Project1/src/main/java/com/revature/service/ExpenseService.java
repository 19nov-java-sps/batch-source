package com.revature.service;

import java.util.List;

import com.revature.daos.ExpenseDao;
import com.revature.daos.ExpenseDaoImpl;
import com.revature.models.Expenses;



public class ExpenseService {
	private ExpenseDao expenseDao = new ExpenseDaoImpl();
	
	
	
	
	public int createNewExpense(Expenses e){
		return expenseDao.createExpense(e);
	}
	public int updateExistingExpense(Expenses e){
		return expenseDao.updateExpense(e);
	}
	public List<Expenses> getAllExpenses(){
		return expenseDao.getExpenses();
	}
	public List<Expenses> getExpenseById(int id) {
		return expenseDao.getExpenseById(id);
	}
	public List<Expenses> pendingExpenses(){
		return expenseDao.pendingExpenses();
	}
	public List<Expenses> resolvedExpenses(){
		return expenseDao.resolvedExpenses();
	}
	
	public int submitExp(double amount, int userid, String type) {
		return expenseDao.submitExp(amount, userid, type);
	}
	public int updateExpense(int expenseid, int managerid, String approvalstatus) {
		return expenseDao.updateExpense(expenseid,managerid,approvalstatus);
		
	}
	public List<Expenses> getPendingById(int id) {
		return expenseDao.getPendingById(id);
		
	}
	public List<Expenses> getIndividualsExpenseById(int id) {
		return expenseDao.getIndividualsExpenseById(id);

	}

	
	

}
