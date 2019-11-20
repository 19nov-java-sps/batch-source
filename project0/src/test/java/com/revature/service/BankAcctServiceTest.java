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

import com.revature.dao.BankAcctDao;
import com.revature.model.BankAcct;

@RunWith(MockitoJUnitRunner.class)
public class BankAcctServiceTest {
	
	@InjectMocks
	private BankAcctService bas;
	
	@Mock
	private BankAcctDao bad;
	
	@Test
	public void testGettingAllBankAccts() {
		List<BankAcct> acctList = new ArrayList<>();
		acctList.add(new BankAcct());
		acctList.add(new BankAcct());
		acctList.add(new BankAcct());
	
		when(bad.getBankAcct()).thenReturn(acctList);
		assertEquals(bas.getBankAcct().size(),3);
	}

	@Test
	public void testGettingBankAcctByUserId() {
		
		
		when(bad.getBankAcctByUserId(1)).thenReturn(new BankAcct("kwame", "Lee", 0, 1));
		BankAcct expected = new BankAcct("kwame", "Lee", 0, 1);
		BankAcct actual = bas.getBankAcctByUserId(1);
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void testUpdateBankAcct() {
		boolean expected = true;
		BankAcct bAcct = new BankAcct();
		bAcct.setUserId(1);
		bAcct.setFirstName("jason");;
		
		when(bad.updateBankAcct(bAcct)).thenReturn(1);
		boolean actual = bas.updateBankAcct(bAcct);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDeleteBankAcct() {
		boolean expected = true;
		BankAcct  bAcct = new BankAcct();
		bAcct.setUserId(1);
		bAcct.setFirstName("Jason");
		
		when(bad.deleteBankAcct(bAcct)).thenReturn(1);
		boolean actual = bas.deleteBankAcct(bAcct);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCreateBankAcct() {
		BankAcct bAcct = new BankAcct();
		boolean expected = true;
		
		when(bad.createBankAcct(bAcct)).thenReturn(1);
		boolean actual = bas.createBankAcct(bAcct);
		assertEquals(expected, actual);
		
	}
	
	
	
}
