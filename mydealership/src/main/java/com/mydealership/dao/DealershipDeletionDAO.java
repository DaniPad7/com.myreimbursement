package com.mydealership.dao;

import java.sql.SQLException;

import com.mydealership.exception.BusinessException;

public interface DealershipDeletionDAO {
	void deleteCarFromLot(int carId) throws BusinessException;
	void deleteOffersForOwnedCar(int offerId) throws BusinessException;
	void deleteProfileWhenDuplicate();

}
