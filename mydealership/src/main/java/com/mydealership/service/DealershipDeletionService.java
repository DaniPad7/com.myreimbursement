package com.mydealership.service;

import java.sql.SQLException;

import com.mydealership.exception.BusinessException;

public interface DealershipDeletionService {
	void deleteCarFromLot() throws BusinessException;
	void deleteOffersForOwnedCar() throws BusinessException;
	void deleteProfileWhenDuplicate();

}
