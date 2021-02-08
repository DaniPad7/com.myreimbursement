package com.mydealership.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mydealership.dao.DealershipViewDAO;
import com.mydealership.dao.impl.DealershipViewDAOImpl;
import com.mydealership.exception.BusinessException;
import com.mydealership.exception.EmptyQueryException;
import com.mydealership.exception.NullInfoException;
import com.mydealership.model.CarLot;
import com.mydealership.model.UserCorpInfo;
import com.mydealership.model.UsersTransactionHistory;
import com.mydealership.service.DealershipViewService;
import com.mydealership.service.util.factory.impl.UserFinanceInfoFactoryImpl;

public class DealershipViewServiceImpl implements DealershipViewService {
	public static Logger log = Logger.getLogger(DealershipViewServiceImpl.class);
	
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
	public List<CarLot> viewAllCarsOnLot() throws BusinessException, EmptyQueryException {
		List<CarLot> carsOnLotNotOwned = new ArrayList<>();
		carsOnLotNotOwned = dealershipViewDAO.viewAllCarsOnLot();
		for(CarLot car : carsOnLotNotOwned) {
			carsOnLotNotOwned.removeIf(c -> car.isOwned() == true);
			}
		if(carsOnLotNotOwned.size() < 1) {
			throw new EmptyQueryException("No data found");
		}
		else {
			log.info(carsOnLotNotOwned);
		}
		return carsOnLotNotOwned;
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
