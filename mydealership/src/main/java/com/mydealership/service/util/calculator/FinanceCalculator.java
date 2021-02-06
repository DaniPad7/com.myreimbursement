package com.mydealership.service.util.calculator;

import com.mydealership.exception.BusinessException;

public interface FinanceCalculator {
	double getAPR(float principal, int loanLength, int creditScore) throws BusinessException;
	

}
