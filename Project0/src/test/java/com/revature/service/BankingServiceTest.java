package com.revature.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.dao.UserDao;
import com.revature.model.User;

@RunWith(MockitoJUnitRunner.class)
public class BankingServiceTest
{
	@InjectMocks
    private BankingServiceForTest bs;
	
	@Mock
	private UserDao ud;
	
	@Test
	public void testLogin() {
		when(bs.login("user1", "12345678")).thenReturn(true);
		boolean expected = true;
		boolean actual = bs.login("user1", "12345678");
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetUser() {
		when(bs.getUserAcc("123456789")).thenReturn(new User(1, "abc", "efg", "qwert", "12345678", "adw@fee", "(123) 456-7890", "1234656789", 0));
		User expected = new User(1, "abc", "efg", "qwert", "12345678", "adw@fee", "(123) 456-7890", "1234656789", 0);
		User actual = bs.getUserAcc("123456789");
		assertEquals(expected, actual);
	}
	
	@Test
	public void testRegister() {
		
	}
	
	
	
	
}
