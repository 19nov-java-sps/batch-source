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
	
	// Tests the createUser function
	@Test
	public void testCreatingUser() {
		
		String expected = "\nUser Created!\n";
		
		User u = new User("adonis", "123", "adonis", "cabreja", 0);
		
		when(ud.createUser(u)).thenReturn(1);
		
		String actual = us.createUser(u);
		
		assertEquals(expected, actual);
	}
	
	// Tests the updateUser function
	@Test
	public void testUpdatingUser() {
		
		int expected = 1;
		
		User u = new User("adonis", "123", "adonis", "cabreja", 0);
		
		when(ud.updateUser(u.getUsername(), u.getBalance())).thenReturn(1);
		
		int actual = us.updateUser(u.getUsername(), u.getBalance());
		
		assertEquals(expected, actual);
	}
	
	// Tests the deleteUser function
	@Test
	public void testDeletingUser() {
		
		int expected = 1;
		
		User u = new User("adonis", "123", "adonis", "cabreja", 0);
		
		when(ud.deleteUser(u.getUsername())).thenReturn(1);
		
		int actual = us.deleteUser(u.getUsername());
		
		assertEquals(expected, actual);
	}
	
	// Tests the getUserTable function
	@Test
	public void testGetUsersTable() {
		
		List<User> usersTable = new ArrayList<>();
		
		usersTable.add(new User());
		usersTable.add(new User());
		
		when(ud.getUserTable()).thenReturn(usersTable);
		
		assertEquals(us.getUserTable().size(),2);
	}
}
