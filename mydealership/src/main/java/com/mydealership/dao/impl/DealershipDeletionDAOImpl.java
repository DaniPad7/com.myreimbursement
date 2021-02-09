package com.mydealership.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mydealership.dao.DealershipDeletionDAO;
import com.mydealership.dao.dbutil.PostgresqlConnection;
import com.mydealership.exception.BusinessException;

public class DealershipDeletionDAOImpl implements DealershipDeletionDAO {
	private static Connection connection;

	@Override
	public void deleteCarFromLot(int carId) throws BusinessException {
		connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = PostgresqlConnection.getConnection();
			final String sql = "delete from mydealership.car_lot where car_id = ?;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, carId);
			preparedStatement.executeUpdate();
			connection.close();
			preparedStatement.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOffersForOwnedCar(int offerId) throws BusinessException {
		connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = PostgresqlConnection.getConnection();
			final String sql = "delete from mydealership.user_finance__info where car_id in (select car_id from mydealership.user_finance__info where offer_id = ?) and is_accepted = false;";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, offerId);
			preparedStatement.executeUpdate();
			connection.close();
			preparedStatement.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProfileWhenDuplicate() {
		connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = PostgresqlConnection.getConnection();
			final String sql = "DELETE FROM mydealership.user_personal_info WHERE  user_id IN"
					+ "(SELECT MAX(user_id) FROM mydealership.user_personal_info);";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			connection.close();
			preparedStatement.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
			
	}

}
