package com.mydealership.dao;

import com.mydealership.exception.BusinessException;

public interface DealershipSetUpdateDAO {
	public int setOfferApproval(int offerId) throws BusinessException;
	public int setCarOwnership(int offerId) throws BusinessException;

}
