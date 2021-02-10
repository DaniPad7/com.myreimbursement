package com.mydealership.service.util.calculator.impl;

import java.sql.Date;

import com.mydealership.exception.BusinessException;
import com.mydealership.exception.EmptyQueryException;
import com.mydealership.service.util.calculator.FinanceCalculator;
import com.mydealership.service.util.calculator.FinanceRetriever;

public class FinanceCalculatorImpl implements FinanceCalculator{
	private FinanceRetriever financeRetriever = new FinanceRetrieverImpl();
	
	// this can be upgraded

	@Override
	public double getAPR(float principal, int loanLength, int creditScore)
			throws BusinessException {
		float fees = 1500;
		float interest = (float) (0.09/ (creditScore + 1)) * principal;
		double apr = (double) (((fees + interest)/((loanLength * principal) + 1)) * (365/30) * 100);
		return apr;
	}

	@Override
	public int getOfferCarId(int offerId) throws BusinessException, EmptyQueryException {
		int carId = 0;
		carId = financeRetriever.viewAcceptedOffer(offerId).getCarId();
		return carId;
	}

	@Override
	public int getOfferUserid(int offerId) throws BusinessException, EmptyQueryException {
		int userId = 0;
		userId = financeRetriever.viewAcceptedOffer(offerId).getUserId();
		return userId;
	}

	@Override
	public float getOfferRemainingBalance(int offerId) throws BusinessException, EmptyQueryException {
		float remainingBalance = 0;
		remainingBalance = (financeRetriever.viewAcceptedOffer(offerId).getPrincipalLoan() - 0);
		return remainingBalance;
	}

	@Override
	public float getOfferNextPayment(int offerId) throws BusinessException, EmptyQueryException {
		float nextPayment = 0;
		nextPayment = (financeRetriever.viewAcceptedOffer(offerId).getPrincipalLoan()/(financeRetriever.viewAcceptedOffer(offerId).getLoanLength() + 1));
		return nextPayment;
	}

	@Override
	public int getPaymentsLeft(int offerId) throws BusinessException, EmptyQueryException {
		int paymentsLeft = 0;
		paymentsLeft = financeRetriever.viewAcceptedOffer(offerId).getLoanLength();
		return paymentsLeft;
	}

	@Override
	public Date getOfferTransactionDate(int offerId) throws BusinessException, EmptyQueryException {
		Date transactionDate = null;
		transactionDate = financeRetriever.viewAcceptedOffer(offerId).getOfferDate();
		return transactionDate;
	}

}
