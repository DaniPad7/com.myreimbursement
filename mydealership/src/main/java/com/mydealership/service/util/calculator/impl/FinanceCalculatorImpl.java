package com.mydealership.service.util.calculator.impl;

import com.mydealership.exception.BusinessException;
import com.mydealership.service.util.calculator.FinanceCalculator;

public class FinanceCalculatorImpl implements FinanceCalculator{

	@Override
	public double getAPR( float principal, int loanLength, int creditScore)
			throws BusinessException {
		float fees = 1500;
		float interest = (float) ((Math.random() * creditScore) - 1) * principal;
		double apr = (double) (((fees + interest)/(loanLength * principal)) * (365/30) * 100);
		return apr;
	}

}
