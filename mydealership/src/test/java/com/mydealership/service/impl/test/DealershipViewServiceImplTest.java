package com.mydealership.service.impl.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.mydealership.dao.impl.DealershipViewDAOImpl;
import com.mydealership.exception.BusinessException;
import com.mydealership.exception.EmptyQueryException;
import com.mydealership.exception.NullInfoException;
import com.mydealership.model.UserCorpInfo;
import com.mydealership.model.UserFinanceInfo;
import com.mydealership.model.UsersTransactionHistory;
import com.mydealership.service.impl.DealershipViewServiceImpl;

public class DealershipViewServiceImplTest {
	@InjectMocks
	private static DealershipViewServiceImpl dealershipViewServiceImpl;
	
	@Mock
	private DealershipViewDAOImpl dealershipViewDAO;
	
	@BeforeClass
	public static void setup() {
		dealershipViewServiceImpl = new DealershipViewServiceImpl();
	}
	
	@Before
	public void beforeSetup() {
		MockitoAnnotations.initMocks(this);
		String username = "";
		String password = "";
		String firstName = "";
		String lastName = "";
		int userId = 0;
		int carId = 0;
	}

	@Test
	public void testLoginForUnacceptedNulls() {
		String username = null;
		String password = "";
		try {
			Mockito.when(dealershipViewDAO.login(username, password)).thenReturn(new UserCorpInfo(0, "", "", false));
			Assert.assertThrows(NullInfoException.class, () -> dealershipViewServiceImpl.login(username, password));
		} catch (NullInfoException | EmptyQueryException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testViewAllCarsOnLotForEmptyQueryException() {
		try {
			Mockito.when(dealershipViewDAO.viewAllCarsOnLot()).thenReturn(new ArrayList<>());
			Assert.assertThrows(EmptyQueryException.class, () -> dealershipViewServiceImpl.viewAllCarsOnLot());
		} catch (BusinessException | EmptyQueryException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testViewUnownedCarsOnLotForEmptyQueryException() {
		try {
			Mockito.when(dealershipViewDAO.viewUnownedCarsOnLot()).thenReturn(new ArrayList<>());
			Assert.assertThrows(EmptyQueryException.class, () -> dealershipViewServiceImpl.viewUnownedCarsOnLot());
		} catch (BusinessException | EmptyQueryException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testViewOwnedCarsForEmptyQueryException() {
		int offerId = 0;
		try {
			Mockito.when(dealershipViewDAO.viewOwnedCars(offerId)).thenReturn(new ArrayList<>());
			Assert.assertThrows(EmptyQueryException.class, () -> dealershipViewServiceImpl.viewOwnedCars(offerId));
		} catch (BusinessException | EmptyQueryException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testViewAllOffersForSuccessfulQuery() {
		List<UserFinanceInfo> testList = Arrays.asList(new UserFinanceInfo(0, 0, 0, 1100, 48, 6, 820, false, Date.valueOf("2005-05-05")));
		try {
			Mockito.when(dealershipViewDAO.viewAllOffers()).thenReturn(Arrays.asList(new UserFinanceInfo(0, 0, 0, 1100, 48, 6, 820, false, Date.valueOf("2005-05-05"))));
			
				Assert.assertEquals(testList.toArray(), dealershipViewServiceImpl.viewAllOffers().toArray());
			
		} catch (BusinessException | EmptyQueryException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testViewRemainingPaymentsForSuccessfulQuery() {
		int userId = 0;
		int carId = 0;
		List<UsersTransactionHistory> testList = new ArrayList<>();
		testList.add(new UsersTransactionHistory(0, 0, 0, 0, 0, 0, 0, Date.valueOf("2005-05-05")));
		try {
			Mockito.when(dealershipViewDAO.viewRemainingPayments(userId, carId)).thenReturn(Arrays.asList(new UsersTransactionHistory(0, 0, 0, 0, 0, 0, 0, Date.valueOf("2005-05-05"))));
				
			Assert.assertEquals(testList.toArray(), dealershipViewServiceImpl.viewRemainingPayments(userId, carId).toArray());
			
		} catch (BusinessException | EmptyQueryException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testViewAllCustomerPaymentsForSuccessfulQuery() {
		String firstName = "";
		String lastName = "";
		List<UsersTransactionHistory> testList = new ArrayList<>();
		testList.add(new UsersTransactionHistory(0, 0, 0, 0, 0, 0, 0, Date.valueOf("2005-05-05")));
		try {
			Mockito.when(dealershipViewDAO.viewAllCustomerPayments(firstName, lastName)).thenReturn(Arrays.asList(new UsersTransactionHistory(0, 0, 0, 0, 0, 0, 0, Date.valueOf("2005-05-05"))));
			
				Assert.assertEquals(testList.toArray(), dealershipViewServiceImpl.viewAllCustomerPayments(firstName, lastName).toArray());
			
		} catch (BusinessException | EmptyQueryException e) {
			e.printStackTrace();
		}
	}
/*
	@Test
	public void testGetMonthlyPayment() {
		fail("Not yet implemented");
	}
*/
}
