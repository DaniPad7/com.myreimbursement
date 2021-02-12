package com.mydealership.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mydealership.dao.DealershipDeletionDAO;
import com.mydealership.dao.DealershipSetUpdateDAO;
import com.mydealership.dao.dbutil.PostgresqlConnection;
import com.mydealership.exception.BusinessException;
import com.mydealership.exception.EmptyQueryException;
import com.mydealership.exception.NullInfoException;

public class DealershipSetUpdateDAOImpl implements DealershipSetUpdateDAO {
	private static Connection connection;
	

	@Override
	public int setOfferApproval(int offerId) throws BusinessException, EmptyQueryException, NullInfoException {
		int updated = 0;
		connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = PostgresqlConnection.getConnection();
			final String sql = "update mydealership.user_finance__info set is_accepted = true where offer_id = ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, offerId);
			updated = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return updated;
	}

	@Override
	public int setCarOwnership(int offerId) throws BusinessException {
		int updated1 = 0;
		int updated2 = 0;
		connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement1 = null;
		try {
			connection = PostgresqlConnection.getConnection();
			final String sql = "update mydealership.car_lot set is_owned = true where car_id in (select car_id from mydealership.user_finance__info where offer_id = ?);";
			final String sql1 = "update mydealership.car_lot set user_id = (select user_id_ph from mydealership.user_finance__info where offer_id = ?) where car_id in (select car_id from mydealership.user_finance__info where offer_id = ?);";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, offerId);
			updated1 = preparedStatement.executeUpdate();
			preparedStatement1 = connection.prepareStatement(sql1);
			preparedStatement1.setInt(1, offerId);
			preparedStatement1.setInt(2, offerId);
			updated2 = preparedStatement1.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
				preparedStatement.close();
				preparedStatement1.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return updated1;
	}

}
