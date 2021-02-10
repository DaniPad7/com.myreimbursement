package com.mydealership.service.util.factory.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mydealership.exception.BusinessException;
import com.mydealership.exception.EmptyQueryException;
import com.mydealership.exception.NullInfoException;
import com.mydealership.model.CarLot;
import com.mydealership.model.UserFinanceInfo;
import com.mydealership.model.UsersTransactionHistory;
import com.mydealership.service.DealershipDeletionService;
import com.mydealership.service.DealershipInsertService;
import com.mydealership.service.DealershipSetUpdateService;
import com.mydealership.service.DealershipViewService;
import com.mydealership.service.impl.DealershipDeletionServiceImpl;
import com.mydealership.service.impl.DealershipInsertServiceImpl;
import com.mydealership.service.impl.DealershipSetUpdateServiceImpl;
import com.mydealership.service.impl.DealershipViewServiceImpl;
import com.mydealership.service.util.factory.CarLotFactory;
import com.mydealership.service.util.factory.EmployeeFunctionsFactory;

public class EmployeeFunctionsFactoryImpl implements EmployeeFunctionsFactory {
	public static Logger log = Logger.getLogger(UserFinanceInfoFactoryImpl.class);
	public Scanner scanner = new Scanner(System.in);
	
	DealershipInsertService dealershipInsertService = new DealershipInsertServiceImpl();
	DealershipViewService dealershipViewService = new DealershipViewServiceImpl();
	DealershipSetUpdateService dealershipSetUpdateService = new DealershipSetUpdateServiceImpl();
	DealershipDeletionService dealershipDeletionService = new DealershipDeletionServiceImpl();
	CarLotFactory carLotFactoryImpl = new CarLotFactoryImpl();

