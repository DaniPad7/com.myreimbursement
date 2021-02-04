package com.mydealership.factory;

import com.mydealership.exception.BusinessException;
import com.mydealership.model.UserPersonalInfo;

public interface PersonalInfoFactory {
	
	public void setUserPersonalInfoAndUserCorpInfo() throws BusinessException;

}
