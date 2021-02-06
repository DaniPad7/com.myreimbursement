package com.mydealership.service.util.factory;

import com.mydealership.exception.BusinessException;
import com.mydealership.model.UserCorpInfo;
import com.mydealership.model.UserPersonalInfo;

public interface PersonalInfoFactory {
	
	void setUserPersonalInfoAndUserCorpInfo() throws BusinessException;
	UserPersonalInfo getUserPersonalInfo() throws BusinessException;
	UserCorpInfo getUserCorpInfo() throws BusinessException;
}
