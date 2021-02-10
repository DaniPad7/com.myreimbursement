package com.mydealership.service;

import com.mydealership.exception.BusinessException;
import com.mydealership.exception.EmptyQueryException;
import com.mydealership.exception.NullInfoException;

public interface DealershipSetUpdateService {
	public int setOfferApproval(int offerId) throws BusinessException, EmptyQueryException, NullInfoException;
	public int setCarOwnership(int offerId) throws BusinessException;

}
