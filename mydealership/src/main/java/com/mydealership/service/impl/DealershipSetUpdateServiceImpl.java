package com.mydealership.service.impl;

import org.apache.log4j.Logger;

import com.mydealership.dao.DealershipDeletionDAO;
import com.mydealership.dao.DealershipInsertDAO;
import com.mydealership.dao.DealershipSetUpdateDAO;
import com.mydealership.dao.impl.DealershipDeletionDAOImpl;
import com.mydealership.dao.impl.DealershipInsertDAOImpl;
import com.mydealership.dao.impl.DealershipSetUpdateDAOImpl;
import com.mydealership.exception.BusinessException;
import com.mydealership.exception.EmptyQueryException;
import com.mydealership.exception.NullInfoException;
import com.mydealership.service.DealershipSetUpdateService;
import com.mydealership.service.util.factory.UsersTransactionHistoryFactory;
import com.mydealership.service.util.factory.impl.UsersTransactionHistoryFactoryImpl;

public class DealershipSetUpdateServiceImpl implements DealershipSetUpdateService {
	public static Logger log = Logger.getLogger(DealershipSetUpdateServiceImpl.class);
	
	private DealershipSetUpdateDAO dealershipSetUpdateDAO = new DealershipSetUpdateDAOImpl();
	private DealershipDeletionDAO dealershipDeletionDAO = new DealershipDeletionDAOImpl();
	private DealershipInsertDAO dealershipInsertDAO = new DealershipInsertDAOImpl();
	public UsersTransactionHistoryFactory usersTransactionHistoryFactory = new UsersTransactionHistoryFactoryImpl();

	@Override
	public int setOfferApproval(int offerId) throws BusinessException, EmptyQueryException, NullInfoException {
		int updated = 0;
		updated = dealershipSetUpdateDAO.setOfferApproval(offerId);
		if(updated == 0) {
			log.info("Offer update failed.");
		}
		else if(updated != 0) {
			dealershipDeletionDAO.deleteOffersForOwnedCar(offerId);
			dealershipSetUpdateDAO.setCarOwnership(offerId);
			usersTransactionHistoryFactory.setUsersTransactionHistory(offerId);
			dealershipInsertDAO.createFirstTransaction(usersTransactionHistoryFactory.getUsersTransactionHistory());
		}
		else {}
		return updated;
	}

	@Override
	public int setCarOwnership(int offerId) throws BusinessException {
		int updated1= 0;
		updated1 = dealershipSetUpdateDAO.setCarOwnership(offerId);
		if(updated1 == 0) {
			log.info("Offer update failed.");
		}
		else {}
		return updated1;
	}

}
