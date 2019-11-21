
package test;

import java.util.*;
import model.Account; 
import dao.AccountDAO; 

import org.junit.Test;
import static org.junit.Assert.*;

import static org.mockito.MOCKITO.*; 
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;



import model.User; 
import dao.UserDAO; 

public class BankTest {
	
	@InjectMocks
	private User user;
	
	@Mock
	private UserDAO userDao;
	
	@Test
	public void getAllAccounts() {
		
			List<Account> accounts = new ArrayList<>();
			accounts.add(new Account());
			accounts.add(new Account());
			accounts.add(new Account());
		
			when(user.getAllAccounts()).thenReturn(accounts);
			assertEquals(user.getAllAccounts().size(),3);
		}
	


}
