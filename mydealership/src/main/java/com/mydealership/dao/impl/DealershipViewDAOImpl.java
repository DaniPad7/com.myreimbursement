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
		List<CarLot> carsOnLotNotOwned = new ArrayList<>();;
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
	public List<CarLot> viewOwnedCars(int userId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsersTransactionHistory> viewRemainingPayments(int userId, int carId) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsersTransactionHistory> viewAllCustomerPayments(String username) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getMonthlyPayment() throws BusinessException {
		// TODO Auto-generated method stub

	}

}
