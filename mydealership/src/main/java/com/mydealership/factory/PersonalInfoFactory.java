package com.mydealership.factory;

import com.mydealership.exception.BusinessException;
import com.mydealership.model.UserPersonalInfo;

public interface PersonalInfoFactory {
	
	public UserPersonalInfo setUserPersonalInfoAndUserCorpInfoGetFormer() throws BusinessException;

}
