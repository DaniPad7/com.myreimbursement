package com.mydealership.service;

import com.mydealership.exception.BusinessException;

public interface DealershipSetUpdateService {
	public int setOfferApproval() throws BusinessException;
	public int setCarOwnership() throws BusinessException;

}
