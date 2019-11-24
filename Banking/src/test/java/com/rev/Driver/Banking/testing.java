package com.rev.Driver.Banking;

import static org.junit.Assert.assertEquals;

import com.rev.model.User;
import com.rev.service.UserLogInService;

import junit.framework.TestCase;

public class testing extends TestCase {
	public void testUserLogIn() {
		UserLogInService ui= new UserLogInService();
		User u=new User();
		u.setUserName("Bill");
		u.setPassWord("password");
		boolean success=ui.createUser(u);
		assertEquals(true, success);
	}
}
