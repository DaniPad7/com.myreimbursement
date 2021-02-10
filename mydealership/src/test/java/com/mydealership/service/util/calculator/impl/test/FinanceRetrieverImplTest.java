package com.mydealership.service.util.calculator.impl.test;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.mydealership.dao.impl.FinanceRetrieverDAOImpl;
import com.mydealership.exception.BusinessException;
import com.mydealership.exception.EmptyQueryException;
import com.mydealership.service.util.calculator.impl.FinanceRetrieverImpl;

public class FinanceRetrieverImplTest {
	@InjectMocks
	private static FinanceRetrieverImpl financeRetrieverImpl;
	@Mock
	private FinanceRetrieverDAOImpl financeRetrieverDAO;
	
	@BeforeClass
	public static void setup() {
		financeRetrieverImpl = new FinanceRetrieverImpl();
	}
	
	@Before
	public void beforeSetup() {
		MockitoAnnotations.initMocks(this);
		int offerId = 0;
	}

	@Test
	public void testViewAcceptedOfferForEmptyQueryException() {
		int offerId = 0;
		try {
			Mockito.when(financeRetrieverDAO.viewAcceptedOffer(offerId)).thenThrow(EmptyQueryException.class);
			Assert.assertThrows(EmptyQueryException.class, () -> financeRetrieverImpl.viewAcceptedOffer(offerId));
		} catch (BusinessException | EmptyQueryException e) {
			e.printStackTrace();
		}
	}

}
