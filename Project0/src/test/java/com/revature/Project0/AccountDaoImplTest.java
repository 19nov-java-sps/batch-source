package com.revature.Project0;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.dao.AccountDao;
import com.revature.dao.impl.AccountDaoImpl;
import com.revature.model.Account;
import com.revature.service.AccountService;




@RunWith(MockitoJUnitRunner.class)
public class AccountDaoImplTest {
	
@InjectMocks
private AccountDaoImplTest adi;

@Mock
private AccountDao ad;

	@Test
	public void testGetAccountById() {
		when(ad.getAccountById(1)).thenReturn(new Account(1, "primary", 50.25,1));
		//Account expected = new Account(1, "primary", 50.25,1);
		//Account actual = ad.getAccountById(1);
		//assertEquals(expected, actual);
		}
	
	@Test
	public void testGetUserAccountId() {
		int expected = 4;
		//AccountDaoImpl adi = new AccountDaoImpl();
		int actual = ad.getUserAccountId(2);
		assertEquals(expected,actual);
	}
}
