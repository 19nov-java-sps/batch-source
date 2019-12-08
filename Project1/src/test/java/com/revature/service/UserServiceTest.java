package com.revature.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.revature.dao.UserDao;
import com.revature.model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@InjectMocks
	private UserService us;
	
	@Mock
	private UserDao ud;
	
	// Test the createUser method
		
		@Test
		public void testCreatingUser() {
			
			String expected = "\n User Created! \n";
			
			User u = new User(1234, "revatureguy", "revaturejava123", "john", "doe", 4567, false);
			
			when(ud.createUser(u)).thenReturn(1);
			
			String actual = us.createUser(u);
			
			assertEquals(expected, actual);
		}
	
		// Tests the updateUser method
		@Test
		public void testUpdatingUser() {
			
			String expected = "\n User Updated! \n";
			
			User u = new User(1234, "revatureguy", "revaturejava123", "john", "doe", 4567, false);
			
			when(ud.updateUser(u.getFirstName(), u.getLastName(), u.getUserId())).thenReturn(1);
			
			String actual = us.updateUser(u.getFirstName(), u.getLastName(), u.getUserId());
			
			assertEquals(expected, actual);
		}
		
		// Tests the deleteUser method
		@Test
		public void testDeletingUser() {
			
			int expected = 1;
			
			User u = new User(1234, "revatureguy", "revaturejava123", "john", "doe", 4567, false);
			
			when(ud.deleteUser(u.getUserId())).thenReturn(1);
			
			int actual = us.deleteUser(u.getUserId());
			
			assertEquals(expected, actual);
		}
		
		// Tests the getUserTable method
		@Test
		public void testGetUserTable() {
			
			List<User> userTable = new ArrayList<>();
			
			userTable.add(new User());
			userTable.add(new User());
			
			when(ud.getUserTable()).thenReturn(userTable);
			
			assertEquals(us.getUserTable().size(),2);
		}
		

}
