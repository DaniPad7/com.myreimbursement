package com.mydealership.service.util.factory.impl;

import java.sql.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mydealership.exception.BusinessException;
import com.mydealership.model.UserCorpInfo;
import com.mydealership.model.UserPersonalInfo;
import com.mydealership.service.util.factory.PersonalInfoFactory;

public class UserPersonalInfoFactoryImpl implements PersonalInfoFactory{
	public static Logger log = Logger.getLogger(UserPersonalInfoFactoryImpl.class);
	public Scanner scanner = new Scanner(System.in);
	
	private UserPersonalInfo userPersonalInfo;
	private UserCorpInfo userCorporateInfo;

	@Override
	public void setUserPersonalInfoAndUserCorpInfo() throws BusinessException {
		this.userPersonalInfo = new UserPersonalInfo();
		this.userCorporateInfo = new UserCorpInfo();
		int signUpOption = 0;
		do {
			log.info("__________________Sign Up_________________");
			log.info("What would you like to sign up as:");
			log.info("1) Customer");
			log.info("2) Employee");
			log.info("55) Back");
			try {
				signUpOption = Integer.parseInt(scanner.nextLine());
				}catch(NumberFormatException e) {}
			switch(signUpOption) {
			case 1:
				userCorporateInfo.setEmployee(false);
				int isReady0 = 0;
				do {
					log.info("_____________Welcome Customer___________");
					log.info("1) Enter Personal Information");
					log.info("54) Back");
					try {
						isReady0 = Integer.parseInt(scanner.nextLine());
						}catch(NumberFormatException e) {}
					switch(isReady0) {
					case 1:
						int runSwitch0 = 1;
						int i = 0;
						switch(runSwitch0) {
						case 1:
							while(i < 1) {
								log.info("Enter your First Name: ");
								userPersonalInfo.setFirstName(scanner.nextLine());
								if(userPersonalInfo.getFirstName().matches("^[a-zA-Z]+$")) {
									i = 1;
								}
								else {
									log.info("First name is Alphabetical. Please try again.");
								}
							}
						case 2:
							while(i < 2) {
								log.info("Enter your Last Name: ");
								userPersonalInfo.setLastName(scanner.nextLine());
								if(userPersonalInfo.getLastName().matches("^[a-zA-Z]+$")) {
									i = 2;
								}
								else {
									log.info("Last name is Alphabetical. Please try again.");
								}
							}
						case 3:
								while(i < 3) {
								log.info("Enter your birthdate: ");
								String dateValidator = scanner.nextLine();
								if(dateValidator.matches("^[12]{1}[89012]{1}[0-9]{1}[0-9]{1}-[01]{1}[0-9]{1}-[0123]{1}[0-9]{1}+$")) {
									userPersonalInfo.setBirthDate(Date.valueOf(dateValidator));
									i = 3;
								}
								else {
									log.info("Try the format \"yyyy-mm-dd\". Please try again.");
								}
							}
							case 4:
								while(i < 4) {
									log.info("Enter your phone number: ");
									userPersonalInfo.setPhoneNumber(scanner.nextLine());
									if(userPersonalInfo.getPhoneNumber().matches("^[0-9]{3}-[0-9]{3}-[0-9]{4}+$") || userPersonalInfo.getPhoneNumber().isEmpty()) {
										i = 4;
									}
									else {
										log.info("Try the format \"000-000-0000\". Please try again.");
									}
								}
						case 5:
							while(i < 5) {
								log.info("Enter your email: ");
								userPersonalInfo.setEmail(scanner.nextLine());
								if(userPersonalInfo.getEmail().matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$") || userPersonalInfo.getEmail().isEmpty() || userPersonalInfo.getEmail() == null) {
									i = 5;
								}
								else {
									log.info("For example /'example12@gmail.com'/. Please try again.");
								}
							}
						case 6:
							while(i < 6) {
								log.info("Enter your Country:");
								log.info("1) USA");
								userPersonalInfo.setCountry(scanner.nextLine());
								if(userPersonalInfo.getCountry().matches("USA")) {
									i = 6;
								}
								else {
									log.info("Please enter /'USA'/");
								}
							}
						case 7:
							while(i < 7) {
								log.info("Enter your home address: ");
								userPersonalInfo.setAddress(scanner.nextLine());
								if(userPersonalInfo.getAddress().matches("[a-zA-Z0-9 ]{2,10} [a-zA-Z0-9 ]{2,40}")) {
									i = 7;
								}
								else {
									log.info("Invalid input. Please try again.");
								}
							}
							case 8:
								while(i < 8) {
									log.info("Enter your home city: ");
									userPersonalInfo.setCity(scanner.nextLine());
									if(userPersonalInfo.getCity().matches("[a-zA-Z ]{2,10}")) {
										i = 8;
									}
									else {
										log.info("Invalid input. Please try again.");
									}
								}
						case 9:
							while(i < 9) {
								log.info("Enter your home state: ");
								userPersonalInfo.setState(scanner.nextLine());
								if(userPersonalInfo.getState().matches("^[A-Z]{2}+$")) {
									i = 9;
								}
								else {
									log.info("Try the Format \"AA\". Please try again.");
								}
							}
						case 10:
							while(i < 10) {
								log.info("Enter your home zipcode: ");
								userPersonalInfo.setZipCode(scanner.nextLine());
								if(userPersonalInfo.getZipCode().matches("^[0-9]{5}+$")) {
									i = 10;
									log.info("Great! Now you can create a Username and Password.");
								}
								else {
									log.info("Try the format /'00000'/. Please try again.");
								}
							}
						case 11:
							while(i < 11) {
								log.info("Enter your password: ");
								userCorporateInfo.setPassword(scanner.nextLine());
								if(userCorporateInfo.getPassword().matches("^[a-zA-Z0-9]+$")) {
									i = 11;
								}
								else {
									log.info("The password is Alphanumeric. Please try again.");
								}
							}
						case 12:
							while(i < 12) {
								log.info("Enter your username: ");
								userCorporateInfo.setUsername(scanner.nextLine());
								if(userCorporateInfo.getUsername().matches("^[a-zA-Z0-9]+$")) {
										log.info("Congratulations, your credentials are now being verified.");
										isReady0 = 54;
										signUpOption = 55;
										i = 12;
								}
								else {
									log.info("The username is Alphanumeric. Please try again.");
								}
							}
						}
						case 54:
						log.info("Redirected back.");
						break;
					default:
						log.info("Invalid input. Please try again.");
						break;
					}
					}while(isReady0 != 54);
				break;
			case 2:
				userCorporateInfo.setEmployee(true);
				int isReady01 = 0;
				do {
					log.info("_____________Welcome Employee___________");
					log.info("1) Enter Personal Information");
					log.info("54) Back");
					try {
						isReady01 = Integer.parseInt(scanner.nextLine());
						}catch(NumberFormatException e) {}
					switch(isReady01) {
					case 1:
						int runSwitch0 = 1;
						int i = 0;
						switch(runSwitch0) {
						case 1:
							while(i < 1) {
								log.info("Enter your First Name: ");
								userPersonalInfo.setFirstName(scanner.nextLine());
								if(userPersonalInfo.getFirstName().matches("^[a-zA-Z]+$")) {
									i = 1;
								}
								else {
									log.info("First name is Alphabetical. Please try again.");
								}
							}
						case 2:
							while(i < 2) {
								log.info("Enter your Last Name: ");
								userPersonalInfo.setLastName(scanner.nextLine());
								if(userPersonalInfo.getLastName().matches("^[a-zA-Z]+$")) {
									i = 2;
								}
								else {
									log.info("Last name is Alphabetical. Please try again.");
								}
							}
						case 3:
								while(i < 3) {
								log.info("Enter your birthdate: ");
								String dateValidator = scanner.nextLine();
								if(dateValidator.matches("^[12]{1}[89012]{1}[0-9]{1}[0-9]{1}-[01]{1}[0-9]{1}-[0123]{1}[0-9]{1}+$")) {
									userPersonalInfo.setBirthDate(Date.valueOf(dateValidator));
									i = 3;
								}
								else {
									log.info("Try the format \"yyyy-mm-dd\". Please try again.");
								}
							}
							case 4:
								while(i < 4) {
									log.info("Enter your phone number: ");
									userPersonalInfo.setPhoneNumber(scanner.nextLine());
									if(userPersonalInfo.getPhoneNumber().matches("^[0-9]{3}-[0-9]{3}-[0-9]{4}+$") || userPersonalInfo.getPhoneNumber().isEmpty()) {
										i = 4;
									}
									else {
										log.info("Try the format 000-000-0000. Please try again.");
									}
								}
						case 5:
							while(i < 5) {
								log.info("Enter your email: ");
								userPersonalInfo.setEmail(scanner.nextLine());
								if(userPersonalInfo.getEmail().matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$") || userPersonalInfo.getEmail().isEmpty() || userPersonalInfo.getEmail() == null) {
									i = 5;
								}
								else {
									log.info("For example example12@gmail.com. Please try again.");
								}
							}
						case 6:
							while(i < 6) {
								log.info("Enter your Country:");
								log.info("1) USA");
								userPersonalInfo.setCountry(scanner.nextLine());
								if(userPersonalInfo.getCountry().matches("USA")) {
									i = 6;
								}
								else {
									log.info("Please enter /'USA'/");
								}
							}
						case 7:
							while(i < 7) {
								log.info("Enter your home address: ");
								userPersonalInfo.setAddress(scanner.nextLine());
								if(userPersonalInfo.getAddress().matches("[a-zA-Z0-9 ]{2,10} [a-zA-Z0-9 ]{2,40}")) {
									i = 7;
								}
								else {
									log.info("Invalid input. Please try again.");
								}
							}
							case 8:
								while(i < 8) {
									log.info("Enter your home city: ");
									userPersonalInfo.setCity(scanner.nextLine());
									if(userPersonalInfo.getCity().matches("[a-zA-Z ]{2,10}")) {
										i = 8;
									}
									else {
										log.info("Invalid input. Please try again.");
									}
								}
						case 9:
							while(i < 9) {
								log.info("Enter your home state: ");
								userPersonalInfo.setState(scanner.nextLine());
								if(userPersonalInfo.getState().matches("^[A-Z]{2}+$")) {
									i = 9;
								}
								else {
									log.info("Try the Format \"AA\". Please try again.");
								}
							}
						case 10:
							while(i < 10) {
								log.info("Enter your home zipcode: ");
								userPersonalInfo.setZipCode(scanner.nextLine());
								if(userPersonalInfo.getZipCode().matches("^[0-9]{5}+$")) {
									i = 10;
									log.info("Great! Now you can create a Username and Password.");
								}
								else {
									log.info("Try the format /'00000'/. Please try again.");
								}
							}
						case 11:
							while(i < 11) {
								log.info("Enter your password: ");
								userCorporateInfo.setPassword(scanner.nextLine());
								if(userCorporateInfo.getPassword().matches("^[a-zA-Z0-9]+$")) {
									i = 11;
								}
								else {
									log.info("The password is Alphanumeric. Please try again.");
								}
							}
						case 12:
							while(i < 12) {
								log.info("Enter your username: ");
								userCorporateInfo.setUsername(scanner.nextLine());
								if(userCorporateInfo.getUsername().matches("^[a-zA-Z0-9]+$")) {
										log.info("Congratulations, your credentials are now being verified.");
										isReady01 = 54;
										signUpOption = 55;
										i = 12;
								}
								else {
									log.info("The username is Alphanumeric. Please try again.");
								}
							}
						}
						
					case 54:
						log.info("Redirected back.");
						//scanner.close();
						break;
					default:
						log.info("Invalid input. Please try again.");
						break;
					}
				}while(isReady01 != 54);
				break;
			case 55:
				log.info("Exited account sign up.");
				//scanner.close();
				break;
			default:
				log.info("Invalid input. Please try again.");
				break;
			}
			
		}while(signUpOption != 55);
	}
	@Override
	public UserCorpInfo getUserCorpInfo() {
		return userCorporateInfo;
	}
	@Override
	public UserPersonalInfo getUserPersonalInfo() {
		return userPersonalInfo;
	}

}
