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

import com.revature.dao.BalanceDao;
import com.revature.model.Balance;

@RunWith(MockitoJUnitRunner.class)
public class BalanceTest {
		
		@InjectMocks
		private BalanceService bs;
		
		@Mock
		private BalanceDao bd;

	
	
		@Test
		public void testcreateBalance() {
			Balance b = new Balance();
			int treuB = 0;
		
			when(bd.createBalance(b)).thenReturn(0);
			int alsoB = bs.createBalance(b);
			assertEquals(treuB, alsoB);
		
	}
	
	
	
}
