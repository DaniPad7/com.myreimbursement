package com.mydealership.dao;

import com.mydealership.exception.BusinessException;
import com.mydealership.model.CarLot;
import com.mydealership.model.UserPersonalInfo;

public interface DealershipInsertDAO {
	public int registerCustomerAccount(UserPersonalInfo userPersonalInfo) throws BusinessException;
	public int makeCarOffer() throws BusinessException;
	public int addCar(CarLot carLot) throws BusinessException;

}
