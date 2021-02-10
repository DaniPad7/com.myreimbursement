package com.mydealership.service.impl;

import org.apache.log4j.Logger;

import com.mydealership.dao.DealershipInsertDAO;
import com.mydealership.dao.impl.DealershipInsertDAOImpl;
import com.mydealership.exception.BusinessException;
import com.mydealership.exception.NullInfoException;
import com.mydealership.main.MyDealershipMain;
import com.mydealership.model.CarLot;
import com.mydealership.model.UserCorpInfo;
import com.mydealership.model.UserFinanceInfo;
import com.mydealership.model.UserPersonalInfo;
import com.mydealership.model.UsersTransactionHistory;
import com.mydealership.service.DealershipInsertService;

public class DealershipInsertServiceImpl implements DealershipInsertService{
	private DealershipInsertDAO dealershipInsertDAO = new DealershipInsertDAOImpl();
	public static Logger log = Logger.getLogger(MyDealershipMain.class);

	@Override
	public int registerCustomerAccount(UserPersonalInfo userPersonalInfo, UserCorpInfo userCorporateInfo) throws BusinessException, NullInfoException {
		int registered = 0;
		if((userPersonalInfo.getAddress() != null && userPersonalInfo.getBirthDate() != null && userPersonalInfo.getCity() != null && userPersonalInfo.getCountry() != null && userPersonalInfo.getFirstName() != null && userPersonalInfo.getLastName() != null
			&& userPersonalInfo.getState() != null && userPersonalInfo.getZipCode() != null	) && (userCorporateInfo.getUsername() != null && userCorporateInfo.getPassword() != null )) {
			registered = dealershipInsertDAO.registerCustomerAccount(userPersonalInfo, userCorporateInfo);
			if(registered == 2) {
				log.info("Profile registered successfully.");
			}
			else {
				log.info("Validation failed. Username is already taken.");
			}
		}
		else {
			throw new NullInfoException("Invalid data in the input. Please try again.");
		}
		return registered;
	}

	@Override
	public int makeCarOffer(UserFinanceInfo userFinanceInfo) throws BusinessException, NullInfoException {
		int registered = 0;
		if((userFinanceInfo.getApr() != 0f && userFinanceInfo.getCreditScore() != 0 && userFinanceInfo.getLoanLength() != 0 && userFinanceInfo.getPrincipalLoan() != 0) && userFinanceInfo != null) {
			registered = dealershipInsertDAO.makeCarOffer(userFinanceInfo);
			if(registered == 1) {
				log.info("Offer registered successfully.");
			}
			else {
				log.info("Vehicle offer failed to register.");
			}
		}
		else {
			throw new NullInfoException("Invalid data in the input. Please try again.");
		}
		return registered;
	}

	@Override
	public int addCar(CarLot carLot) throws BusinessException, NullInfoException {
		int registered = 0;
		if((carLot.getCarColor() != null && carLot.getCarMaker() != null && carLot.getCarModel() != null && carLot.getCarType() != null && carLot.getCarYear() != null && carLot.getPrice() != 0) && (carLot.isNew() == true || carLot.isNew() == false)) {
			registered = dealershipInsertDAO.addCar(carLot);
			if(registered == 1) {
				log.info("Vehicle registered successfully.");
			}
			else {
				log.info("Vehicle failed to register. Please check your connection.");
			}
		}
		else {
			throw new NullInfoException("Invalid data in the input. Please try again.");
		}
		
		return registered;
	}

	@Override
	public int createFirstTransaction(UsersTransactionHistory usersTransactionHistory) throws BusinessException, NullInfoException {
		int registered = 0;
		if(usersTransactionHistory.getTransactionDate() != null) {
			registered = dealershipInsertDAO.createFirstTransaction(usersTransactionHistory);
		}else {
			throw new NullInfoException("Invalid data in the input. Please try again.");
		}
		return registered;
	}
	

}
