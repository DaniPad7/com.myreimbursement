package com.mydealership.dao;

import com.mydealership.exception.BusinessException;
import com.mydealership.exception.EmptyQueryException;
import com.mydealership.model.UserFinanceInfo;

public interface FinanceRetrieverDAO {
	UserFinanceInfo viewAcceptedOffer(int offerId) throws BusinessException, EmptyQueryException;

}
