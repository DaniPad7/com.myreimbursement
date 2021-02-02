package com.mydealership.dao;

import com.mydealership.exception.BusinessException;

public interface DealershipSetUpdateDAO {
	public int setOfferApproval() throws BusinessException;
	public int setCarOwnership() throws BusinessException;

}
