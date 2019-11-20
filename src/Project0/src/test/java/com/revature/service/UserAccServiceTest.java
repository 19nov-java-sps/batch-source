package com.revature.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.dao.UserAccDao;
import com.revature.model.UserAcc;

@RunWith(MockitoJUnitRunner.class)
public class UserAccServiceTest {

	@InjectMocks
	private UserAccService uas;
	
	@Mock
	private UserAccDao uad;
	
	@Test
	public void testCreatingUser() {
		boolean expected = true;
		UserAcc ua = new UserAcc();
		
		ua.setUserName("JonSnow");
		ua.setPassword("Password123");
		
		when(uad.createUserAccount(ua)).thenReturn(1);
		
		boolean actual = uas.createUserAcc(ua);
		assertEquals(expected,actual);
	}
	
	@Test
	public void testGettingID() {	
		when(uad.getUserId("jon")).thenReturn(7);
		assertEquals(7, uad.getUserId("jon"));
	}
	
}
