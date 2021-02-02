package com.mydealership.service;

import com.mydealership.exception.BusinessException;

public interface DealershipDeletionService {
	public void deleteCarFromLot() throws BusinessException;
	public void deleteOffersDorOwnedCar() throws BusinessException;

}
