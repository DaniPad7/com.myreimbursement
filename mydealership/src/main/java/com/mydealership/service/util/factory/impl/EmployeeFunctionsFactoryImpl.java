package com.mydealership.service.util.factory.impl;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mydealership.exception.BusinessException;
import com.mydealership.exception.NullInfoException;
import com.mydealership.service.DealershipInsertService;
import com.mydealership.service.impl.DealershipInsertServiceImpl;
import com.mydealership.service.util.factory.CarLotFactory;
import com.mydealership.service.util.factory.EmployeeFunctionsFactory;

public class EmployeeFunctionsFactoryImpl implements EmployeeFunctionsFactory {
	public static Logger log = Logger.getLogger(UserFinanceInfoFactoryImpl.class);
	public Scanner scanner = new Scanner(System.in);
	
	DealershipInsertService dealershipInsertService = new DealershipInsertServiceImpl();
	
	CarLotFactory carLotFactoryImpl = new CarLotFactoryImpl();

	@Override
	public void employeeFunctions(int userId) throws BusinessException, NullInfoException {
		int isReady0 = 0;
		//do a get method here with user id for name
		do {
			log.info("Hello ! As an employee, what would you like to do today. ");
			log.info("1) Add a Vehicle to the Lot");
			log.info("2) Approve a Financing Offer");
			log.info("3) Delete a Vehicle From the Lot");
			log.info("4) View Customer Payments By...");
			log.info("35) Sign Out");
			try {
				isReady0 = Integer.parseInt(scanner.nextLine());
			}catch(NumberFormatException e) {}
			switch(isReady0) {
			case 1:
				carLotFactoryImpl.setCar();
				dealershipInsertService.addCar(carLotFactoryImpl.getCar());
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
				
			case 35:
				log.info("You signed out.");
				break;
				
			default:
				log.info("Invalid input from employee. Please try again.");
				break;
			
			}
			
		}while(isReady0 != 35);

	}

}
