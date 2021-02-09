package com.mydealership.dao;

import java.util.List;

import com.mydealership.exception.BusinessException;
import com.mydealership.exception.EmptyQueryException;
import com.mydealership.exception.NullInfoException;
import com.mydealership.model.CarLot;
import com.mydealership.model.UserCorpInfo;
import com.mydealership.model.UserFinanceInfo;
import com.mydealership.model.UsersTransactionHistory;

public interface DealershipViewDAO {
	public UserCorpInfo login(String username, String password) throws NullInfoException, EmptyQueryException;
	public List<CarLot> viewAllCarsOnLot() throws BusinessException, EmptyQueryException;
	public List<CarLot> viewUnownedCarsOnLot() throws BusinessException, EmptyQueryException;
	public List<CarLot> viewOwnedCars(int userId) throws BusinessException, EmptyQueryException;
	List<UserFinanceInfo> viewAllOffers() throws BusinessException , EmptyQueryException;
	public List<UsersTransactionHistory> viewRemainingPayments(int userId, int carId) throws BusinessException, EmptyQueryException;
	public List<UsersTransactionHistory> viewAllCustomerPayments(String firstName, String lastName) throws BusinessException, EmptyQueryException;
	public void getMonthlyPayment() throws BusinessException;
	

}
