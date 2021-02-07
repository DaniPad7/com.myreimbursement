package com.mydealership.dao;

import com.mydealership.exception.BusinessException;
import com.mydealership.exception.NullInfoException;
import com.mydealership.model.CarLot;
import com.mydealership.model.UserCorpInfo;
import com.mydealership.model.UserFinanceInfo;
import com.mydealership.model.UserPersonalInfo;


public interface DealershipInsertDAO {
	public int registerCustomerAccount(UserPersonalInfo userPersonalInfo, UserCorpInfo userCorporateInfo) throws BusinessException, NullInfoException;
	public int makeCarOffer(UserFinanceInfo userFinanceInfo) throws BusinessException;
	public int addCar(CarLot carLot) throws BusinessException, NullInfoException;

}
