package com.mydealership.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	public List<CarLot> viewAllCarsOnLot() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
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
