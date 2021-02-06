package com.mydealership.service.util.factory;

import com.mydealership.exception.BusinessException;
import com.mydealership.model.UserFinanceInfo;

public interface UserFinanceInfoFactory {
	void setUserFinanceInfo() throws BusinessException;
	UserFinanceInfo getUserFinanceInfo() throws BusinessException;

}
