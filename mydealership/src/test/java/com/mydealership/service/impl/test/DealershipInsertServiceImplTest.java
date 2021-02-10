package com.mydealership.service.impl.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.mydealership.dao.impl.DealershipInsertDAOImpl;
import com.mydealership.exception.BusinessException;
import com.mydealership.exception.NullInfoException;
import com.mydealership.model.CarLot;
import com.mydealership.model.UserCorpInfo;
import com.mydealership.model.UserFinanceInfo;
import com.mydealership.model.UserPersonalInfo;
import com.mydealership.model.UsersTransactionHistory;
import com.mydealership.service.impl.DealershipInsertServiceImpl;

public class DealershipInsertServiceImplTest {
	@InjectMocks
	private static DealershipInsertServiceImpl dealershipInsertServiceImpl;
	
	@Mock
	private DealershipInsertDAOImpl dealershipInsertDAO;
	
	@BeforeClass
	public static void setup() {
		dealershipInsertServiceImpl = new DealershipInsertServiceImpl();
		
	}
	
	@Before
	public void beforeSetup() {
		MockitoAnnotations.initMocks(this);
		UserPersonalInfo userPersonalInfo = new UserPersonalInfo();
		UserCorpInfo userCorporateInfo = new UserCorpInfo();
		UserFinanceInfo userFinanceInfo = new UserFinanceInfo();
		CarLot carLot = new CarLot();
		UsersTransactionHistory usersTransactionHistory = new UsersTransactionHistory();
	}
	
	@Test
	public void testRegisterCustomerAccountForUnacceptedNulls() {
		UserPersonalInfo userPersonalInfo = new UserPersonalInfo(0, null, null, null, "123example", "1234567890", null, null, null, null, null);
		UserCorpInfo userCorporateInfo = new UserCorpInfo(0, null, null, true);
		try {
			Mockito.when(dealershipInsertDAO.registerCustomerAccount(userPersonalInfo, userCorporateInfo)).thenReturn(1);
			//Assert.assertEquals(0, dealershipInsertServiceImpl.registerCustomerAccount(userPersonalInfo, userCorporateInfo));
			Assert.assertThrows(NullInfoException.class, () -> dealershipInsertServiceImpl.registerCustomerAccount(userPersonalInfo, userCorporateInfo));
		} catch (BusinessException | NullInfoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMakeCarOfferForUnacceptedNulls() {
		UserFinanceInfo userFinanceInfo = new UserFinanceInfo(0, 0, 0, 0, 0, 0, 0, false, null);
		try {
			Mockito.when(dealershipInsertDAO.makeCarOffer(userFinanceInfo)).thenReturn(1);
			//Assert.assertEquals(0, dealershipInsertServiceImpl.makeCarOffer(userFinanceInfo));
			Assert.assertThrows(NullInfoException.class, () -> dealershipInsertServiceImpl.makeCarOffer(userFinanceInfo));
		} catch (BusinessException | NullInfoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAddCarForUnacceptedNulls() {
		CarLot carLot = new CarLot(0, false, 0, null, null, null, null, null, false, 0, 0);
		try {
			Mockito.when(dealershipInsertDAO.addCar(carLot)).thenReturn(1);
			//Assert.assertEquals(0, dealershipInsertServiceImpl.addCar(carLot));
			Assert.assertThrows(NullInfoException.class, () -> dealershipInsertServiceImpl.addCar(carLot));
		} catch (BusinessException | NullInfoException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testCreateFirstTransactionForUnacceptedNulls() {
		UsersTransactionHistory usersTransactionHistory = new UsersTransactionHistory(0, 0, 0, 0, 0, 0, 0, null);
		try {
			Mockito.when(dealershipInsertDAO.createFirstTransaction(usersTransactionHistory)).thenReturn(1);
			//Assert.assertEquals(0, dealershipInsertServiceImpl.createFirstTransaction(usersTransactionHistory));
			Assert.assertThrows(NullInfoException.class, () -> dealershipInsertServiceImpl.createFirstTransaction(usersTransactionHistory));
		} catch (BusinessException | NullInfoException e) {
			e.printStackTrace();
		}
	}

}
