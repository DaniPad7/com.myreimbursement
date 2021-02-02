package com.mydealership.dao;

import com.mydealership.exception.BusinessException;

public interface DealershipDeletionDAO {
	public void deleteCarFromLot() throws BusinessException;
	public void deleteOffersDorOwnedCar() throws BusinessException;
	public void delete() throws BusinessException;

}
