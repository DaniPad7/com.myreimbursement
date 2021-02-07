package com.mydealership.dao;

import java.sql.SQLException;

import com.mydealership.exception.BusinessException;

public interface DealershipDeletionDAO {
	void deleteCarFromLot() throws BusinessException;
	void deleteOffersForOwnedCar() throws BusinessException;
	void deleteProfileWhenDuplicate();

}