	@Override
	public void employeeFunctions(int userId) throws BusinessException, NullInfoException {
		int isReady0 = 0;
		//do a get method here with user id for name
		do {
			log.info("Hello ! As an employee, what would you like to do today. ");
			log.info("1) Add a Vehicle to the Lot");
			log.info("2) View/Approve a Financing Offer");
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
				List<UserFinanceInfo> offersNotAccepted = new ArrayList<>();
				int viewOrUpdate = 0;
				do{
					log.info("__View Offers, then Accept offers.__");
					log.info("1) View Offers");
					log.info("2) Accept Offers");
					log.info("15) Back");
					try {
						viewOrUpdate = Integer.parseInt(scanner.nextLine());
					}catch(NumberFormatException e) {}
					switch(viewOrUpdate) {
					case 1:
						try {
							offersNotAccepted = dealershipViewService.viewAllOffers();
						} catch (EmptyQueryException e1) {
							log.info(e1.getMessage());
						}
						break;
					case 2:
						if(offersNotAccepted.size() > 0) {
							int updated = 0;
							int updated1 = 0;
							int isReady1 = 0;
							do {
								log.info("Please have an Offer number from the Offers List: ");
								log.info("1) Enter Offer Number");
								log.info("45) Back");
								try {
									isReady1 = Integer.parseInt(scanner.nextLine());
								}catch(NumberFormatException e) {}
								switch(isReady1) {
								case 1:
									int offerNumber = 0;
									do {
										log.info("Enter an offer number from the Offers List OR enter -1 to cancel: ");
										try {
											offerNumber = Integer.parseInt(scanner.nextLine());
										}catch(NumberFormatException e) {}
										switch(offerNumber) {
										case -1:
											log.info("Canceled Submission");
											isReady1 = 45;
											break;
										default:
											for(UserFinanceInfo ufi : offersNotAccepted) {
												if(ufi.getOfferId() == offerNumber) {
													try {
														updated = dealershipSetUpdateService.setOfferApproval(ufi.getOfferId());
													} catch (EmptyQueryException e) {
														log.info(e.getMessage());
													}
													updated1 = dealershipSetUpdateService.setCarOwnership(ufi.getOfferId());
													offerNumber = -1;
												}
												else {}
											}
											if(updated == 0) {
												log.info("No match found. Please try again");
											}
											else {}
											break;
										}
										
									}while(offerNumber != -1);
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
							log.info("For your reference, please view offers first. ");
						}
						break;
					case 15:
						log.info("Redirected back.");
						break;
					default:
						log.info("Invalid input. Please try again.");
						break;
					}
				}while(viewOrUpdate != 15);
				break;
			case 3:
				List<CarLot> carsNotOwned = new ArrayList<>();
				int viewOrDelete0 = 0;
				do {
					log.info("__View Unowned vehicles, then Delete vehicle.__");
					log.info("1) View Unowned Vehicles with no offers");
					log.info("2) Accept Offers");
					log.info("5) Back");
					try {
						viewOrDelete0 = Integer.parseInt(scanner.nextLine());
					}catch(NumberFormatException e) {}
					switch(viewOrDelete0) {
					case 1:
						try {
							carsNotOwned = dealershipViewService.viewUnownedCarsOnLot();
						} catch (EmptyQueryException e1) {
							log.info(e1.getMessage());
						}
						break;
					case 2:
						if(carsNotOwned.size() > 0) {
						int isReady2 = 0;
						do {
							log.info("Please have a car number from the Car Lot: ");
							log.info("1) Enter Car Number");
							log.info("25) Back");
							try {
								isReady2 = Integer.parseInt(scanner.nextLine());
							}catch(NumberFormatException e) {}
							switch(isReady2) {
							case 1:
								int carNumber1 = 0;
								do {
									log.info("Enter a car number from the Car Lot OR enter -1 to cancel: ");
									try {
										carNumber1 = Integer.parseInt(scanner.nextLine());
										switch(carNumber1) {
										case -1:
											log.info("Canceled Submission");
											isReady2 = 25;
											break;
										default:
											for(CarLot car : carsNotOwned) {
												if(car.getCarId() == carNumber1) {
													dealershipDeletionService.deleteCarFromLot(car.getCarId());
													carNumber1 = -1;
												}
												else {}
											}
											break;
										}
									}catch(NumberFormatException e) {}
								}while(carNumber1 != -1);
								break;
							case 45:
								log.info("Redirected back.");
								break;
								
							default:
								log.info("Invalid input. Please try again.");
								break;
							}
						}while(isReady2 != 25);
						break;
					}
					else {
						log.info("Please view the Cars on the Lot at least once for your reference.");
						break;
					}
					case 5:
						log.info("Redirected back.");
						break;
					default:
						log.info("Invalid input. Please try again.");
						break;
					}
				}while(viewOrDelete0 != 5);
				break;
			case 4:
				List<UsersTransactionHistory> customerTransactions = new ArrayList<>();
				int findByMany = 0;
				do {
					log.info("__View Customer Payments By...__");
					log.info("1) First name, Last name");
					log.info("85) Back");
					try {
						findByMany = Integer.parseInt(scanner.nextLine());
					}catch(NumberFormatException e) {}
					switch(findByMany) {
					case 1:
						int nameValidator = 1;
						int i = 0;
						String firstValidator = "";
						String lastValidator = "";
						switch(nameValidator) {
						case 1:
							while(i < 1) {
								log.info("Please enter the First Name: ");
								firstValidator = scanner.nextLine();
								if(firstValidator.matches("^[a-zA-Z]+$")) {
									i = 1;
								}
								else {
									log.info("Invalid input. Please try again.");
								}
							}
						case 2:
							while(i < 2) {
								log.info("Please enter the Last Name: ");
								lastValidator = scanner.nextLine();
								if(lastValidator.matches("^[a-zA-Z]+$")) {
									i = 2;
									findByMany = 85;
									try {
										customerTransactions = dealershipViewService.viewAllCustomerPayments(firstValidator, lastValidator);
									} catch (EmptyQueryException e) {
										log.info(e.getMessage());
									}
								}
								else {
									log.info("Invalid input. Please try again.");
								}
							}
						}
						break;
					case 85:
						log.info("Redirected back.");
						break;
					default:
						log.info("Invalid input. Please try again.");
						break;
					}
				}while(findByMany != 85);
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


