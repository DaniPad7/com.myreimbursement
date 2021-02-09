package com.mydealership.service.util.calculator;

import java.sql.Date;

import com.mydealership.exception.BusinessException;
import com.mydealership.exception.EmptyQueryException;

public interface FinanceCalculator {
	double getAPR(float principal, int loanLength, int creditScore) throws BusinessException;
	int getOfferCarId(int offerId) throws BusinessException, EmptyQueryException;
	int getOfferUserid(int offerId) throws BusinessException, EmptyQueryException;
	float getOfferRemainingBalance(int offerId)throws BusinessException, EmptyQueryException;
	float getOfferNextPayment(int offerId) throws BusinessException, EmptyQueryException;
	int getPaymentsLeft(int offerId) throws BusinessException, EmptyQueryException;
	Date getOfferTransactionDate(int offerId) throws BusinessException, EmptyQueryException;
}
