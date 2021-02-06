package com.mydealership.service.util.factory.impl;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mydealership.exception.BusinessException;
import com.mydealership.model.CarLot;
import com.mydealership.model.UserCorpInfo;
import com.mydealership.service.util.factory.LoginFactory;

public class LoginFactoryImpl implements LoginFactory {
	public static Logger log = Logger.getLogger(UserFinanceInfoFactoryImpl.class);
	public Scanner scanner = new Scanner(System.in);
	UserCorpInfo userCredentials;

	@Override
	public void setLogin() throws BusinessException {
		this.userCredentials = new UserCorpInfo();
		int isReady0 = 0;
		do {
			log.info("_____________________Login____________________");
			log.info("1) Enter information");
			log.info("85) Back");
			try {
				isReady0 = Integer.parseInt(scanner.nextLine());
				}catch(NumberFormatException e) {}
			switch(isReady0){
			case 1:
				log.info("Please enter your username: ");
				userCredentials.setUsername(scanner.nextLine());
				log.info("Please enter your password: ");
				userCredentials.setPassword(scanner.nextLine());
				isReady0 = 85;
			case 85:
				log.info("Redirected back.");
				break;
			default:
				log.info("Invalid input. Please try again.");
				break;
			}
		}while(isReady0 != 85);

	}

	@Override
	public UserCorpInfo getLogIn() throws BusinessException {
		return userCredentials;
	}

}
