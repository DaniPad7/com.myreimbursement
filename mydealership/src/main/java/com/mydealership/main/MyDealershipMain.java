package com.mydealership.main;

import java.util.NoSuchElementException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mydealership.exception.BusinessException;
import com.mydealership.exception.EmptyQueryException;
import com.mydealership.exception.NullInfoException;
import com.mydealership.model.UserCorpInfo;
import com.mydealership.service.DealershipInsertService;
import com.mydealership.service.DealershipViewService;
import com.mydealership.service.impl.DealershipInsertServiceImpl;
import com.mydealership.service.impl.DealershipViewServiceImpl;
import com.mydealership.service.util.factory.CarLotFactory;
import com.mydealership.service.util.factory.CustomerFunctionsFactory;
import com.mydealership.service.util.factory.EmployeeFunctionsFactory;
import com.mydealership.service.util.factory.LoginFactory;
import com.mydealership.service.util.factory.PersonalInfoFactory;
import com.mydealership.service.util.factory.UserFinanceInfoFactory;
import com.mydealership.service.util.factory.impl.CarLotFactoryImpl;
import com.mydealership.service.util.factory.impl.CustomerFunctionsFactoryImpl;
import com.mydealership.service.util.factory.impl.EmployeeFunctionsFactoryImpl;
import com.mydealership.service.util.factory.impl.LoginFactoryImpl;
import com.mydealership.service.util.factory.impl.UserFinanceInfoFactoryImpl;
import com.mydealership.service.util.factory.impl.UserPersonalInfoFactoryImpl;

public class MyDealershipMain {
	public static Logger log = Logger.getLogger(MyDealershipMain.class);
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DealershipInsertService dealershipInsertService = new DealershipInsertServiceImpl();
		DealershipViewService dealershipViewService = new DealershipViewServiceImpl();
		
		PersonalInfoFactory userPersonalInfoFactory = new UserPersonalInfoFactoryImpl();
		//UserFinanceInfoFactory userFinancefactoryImpl = new UserFinanceInfoFactoryImpl();
		LoginFactory loginFactoryImpl = new LoginFactoryImpl();
		CustomerFunctionsFactory customerFunctionsFactoryImpl = new CustomerFunctionsFactoryImpl();
		EmployeeFunctionsFactory employeeFunctionsFactory = new EmployeeFunctionsFactoryImpl();
		
		
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
					}catch(NumberFormatException |NoSuchElementException e) {
						log.info(e.getMessage());
					}
				switch(starterOption) {
				case 1:
					try {
						loginFactoryImpl.setLogin();
						UserCorpInfo userCorpInfoRetrieved = dealershipViewService.login(loginFactoryImpl.getLogIn().getUsername(), loginFactoryImpl.getLogIn().getPassword());// this one throws NullInfoException
						if(userCorpInfoRetrieved.isEmployee() == false) {
							customerFunctionsFactoryImpl.customerFunctions(userCorpInfoRetrieved.getUserId());
						}
						else if(userCorpInfoRetrieved.isEmployee() == true){
							employeeFunctionsFactory.employeeFunctions(userCorpInfoRetrieved.getUserId());
						}
						else {}
					} catch (BusinessException | NullInfoException | EmptyQueryException e1) {
						log.info(e1.getMessage());
					}
					break;
				case 2:
					try {
						userPersonalInfoFactory.setUserPersonalInfoAndUserCorpInfo();
						dealershipInsertService.registerCustomerAccount(userPersonalInfoFactory.getUserPersonalInfo(), userPersonalInfoFactory.getUserCorpInfo());// this one throws NullInfoException
					} catch (BusinessException | NullInfoException e) {
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
//Date.valueOf(LocalDate.now())
	}

}
