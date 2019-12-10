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
//import com.revature.daos.ReimbursementDao;
//import com.revature.models.Reimbursement;
//
//@RunWith(MockitoJUnitRunner.class)
//public class ReimbursementServiceTest {
//	
//	@InjectMocks
//	private ReimbursementService rs;
//	
//	@Mock
//	private ReimbursementDao rd;
//	
//	@Test
//	public void testGettingReimbursements() {
//		
//		List<Reimbursement> reimbursements = new ArrayList<>();
//		
//		reimbursements.add(new Reimbursement());
//		reimbursements.add(new Reimbursement());
//		reimbursements.add(new Reimbursement());
//		
//		when(rd.getReimbursements()).thenReturn(reimbursements);
//		
//		assertEquals(rs.getReimbursements().size(),3);
//	}
//	
//	@Test
//	public void testGettingReimbursementsByUsername() {
//		
//		List<Reimbursement> reimbursementsByUsername = new ArrayList<>();
//		
//		reimbursementsByUsername.add(new Reimbursement(1, 20, "description", "Pending", "name", "username", "manager"));
//		reimbursementsByUsername.add(new Reimbursement(2, 25, "description", "Pending", "name", "username", "manager"));
//		
//		when(rd.getReimbursementsByUsername("username")).thenReturn(reimbursementsByUsername);
//		
//		assertEquals(rs.getReimbursementsByUsername("username").size(), 2);
//	}
//	
//	@Test
//	public void testGettingReimbursementsByStatus() {
//		
//		List<Reimbursement> reimbursementsByStatus = new ArrayList<>();
//		
//		reimbursementsByStatus.add(new Reimbursement(1, 20, "description", "Pending", "name", "username", "manager"));
//		reimbursementsByStatus.add(new Reimbursement(2, 25, "description", "Pending", "name", "username", "manager"));
//		
//		when(rd.getReimbursementsByStatus("Pending")).thenReturn(reimbursementsByStatus);
//		
//		assertEquals(rs.getReimbursementsByStatus("Pending").size(), 2);
//	}
//	
//	@Test
//	public void testGettingReimbursementsByStatusAndUsername() {
//		
//		List<Reimbursement> reimbursementsByStatusAndUsername = new ArrayList<>();
//		
//		reimbursementsByStatusAndUsername.add(new Reimbursement(1, 20, "description", "Pending", "name", "username", "manager"));
//		reimbursementsByStatusAndUsername.add(new Reimbursement(2, 25, "description", "Pending", "name", "username", "manager"));
//		
//		when(rd.getReimbursementsByStatusAndUsername("Pending", "username")).thenReturn(reimbursementsByStatusAndUsername);
//		
//		assertEquals(rs.getReimbursementsByStatusAndUsername("Pending", "username").size(), 2);
//	}
//	
//	@Test
//	public void testUpdatingReimbursement() {
//		
//		int expected = 1;
//		
//		Reimbursement r = new Reimbursement(1, 30, "description", "Pending", "name", "username", "manager");
//		r.setStatus("Resolved");
//		
//		when(rd.updateReimbursement(r.getReim_id(), r.getManagerName(), r.getStatus())).thenReturn(1);
//		
//		int actual = rs.updateReimbursement(r.getReim_id(), r.getManagerName(), r.getStatus());
//		
//		assertEquals(expected, actual);
//	}
//		
//	@Test
//	public void testCreatingReimbursement() {
//		
//		int expected = 1;
//		
//		Reimbursement r = new Reimbursement(1, 30, "description", "Pending", "name", "username", "manager");
//		
//		when(rd.createReimbursement(r)).thenReturn(1);
//		
//		int actual = rs.createReimbursement(r);
//		
//		assertEquals(expected, actual);
//	}
//}
