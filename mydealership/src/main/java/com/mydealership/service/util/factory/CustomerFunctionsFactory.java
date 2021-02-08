package com.mydealership.service.util.factory;

import com.mydealership.exception.BusinessException;
import com.mydealership.exception.EmptyQueryException;

public interface CustomerFunctionsFactory {
	void customerFunctions(int userId) throws BusinessException, EmptyQueryException;

}
