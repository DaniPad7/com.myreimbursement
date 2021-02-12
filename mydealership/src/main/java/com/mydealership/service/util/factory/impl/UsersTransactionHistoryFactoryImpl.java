package com.mydealership.service.util.factory.impl;

import java.sql.Date;

import com.mydealership.exception.BusinessException;
import com.mydealership.exception.EmptyQueryException;
import com.mydealership.model.UsersTransactionHistory;
import com.mydealership.service.util.calculator.FinanceCalculator;
import com.mydealership.service.util.calculator.impl.FinanceCalculatorImpl;
import com.mydealership.service.util.factory.UsersTransactionHistoryFactory;

public class UsersTransactionHistoryFactoryImpl implements UsersTransactionHistoryFactory {
	UsersTransactionHistory usersTransactionHistory;
	private FinanceCalculator financeCalculator = new FinanceCalculatorImpl();
// can be updated and upgraded
	@Override
	public void setUsersTransactionHistory(int offerId) throws BusinessException, EmptyQueryException, NullPointerException {
		int automaticSet = 1;
		switch(automaticSet) {
		case 1:
			//usersTransactionHistory.setCarId(financeCalculator.getOfferCarId(offerId));
			usersTransactionHistory.setUserId(financeCalculator.getOfferUserid(offerId));
			usersTransactionHistory.setAmount(0);
			usersTransactionHistory.setRemainingBalance(financeCalculator.getOfferRemainingBalance(offerId));
			usersTransactionHistory.setNextPayment(financeCalculator.getOfferNextPayment(offerId));
			usersTransactionHistory.setTransactionDate(financeCalculator.getOfferTransactionDate(offerId));
			usersTransactionHistory.setPaymentsLeft(financeCalculator.getPaymentsLeft(offerId));
		
		}

	}

	@Override
	public UsersTransactionHistory getUsersTransactionHistory() throws BusinessException {
		return usersTransactionHistory;
	}

}
