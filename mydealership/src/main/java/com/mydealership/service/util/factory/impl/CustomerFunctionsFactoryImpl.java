package com.mydealership.service.util.factory.impl;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mydealership.exception.BusinessException;
import com.mydealership.service.util.factory.CustomerFunctionsFactory;

public class CustomerFunctionsFactoryImpl implements CustomerFunctionsFactory {
	public static Logger log = Logger.getLogger(UserFinanceInfoFactoryImpl.class);
	public Scanner scanner = new Scanner(System.in);

	@Override
	public void customerFunctions(int userId) throws BusinessException {
		int isReady0 = 0;
		//do a get method here with user id for name
		do {
			log.info("Hello ! As a customer, what would you like to do today. ");
			log.info("1) View All Cars on the Lot");
			log.info("2) Submit a Financing Offer");
			log.info("3) View your Own Cars");
			log.info("4) View Your Remaining Payments");
			log.info("95) Sign Out");
			try {
				isReady0 = Integer.parseInt(scanner.nextLine());
			}catch(NumberFormatException e) {}
			switch(isReady0) {
			case 1:
				log.info("This option is under construction.");
				break;
				
			case 2:
				log.info("This option is under construction.");
				break;
				
			case 3:
				log.info("This option is under construction.");
				break;
				
			case 4:
				log.info("This option is under construction.");
				break;
				
			case 95:
				log.info("You signed out.");
				break;
				
			default:
				log.info("Invalid input from customer. Please try again.");
				break;
			
			}
			
		}while(isReady0 != 95);

	}

}
