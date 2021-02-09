package com.mydealership.service;

import java.sql.SQLException;

import com.mydealership.exception.BusinessException;

public interface DealershipDeletionService {
	void deleteCarFromLot(int carId) throws BusinessException;
	void deleteOffersForOwnedCar(int offerid) throws BusinessException;
	void deleteProfileWhenDuplicate();

}
