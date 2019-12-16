package com.revature.hibernate;

import java.util.List;

//import org.hibernate.Session;

import com.revature.model.User;
import com.revature.model.Invoice;
import com.revature.service.UserService;
import com.revature.service.InvoiceService;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
			
		//Session s = HibernateUtil.getSession();
		
		UserService es = new UserService();
		InvoiceService rs = new InvoiceService();
//		
//		List<User> users = ud.getUserTable();
//		for(User u: users) {
//			System.out.println(u);
//		}
//		
//		System.out.println(ud.getUserById(1));
//		System.out.println(ud.getUserById(2));
//		
		
		//HibernateUtil.closeSessionFactory();	
			
	}
}
 
