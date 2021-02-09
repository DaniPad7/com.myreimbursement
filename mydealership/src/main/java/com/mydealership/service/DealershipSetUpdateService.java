package com.mydealership.service;

import com.mydealership.exception.BusinessException;
import com.mydealership.exception.EmptyQueryException;

public interface DealershipSetUpdateService {
	public int setOfferApproval(int offerId) throws BusinessException, EmptyQueryException;
	public int setCarOwnership(int offerId) throws BusinessException;

}
