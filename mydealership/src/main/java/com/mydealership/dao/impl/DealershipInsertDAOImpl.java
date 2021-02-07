package com.mydealership.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mydealership.dao.DealershipDeletionDAO;
import com.mydealership.dao.DealershipInsertDAO;
import com.mydealership.dao.dbutil.PostgresqlConnection;
import com.mydealership.exception.BusinessException;
import com.mydealership.exception.NullInfoException;
import com.mydealership.model.CarLot;
import com.mydealership.model.UserCorpInfo;
import com.mydealership.model.UserFinanceInfo;
import com.mydealership.model.UserPersonalInfo;

public class DealershipInsertDAOImpl implements DealershipInsertDAO {
	private static Connection connection; 
	private DealershipDeletionDAO dealershipDeletionDAO  = new DealershipDeletionDAOImpl();

	@Override
	public int registerCustomerAccount(UserPersonalInfo userPersonalInfo, UserCorpInfo userCorporateInfo)
			throws BusinessException, NullInfoException {
		int registered0 = 0;
		int registered1 = 0;
		connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = PostgresqlConnection.getConnection();
			final String sql0 = "INSERT INTO mydealership.user_personal_info(user_id, first_name, last_name, birth_date, email, phone_number, address, city, state, zip_code, country) "
					+ "VALUES(DEFAULT, ?, ?, ?, ? , ?, ?, ?, ?, ?, ?);";
			final String sql1 = "INSERT INTO mydealership.user_corp_info(user_id, username, password, is_employee) VALUES(DEFAULT, ?, ?, ?);";
			preparedStatement = connection.prepareStatement(sql0);
			preparedStatement.setString(1, userPersonalInfo.getFirstName());
			preparedStatement.setString(2, userPersonalInfo.getLastName());
			preparedStatement.setDate(3, userPersonalInfo.getBirthDate());
			preparedStatement.setString(4, userPersonalInfo.getEmail());
			preparedStatement.setString(5, userPersonalInfo.getPhoneNumber());
			preparedStatement.setString(6, userPersonalInfo.getAddress());
			preparedStatement.setString(7, userPersonalInfo.getCity());
			preparedStatement.setString(8, userPersonalInfo.getState());
			preparedStatement.setString(9, userPersonalInfo.getZipCode());
			preparedStatement.setString(10, userPersonalInfo.getCountry());
			registered0 = preparedStatement.executeUpdate();
			preparedStatement.close();
			
			preparedStatement = connection.prepareStatement(sql1);
			preparedStatement.setString(1, userCorporateInfo.getUsername());
			preparedStatement.setString(2, userCorporateInfo.getPassword());
			preparedStatement.setBoolean(3, userCorporateInfo.isEmployee());
			registered1 = preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
				dealershipDeletionDAO.deleteProfileWhenDuplicate();
		}finally {
			try {
				connection.close();
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return registered0 + registered1;
	}

	@Override
	public int makeCarOffer(UserFinanceInfo userFinanceInfo) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addCar(CarLot carLot) throws BusinessException, NullInfoException {
		int registered = 0;
		connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = PostgresqlConnection.getConnection();
			final String sql = "INSERT INTO mydealership.car_lot(car_id, is_owned, user_id, car_maker, car_type, car_model, car_color, car_year, is_new, odometer_reading, price) "
					+ "VALUES (DEFAULT, ?, NULL, ?, ?, ?, ?, ?, ?, ?, ?::float8::numeric::money)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setBoolean(1, carLot.isOwned());
			preparedStatement.setString(2, carLot.getCarMaker());
			preparedStatement.setString(3, carLot.getCarType());
			preparedStatement.setString(4, carLot.getCarModel());
			preparedStatement.setString(5, carLot.getCarColor());
			preparedStatement.setString(6, carLot.getCarYear());
			preparedStatement.setBoolean(7, carLot.isNew());
			preparedStatement.setInt(8, carLot.getOdometerReading());
			preparedStatement.setFloat(9, carLot.getPrice());
			registered = preparedStatement.executeUpdate();
			
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
		return registered;
	}

}
