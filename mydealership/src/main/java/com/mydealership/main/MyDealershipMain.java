package com.mydealership.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mydealership.exception.BusinessException;
import com.mydealership.factory.impl.UserPersonalInfoFactoryImpl;
import com.mydealership.service.DealershipInsertService;
import com.mydealership.service.impl.DealershipInsertServiceImpl;

public class MyDealershipMain {
	public static Logger log = Logger.getLogger(MyDealershipMain.class);
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DealershipInsertService dealershipInsertService = new DealershipInsertServiceImpl();
		
		UserPersonalInfoFactoryImpl userPersonalInfoFactory = new UserPersonalInfoFactoryImpl();
		
		int starterOption = 0;
		do {
			log.info("___________Hello, Welcome to MyDealership__________________");
			log.info("What would you like to do today...");
				log.info("Login Or Sign Up");
				log.info("1) Login");
				log.info("2) Sign Up");
				log.info("26) Exit");
				try {
					starterOption = Integer.parseInt(scanner.nextLine());
					}catch(NumberFormatException e) {}
				switch(starterOption) {
				case 1:
					log.info("Option under construction");
					break;
				case 2:
					try {
						userPersonalInfoFactory.setUserPersonalInfoAndUserCorpInfoGetFormer();//look into impl it is bugged
						log.info(userPersonalInfoFactory.getUserCorpInfo());
					} catch (BusinessException e) {
						
						e.printStackTrace();
					}
					break;
				case 26:
					log.info("Thank you and have a nice day.");
					break;
				default:
					log.info("Invalid input. Please try again.");
					break;
					}
				}while(starterOption != 26);
		scanner.close();

	}

}
