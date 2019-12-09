package com.revature.daos;

import java.util.List;

import com.revature.models.Expenses;
import com.revature.models.UserLogin;

public interface ExpenseDao {
	public int createExpense(Expenses e);
	public int updateExpense(Expenses e );
	public List<Expenses> getExpenses();
	public List<Expenses> getExpenseById(int id);
	public List<Expenses> pendingExpenses();
	public List<Expenses> resolvedExpenses();
	public int submitExp(double amount, int userid, String type);
	public int updateExpense(int expenseid, int managerid, String approvalstatus);
	public List<Expenses> getPendingById(int id);
	public List<Expenses> getIndividualsExpenseById(int id);
}
