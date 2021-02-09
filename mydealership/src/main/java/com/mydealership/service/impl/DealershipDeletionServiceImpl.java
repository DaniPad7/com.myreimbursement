package com.mydealership.service.impl;

import java.sql.SQLException;

import com.mydealership.dao.DealershipDeletionDAO;
import com.mydealership.dao.impl.DealershipDeletionDAOImpl;
import com.mydealership.exception.BusinessException;
import com.mydealership.service.DealershipDeletionService;

public class DealershipDeletionServiceImpl implements DealershipDeletionService {
	private DealershipDeletionDAO dealershipDeletionDAO = new DealershipDeletionDAOImpl();

	@Override
	public void deleteCarFromLot(int carId) throws BusinessException {
		dealershipDeletionDAO.deleteCarFromLot(carId);

	}

	@Override
	public void deleteOffersForOwnedCar(int offerId) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProfileWhenDuplicate(){
		// TODO Auto-generated method stub

	}

}
