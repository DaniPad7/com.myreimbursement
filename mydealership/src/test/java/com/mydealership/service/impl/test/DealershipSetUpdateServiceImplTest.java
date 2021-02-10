package com.mydealership.service.impl.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.mydealership.dao.impl.DealershipSetUpdateDAOImpl;
import com.mydealership.exception.BusinessException;
import com.mydealership.exception.EmptyQueryException;
import com.mydealership.exception.NullInfoException;
import com.mydealership.service.impl.DealershipSetUpdateServiceImpl;

import junit.framework.Assert;

public class DealershipSetUpdateServiceImplTest {
	@InjectMocks
	private static DealershipSetUpdateServiceImpl dealershipSetUpdateServiceImpl;
	
	@Mock
	private DealershipSetUpdateDAOImpl dealershipSetUpdateDAO;
	
	@BeforeClass
	public static void setup() {
		dealershipSetUpdateServiceImpl = new DealershipSetUpdateServiceImpl();	
	}
	
	@Before
	public void beforeSetup() {
		MockitoAnnotations.initMocks(this);
		int offerId = 0;
	}

	@Test
	public void testSetOfferApprovalForFailedUpdate() {
		try {
			Mockito.when(dealershipSetUpdateDAO.setOfferApproval(0)).thenReturn(0);
			//Assert.assertEquals(0, dealershipSetUpdateServiceImpl.setOfferApproval(0));
			Assert.assertEquals(0, dealershipSetUpdateServiceImpl.setOfferApproval(0));
		} catch (BusinessException | EmptyQueryException | NullInfoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSetCarOwnership() {
		try {
			Mockito.when(dealershipSetUpdateDAO.setCarOwnership(0)).thenReturn(0);
			//Assert.assertEquals(0, dealershipSetUpdateServiceImpl.setCarOwnership(0));
			Assert.assertEquals(0, dealershipSetUpdateServiceImpl.setCarOwnership(0));
		} catch (BusinessException e) {
			e.printStackTrace();
		}
	}

}
