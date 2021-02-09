package com.mydealership.service.util.factory;

import com.mydealership.exception.BusinessException;
import com.mydealership.exception.EmptyQueryException;
import com.mydealership.model.UsersTransactionHistory;

public interface UsersTransactionHistoryFactory {
	void setUsersTransactionHistory(int offerId) throws BusinessException, EmptyQueryException;
	UsersTransactionHistory getUsersTransactionHistory() throws BusinessException;

}
