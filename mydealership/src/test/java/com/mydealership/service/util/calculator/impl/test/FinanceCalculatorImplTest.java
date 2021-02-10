package com.mydealership.service.util.calculator.impl.test;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.mydealership.exception.BusinessException;
import com.mydealership.exception.EmptyQueryException;
import com.mydealership.model.UserFinanceInfo;
import com.mydealership.service.util.calculator.FinanceRetriever;
import com.mydealership.service.util.calculator.impl.FinanceCalculatorImpl;
import com.mydealership.service.util.calculator.impl.FinanceRetrieverImpl;

import junit.framework.Assert;
public class FinanceCalculatorImplTest {
	@InjectMocks
	private static FinanceCalculatorImpl financeCalculatorImpl;
	
	@Mock
	private FinanceRetrieverImpl financeRetriever;
	
	@BeforeClass
	public static void setup() {
		financeCalculatorImpl = new FinanceCalculatorImpl();
	}
	
	@Before
	public void beforeSetup() {
		MockitoAnnotations.initMocks(this);
		float principal = 0; 
		int loanLength = 0; 
		int creditScore = 0;
		int offerId = 0;
	}

	@Test
	public void testGetAPRForAllZeros() {
		float principal = 0; 
		int loanLength = 0; 
		int creditScore = 0;
		try {
			assertEquals(1800000, financeCalculatorImpl.getAPR(principal, loanLength, creditScore), 0);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetOfferCarId() {
		int offerId = 0;
		try {
			Mockito.when(financeRetriever.viewAcceptedOffer(offerId)).thenReturn(new UserFinanceInfo(0, 3, 0, 0, 0, 0, 0, true, Date.valueOf("2005-05-05")));
			assertEquals(3, financeCalculatorImpl.getOfferCarId(offerId));
		} catch (BusinessException | EmptyQueryException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetOfferUserid() {
		int offerId = 0;
		try {
			Mockito.when(financeRetriever.viewAcceptedOffer(offerId)).thenReturn(new UserFinanceInfo(3, 0, 1, 0, 0, 0, 0, true, Date.valueOf("2005-05-05")));
			assertEquals(1, financeCalculatorImpl.getOfferUserid(offerId));
		} catch (BusinessException | EmptyQueryException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetOfferRemainingBalance() {
		int offerId = 0;
		try {
			Mockito.when(financeRetriever.viewAcceptedOffer(offerId)).thenReturn(new UserFinanceInfo(3, 0, 0, 500, 0, 0, 0, true, Date.valueOf("2005-05-05")));
			assertEquals(500, financeCalculatorImpl.getOfferRemainingBalance(offerId), 0);
		} catch (BusinessException | EmptyQueryException e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void testGetOfferNextPayment() {
		int offerId = 0;
		try {
			Mockito.when(financeRetriever.viewAcceptedOffer(offerId)).thenReturn(new UserFinanceInfo(3, 0, 0, 1, 0, 0, 0, true, Date.valueOf("2005-05-05")));
			assertEquals(1, financeCalculatorImpl.getOfferNextPayment(offerId), 0);
		} catch (BusinessException | EmptyQueryException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGetPaymentsLeft() {
		int offerId = 0;
		try {
			Mockito.when(financeRetriever.viewAcceptedOffer(offerId)).thenReturn(new UserFinanceInfo(3, 0, 0, 500, 45, 0, 0, true, Date.valueOf("2005-05-05")));
			assertEquals(45, financeCalculatorImpl.getPaymentsLeft(offerId), 0);
		} catch (BusinessException | EmptyQueryException e) {
			e.printStackTrace();
		}
	}

	/*@Test
	public void testGetOfferTransactionDate() {
		int offerId = 0;
		try {
			Mockito.when(financeRetriever.viewAcceptedOffer(offerId)).thenReturn(new UserFinanceInfo(3, 0, 0, 500, 0, 0, 0, true, Date.valueOf("2005-05-05")));
			
		} catch (BusinessException | EmptyQueryException e) {
			e.printStackTrace();
		}
	}*/

}
