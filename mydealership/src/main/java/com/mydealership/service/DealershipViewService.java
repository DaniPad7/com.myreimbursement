package com.mydealership.service;

import java.util.List;

import com.mydealership.exception.BusinessException;
import com.mydealership.exception.EmptyQueryException;
import com.mydealership.exception.NullInfoException;
import com.mydealership.model.CarLot;
import com.mydealership.model.UserCorpInfo;
import com.mydealership.model.UsersTransactionHistory;

public interface DealershipViewService {
	public UserCorpInfo login(String username, String password) throws NullInfoException, EmptyQueryException;
	public List<CarLot> viewAllCarsOnLot() throws BusinessException, EmptyQueryException;
	public List<CarLot> viewOwnedCars(int userId) throws BusinessException;
	public List<UsersTransactionHistory> viewRemainingPayments(int userId, int carId) throws BusinessException;
	public List<UsersTransactionHistory> viewAllCustomerPayments(String username) throws BusinessException;
	public void getMonthlyPayment() throws BusinessException;
	

}
