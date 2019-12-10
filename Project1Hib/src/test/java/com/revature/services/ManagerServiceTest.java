//package com.revature.services;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import com.revature.daos.ManagerDao;
//import com.revature.models.Manager;
//
//
//@RunWith(MockitoJUnitRunner.class)
//public class ManagerServiceTest {
//	
//	@InjectMocks
//	private ManagerService ms;
//	
//	@Mock
//	private ManagerDao md;
//	
//	@Test
//	public void testGettingManagers() {
//		
//		List<Manager> managers = new ArrayList<>();
//		
//		managers.add(new Manager());
//		managers.add(new Manager());
//		
//		when(md.getManagers()).thenReturn(managers);
//		
//		assertEquals(ms.getManagers().size(), 2);
//	}
//	
//	@Test
//	public void testGettingManagerByUsername() {
//		
//		Manager expected = new Manager("adonis", "cabreja", "adoniscm", "password", 1);
//		
//		when(md.getManagerByUsername("adoniscm")).thenReturn(new Manager("adonis", "cabreja", "adoniscm", "password", 1));
//		
//		Manager actual = ms.getManagerByUsername("adoniscm");
//		
//		assertEquals(expected, actual);
//	}
//}
