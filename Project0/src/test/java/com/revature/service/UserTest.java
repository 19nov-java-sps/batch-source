package com.revature.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.revature.dao.UsersDao;
import com.revature.model.Users;

public class UserTest {
	
	@InjectMocks
	private UsersService us;
	
	@Mock
	private UsersDao ud;



	@Test
	public void testcreateUsers() {
		Users u = new Users();
		int Tu = 0;
	
		when(ud.createUsers(u)).thenReturn(0);
		int Au = us.createUsers(u);
		assertEquals(Tu, Au);
	
}



}
