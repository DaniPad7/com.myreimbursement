package com.mydealership.service.impl;

import com.mydealership.exception.BusinessException;
import com.mydealership.model.CarLot;
import com.mydealership.model.UserCorpInfo;
import com.mydealership.model.UserFinanceInfo;
import com.mydealership.model.UserPersonalInfo;
import com.mydealership.service.DealershipInsertService;

public class DealershipInsertServiceImpl implements DealershipInsertService{

	@Override
	public int registerCustomerAccount(UserPersonalInfo userPersonalInfo, UserCorpInfo userCorporateInfo) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int makeCarOffer(UserFinanceInfo userFinanceInfo) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addCar(CarLot carLot) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
