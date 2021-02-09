package com.mydealership.service.util.calculator;


import com.mydealership.exception.BusinessException;
import com.mydealership.exception.EmptyQueryException;
import com.mydealership.model.UserFinanceInfo;

public interface FinanceRetriever {
	UserFinanceInfo viewAcceptedOffer(int offerId) throws BusinessException, EmptyQueryException;

}
