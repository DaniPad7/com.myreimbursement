package com.mydealership.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mydealership.dao.FinanceRetrieverDAO;
import com.mydealership.dao.dbutil.PostgresqlConnection;
import com.mydealership.exception.BusinessException;
import com.mydealership.exception.EmptyQueryException;
import com.mydealership.model.UserFinanceInfo;

public class FinanceRetrieverDAOImpl implements FinanceRetrieverDAO {
	private static Connection connection;

	@Override
	public UserFinanceInfo viewAcceptedOffer(int offerId) throws BusinessException, EmptyQueryException {
		UserFinanceInfo userFinanceInfo = null;
		connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = PostgresqlConnection.getConnection();
			final String sql = "SELECT offer_id , user_id_ph , car_id , principal_loan::money::numeric::float8 , loan_length , apr , credit_score ,is_accepted , offer_date FROM mydealership.user_finance__info WHERE offer_id = ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, offerId);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
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
		return userFinanceInfo;
	}

}
