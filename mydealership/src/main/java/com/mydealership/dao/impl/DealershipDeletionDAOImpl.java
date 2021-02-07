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
	public void deleteCarFromLot() throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteOffersForOwnedCar() throws BusinessException {
		// TODO Auto-generated method stub

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
