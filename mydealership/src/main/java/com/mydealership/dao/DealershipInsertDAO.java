package com.mydealership.dao;

import com.mydealership.exception.BusinessException;
import com.mydealership.model.CarLot;


public interface DealershipInsertDAO {
	public int registerCustomerAccount() throws BusinessException;
	public int makeCarOffer() throws BusinessException;
	public int addCar(CarLot carLot) throws BusinessException;

}
