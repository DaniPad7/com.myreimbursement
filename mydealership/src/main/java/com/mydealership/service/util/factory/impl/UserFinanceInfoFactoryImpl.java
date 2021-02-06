package com.mydealership.service.util.factory.impl;

import java.sql.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mydealership.exception.BusinessException;
import com.mydealership.model.UserFinanceInfo;
import com.mydealership.service.util.calculator.FinanceCalculator;
import com.mydealership.service.util.calculator.impl.FinanceCalculatorImpl;
import com.mydealership.service.util.factory.UserFinanceInfoFactory;

public class UserFinanceInfoFactoryImpl implements UserFinanceInfoFactory{
	public static Logger log = Logger.getLogger(UserFinanceInfoFactoryImpl.class);
	public Scanner scanner = new Scanner(System.in);
	UserFinanceInfo userFinanceInfo;

	@Override
	public void setUserFinanceInfo() throws BusinessException {
		this.userFinanceInfo = new UserFinanceInfo();
		int isReady0 = 0;
		do {
			log.info("_____________Welcome Customer___________");
			log.info("1) Enter Finance Information");
			log.info("65) Back");
			try {
				isReady0 = Integer.parseInt(scanner.nextLine());
				}catch(NumberFormatException e) {}
			switch(isReady0) {
			case 1:
				int runSwitch0 = 1;
				int i = 0;
				switch(runSwitch0) {
				//userFinanceInfo.setAccepted(false);
				
				//do a get of the car lot for the car id. probably store in main
				//log.info("Doing something with car id");
				
				//log.info("Doing something with user_id ");
				// do a get for user personal info for user id. probably store in main, nothing can be null
				
				//log.info("Do something with Date where it is automated.");
				// use date util most likely
				case 1:
					while(i < 1) {
						log.info("Enter your Principal loan amount: ");
						float principalValidator = Float.parseFloat(scanner.nextLine());
						if(principalValidator < 100_000 && principalValidator > 0) {
							userFinanceInfo.setPrincipalLoan(principalValidator);
							i = 1;
						}
						else {
							log.info("Amount is out of bounds. Please try again.");
						}
					}
					
					 
				case 2:
					while(i < 2) {
						log.info("Enter your Loan Length: ");
						userFinanceInfo.setLoanLength(Integer.parseInt(scanner.nextLine()));
						if(userFinanceInfo.getLoanLength() < 1 || userFinanceInfo.getLoanLength() > 84) {
							i = 2;
						}
						else {
							log.info("Choose between 1 and 84 months. Please try again.");
						}
					}
						
				case 3:
					while(i < 3) {
						log.info("Enter your Loan Length: ");
						userFinanceInfo.setCreditScore(Integer.parseInt(scanner.nextLine()));
						if(userFinanceInfo.getCreditScore() < 1 || userFinanceInfo.getCreditScore() > 850) {
							i = 3;
						}
						else {
							log.info("Your credit score is out of bounds. Please try again.");
						}
					}
						
				case 4:
					while(i < 4) {
						log.info("Your APR will be: ");
						FinanceCalculator calc = new FinanceCalculatorImpl();
						double apr = calc.getAPR(userFinanceInfo.getPrincipalLoan(), userFinanceInfo.getLoanLength(), userFinanceInfo.getCreditScore());
						log.info(apr);
							i = 4;
							isReady0 = 65;
						}	
				}
				
			case 65:
				log.info("Redirected back.");
				break;
			default:
				log.info("Invalid input. Please try again.");
				break;
				}
		
			
		}while(isReady0 != 65);
		
	}

	@Override
	public UserFinanceInfo getUserFinanceInfo() throws BusinessException {
		return userFinanceInfo;
		
	}

}
