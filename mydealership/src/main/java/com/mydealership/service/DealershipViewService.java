package com.mydealership.service;

import com.mydealership.exception.BusinessException;

public interface DealershipViewService {
	public void login(String username, String password) throws BusinessException;
	public void viewAllCarsOnLot() throws BusinessException;
	public void viewOwnedCars() throws BusinessException;
	public void viewRemainingPayments() throws BusinessException;
	public void viewAllCustomerPayments() throws BusinessException;
	public void getMonthlyPayment() throws BusinessException;
	

}
