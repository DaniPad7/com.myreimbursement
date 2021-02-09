package com.mydealership.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mydealership.dao.DealershipViewDAO;
import com.mydealership.dao.dbutil.PostgresqlConnection;
import com.mydealership.exception.BusinessException;
import com.mydealership.exception.EmptyQueryException;
import com.mydealership.exception.NullInfoException;
import com.mydealership.model.CarLot;
import com.mydealership.model.UserCorpInfo;
import com.mydealership.model.UserFinanceInfo;
import com.mydealership.model.UsersTransactionHistory;

public class DealershipViewDAOImpl implements DealershipViewDAO {
	private static Connection connection; 

	@Override
	public UserCorpInfo login(String username, String password) throws NullInfoException, EmptyQueryException {
		UserCorpInfo userCorpInfoRetrieved = null;
		connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = PostgresqlConnection.getConnection();
			final String sql = "SELECT * FROM mydealership.user_corp_info WHERE username = ? AND password = ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				userCorpInfoRetrieved = new UserCorpInfo();
				userCorpInfoRetrieved.setUserId(resultSet.getInt("user_id"));
				userCorpInfoRetrieved.setEmployee(resultSet.getBoolean("is_employee"));
				}
			else {
				throw new EmptyQueryException("No data found.");
			}
			} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return userCorpInfoRetrieved;
	}

	@Override
	public List<CarLot> viewAllCarsOnLot() throws BusinessException, EmptyQueryException {
		List<CarLot> carsOnLotNotOwned = new ArrayList<>();
		connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		CarLot carLot;
		try {
			connection = PostgresqlConnection.getConnection();
			final String sql = "SELECT car_id, is_owned, user_id, car_maker, car_type, car_model, car_color, car_year, is_new, odometer_reading, price::money::numeric::float8 FROM mydealership.car_lot;";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				carLot = new CarLot();
				carLot.setCarId(resultSet.getInt("car_id"));
				carLot.setCarMaker(resultSet.getString("car_maker"));
				carLot.setCarType(resultSet.getString("car_type"));
				carLot.setCarModel(resultSet.getString("car_model"));
				carLot.setCarColor(resultSet.getString("car_color"));
				carLot.setCarYear(resultSet.getString("car_year"));
				carLot.setNew(resultSet.getBoolean("is_new"));
				carLot.setOdometerReading(resultSet.getInt("odometer_reading"));
				carLot.setPrice(resultSet.getFloat("price"));
				carsOnLotNotOwned.add(carLot);
				}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return carsOnLotNotOwned;
	}
	
	@Override
	public List<CarLot> viewUnownedCarsOnLot() throws BusinessException, EmptyQueryException {
		List<CarLot> carsNotOwned = new ArrayList<>();
		connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		CarLot carLot;
		try {
			connection = PostgresqlConnection.getConnection();
			final String sql = "SELECT car_id, is_owned, user_id, car_maker, car_type, car_model, car_color, car_year, is_new, odometer_reading, price::money::numeric::float8 FROM mydealership.car_lot "
					+ "WHERE car_id NOT IN (SELECT car_id FROM mydealership.user_finance__info WHERE offer_id IS NOT NULL);";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				carLot = new CarLot();
				carLot.setCarId(resultSet.getInt("car_id"));
				carLot.setCarMaker(resultSet.getString("car_maker"));
				carLot.setCarType(resultSet.getString("car_type"));
				carLot.setCarModel(resultSet.getString("car_model"));
				carLot.setCarColor(resultSet.getString("car_color"));
				carLot.setCarYear(resultSet.getString("car_year"));
				carLot.setNew(resultSet.getBoolean("is_new"));
				carLot.setOdometerReading(resultSet.getInt("odometer_reading"));
				carLot.setPrice(resultSet.getFloat("price"));
				carsNotOwned.add(carLot);
				}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return carsNotOwned;
	}

	@Override
	public List<CarLot> viewOwnedCars(int userId) throws BusinessException, EmptyQueryException {
		List<CarLot> ownedCars = new ArrayList<>();
		connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		CarLot carLot;
		try {
			connection = PostgresqlConnection.getConnection();
			final String sql = "SELECT car_id, is_owned, user_id, car_maker, car_type, car_model, car_color, car_year, is_new, odometer_reading, price::money::numeric::float8 FROM mydealership.car_lot "
					+ "WHERE user_id = ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				carLot = new CarLot();
				carLot.setCarId(resultSet.getInt("car_id"));
				carLot.setCarMaker(resultSet.getString("car_maker"));
				carLot.setCarType(resultSet.getString("car_type"));
				carLot.setCarModel(resultSet.getString("car_model"));
				carLot.setCarColor(resultSet.getString("car_color"));
				carLot.setCarYear(resultSet.getString("car_year"));
				carLot.setNew(resultSet.getBoolean("is_new"));
				carLot.setOdometerReading(resultSet.getInt("odometer_reading"));
				carLot.setPrice(resultSet.getFloat("price"));
				ownedCars.add(carLot);
				}
			} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ownedCars;
	}
	
	@Override
	public List<UserFinanceInfo> viewAllOffers() throws BusinessException, EmptyQueryException {
		List<UserFinanceInfo> offersNotAccepted = new ArrayList<>();
		connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		UserFinanceInfo userFinanceInfo;
		try {
			connection = PostgresqlConnection.getConnection();
			final String sql = "select offer_id , user_id_ph , car_id , principal_loan::money::numeric::float8 , loan_length , apr , credit_score ,is_accepted , offer_date from mydealership.user_finance__info ufi ;";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				userFinanceInfo = new UserFinanceInfo();
				userFinanceInfo.setOfferId(resultSet.getInt("offer_id"));
				userFinanceInfo.setUserId(resultSet.getInt("user_id_ph"));
				userFinanceInfo.setCarId(resultSet.getInt("car_id"));
				userFinanceInfo.setPrincipalLoan(resultSet.getFloat("principal_loan"));
				userFinanceInfo.setLoanLength(resultSet.getInt("loan_length"));
				userFinanceInfo.setApr(resultSet.getDouble("apr"));
				userFinanceInfo.setCreditScore(resultSet.getInt("credit_score"));
				userFinanceInfo.setAccepted(resultSet.getBoolean("is_accepted"));
				userFinanceInfo.setOfferDate(resultSet.getDate("offer_date"));
				offersNotAccepted.add(userFinanceInfo);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return offersNotAccepted;
	}

	@Override
	public List<UsersTransactionHistory> viewRemainingPayments(int userId, int carId) throws BusinessException, EmptyQueryException {
		List<UsersTransactionHistory> carRemainingPayments = new ArrayList<>();
		connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		UsersTransactionHistory usersTransactionHistory;
		try {
			connection = PostgresqlConnection.getConnection();
			final String sql = "SELECT transaction_id, user_id, car_id, amount::money::numeric::float8, remaining_balance::money::numeric::float8, next_payment::money::numeric::float8, transaction_date, payments_left FROM mydealership.users_transaction_history "
					+ "WHERE user_id = ? AND car_id = ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, userId);
			preparedStatement.setInt(2, carId);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				usersTransactionHistory = new UsersTransactionHistory();
				usersTransactionHistory.setTransactionId(resultSet.getInt("transaction_id"));
				usersTransactionHistory.setUserId(resultSet.getInt("user_id"));
				usersTransactionHistory.setCarId(resultSet.getInt("car_id"));
				usersTransactionHistory.setAmount(resultSet.getFloat("amount"));
				usersTransactionHistory.setRemainingBalance(resultSet.getFloat("remaining_balance"));
				usersTransactionHistory.setNextPayment(resultSet.getFloat("next_payment"));
				usersTransactionHistory.setTransactionDate(resultSet.getDate("transaction_date"));
				usersTransactionHistory.setPaymentsLeft(resultSet.getInt("payments_left"));
				carRemainingPayments.add(usersTransactionHistory);
				}
			} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return carRemainingPayments;
	}

	@Override
	public List<UsersTransactionHistory> viewAllCustomerPayments(String firstName, String lastName) throws BusinessException, EmptyQueryException {
		List<UsersTransactionHistory> customerTransactions = new ArrayList<>();
		connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		UsersTransactionHistory usersTransactionHistory;
		try {
			connection = PostgresqlConnection.getConnection();
			final String sql = "SELECT transaction_id, user_id, car_id, amount::money::numeric::float8, remaining_balance::money::numeric::float8, next_payment::money::numeric::float8, transaction_date, payments_left FROM mydealership.users_transaction_history "
					+ "WHERE user_id IN (SELECT user_id FROM mydealership.user_personal_info WHERE first_name = ? and last_name = ?);";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				usersTransactionHistory = new UsersTransactionHistory();
				usersTransactionHistory.setTransactionId(resultSet.getInt("transaction_id"));
				usersTransactionHistory.setUserId(resultSet.getInt("user_id"));
				usersTransactionHistory.setCarId(resultSet.getInt("car_id"));
				usersTransactionHistory.setAmount(resultSet.getFloat("amount"));
				usersTransactionHistory.setRemainingBalance(resultSet.getFloat("remaining_balance"));
				usersTransactionHistory.setNextPayment(resultSet.getFloat("next_payment"));
				usersTransactionHistory.setTransactionDate(resultSet.getDate("transaction_date"));
				usersTransactionHistory.setPaymentsLeft(resultSet.getInt("payments_left"));
				customerTransactions.add(usersTransactionHistory);
				}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return customerTransactions;
	}

	@Override
	public void getMonthlyPayment() throws BusinessException {
		// TODO Auto-generated method stub

	}

	

	

}
