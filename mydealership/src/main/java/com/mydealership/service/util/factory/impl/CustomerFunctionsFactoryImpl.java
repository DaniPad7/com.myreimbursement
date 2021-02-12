package com.mydealership.service.util.factory.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mydealership.exception.BusinessException;
import com.mydealership.exception.EmptyQueryException;
import com.mydealership.exception.NullInfoException;
import com.mydealership.model.CarLot;
import com.mydealership.service.DealershipInsertService;
import com.mydealership.service.DealershipViewService;
import com.mydealership.service.impl.DealershipInsertServiceImpl;
import com.mydealership.service.impl.DealershipViewServiceImpl;
import com.mydealership.service.util.factory.CustomerFunctionsFactory;
import com.mydealership.service.util.factory.UserFinanceInfoFactory;

public class CustomerFunctionsFactoryImpl implements CustomerFunctionsFactory {
	public static Logger log = Logger.getLogger(UserFinanceInfoFactoryImpl.class);
	public Scanner scanner = new Scanner(System.in);
	
	DealershipViewService dealershipViewService = new DealershipViewServiceImpl();
	DealershipInsertService dealershipInsertService = new DealershipInsertServiceImpl();
	
	UserFinanceInfoFactory userFinanceInfoFactory = new UserFinanceInfoFactoryImpl();

	@Override
	public void customerFunctions(int userId) throws BusinessException, NullInfoException {
		List<CarLot> storedCarsOnLot = new ArrayList<>();
		List<CarLot> ownedCars = new ArrayList<>();
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
				try {
					storedCarsOnLot = dealershipViewService.viewAllCarsOnLot();
				} catch (EmptyQueryException e) {
					log.info(e.getMessage());
				}
				break;
				
			case 2:
				int registered = 0;
				if(storedCarsOnLot.size() > 0) {
					int isReady1 = 0;
					do {
						log.info("Please have a car number from the Car Lot: ");
						log.info("1) Enter Car Number");
						log.info("45) Back");
						try {
							isReady1 = Integer.parseInt(scanner.nextLine());
						}catch(NumberFormatException e) {}
						switch(isReady1) {
						case 1:
							int carNumber = 0;
							do {
								log.info("Enter a car number from the Car Lot OR enter -1 to cancel: ");
								try {
									carNumber = Integer.parseInt(scanner.nextLine());
								}catch(NumberFormatException e) {}
								switch(carNumber) {
								case -1:
									log.info("Canceled Submission");
									isReady1 = 45;
									break;
								default:
									for(CarLot car : storedCarsOnLot) {
										if(car.getCarId() == carNumber) {
											userFinanceInfoFactory.setUserFinanceInfo(userId, car.getCarId());
											if(userFinanceInfoFactory.getUserFinanceInfo().getOfferDate() != null) {
												registered = dealershipInsertService.makeCarOffer(userFinanceInfoFactory.getUserFinanceInfo());	
											}
											else {}
											carNumber = -1;
										}
										else {}
									}
									if(registered == 0) {
										log.info("No match found. Please try again");
									}
									else {}
									break;
								}
							}while(carNumber != -1);
							break;
						case 45:
							log.info("Redirected back.");
							break;
							
						default:
							log.info("Invalid input. Please try again.");
							break;
						}
						
					}while(isReady1 != 45);
					break;
				}
				else {
					log.info("Please view the Cars on the Lot at least once for your reference.");
					break;
				}
			case 3:
				try {
					ownedCars = dealershipViewService.viewOwnedCars(userId);
				} catch (EmptyQueryException e) {
					log.info(e.getMessage());
				}
				break;
				
			case 4:
				int carFound = 0;
				if(ownedCars.size() > 0) {
					int isReady2 = 0;
					do {
						log.info("Please have a car number from your owned Vehicles: ");
						log.info("1) Enter Car Number");
						log.info("75) Back");
						try {
							isReady2 = Integer.parseInt(scanner.nextLine());
						}catch(NumberFormatException e) {}
						switch(isReady2) {
						case 1:
							int carNumber2 = 0;
							do {
								log.info("Enter a car number from the Car Lot OR enter -1 to cancel: ");
								try {
									carNumber2 = Integer.parseInt(scanner.nextLine());
								}catch(NumberFormatException e) {}
								switch(carNumber2) {
								case -1:
									log.info("Canceled Submission");
									isReady2 = 75;
									break;
								default:
									for(CarLot car : ownedCars) {
										if(car.getCarId() == carNumber2) {
											try {
												dealershipViewService.viewRemainingPayments(userId, car.getCarId());
											} catch (EmptyQueryException e) {
												log.info(e.getMessage());
											}
											carFound = 1;
											carNumber2 = -1;
										}
										else {}
									}
									if(carFound == 0) {
										log.info("No match found. Please try again");
									}
									else {}
									break;
								}
							}while(carNumber2 != -1);
							break;
						case 75:
							log.info("Redirected back.");
							break;
							
						default:
							log.info("Invalid input. Please try again.");
							break;
						}
					}while(isReady2 != 75);
				}
				else {
					log.info("Please view your owned vehicles at least once for your reference.");
					break;
				}
				
			case 95:
				log.info("Redirected back.");
				break;
				
			default:
				log.info("Invalid input from customer. Please try again.");
				break;
			
			}
			
		}while(isReady0 != 95);

	}

}
