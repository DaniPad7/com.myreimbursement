package com.mydealership.service.util.factory;

import com.mydealership.exception.BusinessException;
import com.mydealership.model.UserCorpInfo;

public interface LoginFactory {
	void setLogin() throws BusinessException;
	UserCorpInfo getLogIn() throws BusinessException;

}
