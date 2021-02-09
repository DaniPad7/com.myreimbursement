package com.mydealership.service.util.calculator.impl;

import com.mydealership.dao.FinanceRetrieverDAO;
import com.mydealership.dao.impl.FinanceRetrieverDAOImpl;
import com.mydealership.exception.BusinessException;
import com.mydealership.exception.EmptyQueryException;
import com.mydealership.model.UserFinanceInfo;
import com.mydealership.service.util.calculator.FinanceRetriever;

public class FinanceRetrieverImpl implements FinanceRetriever{
	FinanceRetrieverDAO financeRetrieverDAO = new FinanceRetrieverDAOImpl();
	UserFinanceInfo userFinanceInfo;

	@Override
	public UserFinanceInfo viewAcceptedOffer(int offerId) throws BusinessException, EmptyQueryException {
		userFinanceInfo = null;
		userFinanceInfo = financeRetrieverDAO.viewAcceptedOffer(offerId);
		if(userFinanceInfo != null) {
		}
		else {}
		return userFinanceInfo;
	}

}
