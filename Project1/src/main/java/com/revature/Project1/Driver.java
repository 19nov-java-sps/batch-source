package com.revature.Project1;

import java.sql.SQLException;
import java.util.List;

import com.revature.models.Expenses;
import com.revature.models.UserLogin;
import com.revature.service.ExpenseService;
import com.revature.service.UserLogInService;
import com.revature.util.ConnectionUtil;

public class Driver {
	
	public static void main(String[] args){
		
		try {
			String driverName = ConnectionUtil.getConnection().getMetaData().getDriverName();
			System.out.println(driverName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
//	UserLogInService es = new UserLogInService();
//	List<UserLogin> empList = es.getUsers();
//	for(UserLogin e: empList) {
//		System.out.println(e);
//	}
//	
//	
//	final UserLogInService userDao = new UserLogInService();
//	String email = "123@aol.com";
//	String password = "password";
//	System.out.println(email+ " " +password);
//	UserLogin ul = userDao.getUserByEmailAndPassword(email, password);
//	System.out.println(ul);
	
//	ExpenseService ex= new ExpenseService();
//	List<Expenses> empList2 = ex.pendingExpenses();
//	System.out.println(empList2);
	
//	ExpenseService ex2= new ExpenseService();
//	Expenses empList3 = ex2.getExpenseById(2);
//	System.out.println(empList3);
	
//	ExpenseService ex2= new ExpenseService();
//	List<Expenses> empList3 = ex2.resolvedExpenses();
//	System.out.println(empList3);
		

		
		
//		ExpenseService ex2= new ExpenseService();
//		Expenses esl= ex2.getExpenseById(2);
//		System.out.println(esl);
//		esl.setApprovalStatus("Approved");
//		ex2.updateExistingExpense(esl);

				
		//AccountInfo newAccnt = new AccountInfo();
		//newAccnt.setAccount_balance(450000);
		//newAccnt.setUser_id(2);
		//boolean success = a.createAccount(newAccnt);
		//System.out.println("success? "+success);
		
		
//		ExpenseService ex2= new ExpenseService();
//		Expenses esl=new Expenses();
//		esl.setExpenseAmount(20);
//		esl.setExpenseId(4);
//		esl.setUserId(2);
//		esl.setExpenseType("Party");
//		ex2.createNewExpense(esl);
		
//		String idStr="6";
//		
//		UserLogInService ex2= new UserLogInService();
//		UserLogin esl=  ex2.getUserById(Integer.parseInt(idStr));
////		System.out.println(esl);
//	
//		System.out.println("not working");
//		System.out.println(ex2.getUserById(6));
//		esl.getUser_id();
//		esl.getEmail();
//		
//		System.out.println("no");
//		esl.setEmail("changed@yahoo.com");
//		esl.setPassWord("Changed");
//		esl.setName("Not Eric");
//		ex2.updateUser(esl);
		
		
//		ExpenseService ex2= new ExpenseService();
//		List<Expenses> empList3 = ex2.getAllExpenses();
//		System.out.println(empList3);
		
	
	
}
}

