package com.mydealership.service.impl;

import java.util.List;

import com.mydealership.dao.DealershipViewDAO;
import com.mydealership.dao.impl.DealershipViewDAOImpl;
import com.mydealership.exception.BusinessException;
import com.mydealership.exception.EmptyQueryException;
import com.mydealership.exception.NullInfoException;
import com.mydealership.model.CarLot;
import com.mydealership.model.UserCorpInfo;
import com.mydealership.model.UsersTransactionHistory;
import com.mydealership.service.DealershipViewService;

public class DealershipViewServiceImpl implements DealershipViewService {
	private DealershipViewDAO dealershipViewDAO  = new DealershipViewDAOImpl();

	@Override
	public UserCorpInfo login(String username, String password) throws NullInfoException, EmptyQueryException {
		UserCorpInfo userCorpInfoRetrieved = null;
		if(username != null && password != null) {
			userCorpInfoRetrieved = dealershipViewDAO.login(username, password);
		}
		else {
			throw new NullInfoException("Invalid data in the input. Please try again.");
		}
		return userCorpInfoRetrieved;
	}

	@Override
	public List<CarLot> viewAllCarsOnLot() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CarLot> viewOwnedCars(int userId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsersTransactionHistory> viewRemainingPayments(int userId, int carId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsersTransactionHistory> viewAllCustomerPayments(String username) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getMonthlyPayment() throws BusinessException {
		// TODO Auto-generated method stub

	}

}
