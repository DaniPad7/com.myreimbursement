package com.mydealership.service.util.factory;

import com.mydealership.exception.BusinessException;
import com.mydealership.exception.EmptyQueryException;
import com.mydealership.exception.NullInfoException;

public interface EmployeeFunctionsFactory {
	void employeeFunctions(int userId) throws BusinessException, NullInfoException;

}
