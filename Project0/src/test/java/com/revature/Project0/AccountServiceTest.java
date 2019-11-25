package com.revature.Project0;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.dao.AccountDao;
import com.revature.model.Account;
import com.revature.service.AccountService;


//@RunWith(MockitoJUnitRunner.class)

public class AccountServiceTest {
	
//@InjectMocks
//private AccountService as;

//@Mock
//private AccountDao ad;

@Test
public void testCheckBalance () {
		AccountService as = new AccountService();
		when(as.checkBalance(1)).thenReturn(50.23);
	}
}
