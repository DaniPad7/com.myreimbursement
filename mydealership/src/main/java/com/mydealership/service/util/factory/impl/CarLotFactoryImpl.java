package com.mydealership.service.util.factory.impl;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.mydealership.exception.BusinessException;
import com.mydealership.model.CarLot;
import com.mydealership.model.UserFinanceInfo;
import com.mydealership.service.util.factory.CarLotFactory;

public class CarLotFactoryImpl implements CarLotFactory{
	public static Logger log = Logger.getLogger(UserFinanceInfoFactoryImpl.class);
	public Scanner scanner = new Scanner(System.in);
	CarLot carLot;

	@Override
	public void setCar() throws BusinessException {
		this.carLot = new CarLot();
		int isReady0 = 0;
		do {
			log.info("_____________Welcome Employee___________");
			log.info("1) Enter Vehicle Information");
			log.info("75) Back");
			try {
				isReady0 = Integer.parseInt(scanner.nextLine());
				}catch(NumberFormatException e) {}
			switch(isReady0) {
			case 1:
				int runSwitch0 = 1;
				int i = 0;
				switch(runSwitch0) {
				case 1:
					//carLot.setOwned(false);
					//carId is automatic
					//do something with userId is probably through storage
					while(i < 1) {
						log.info("Enter the Vehicle Maker: ");
						carLot.setCarMaker(scanner.nextLine());
						if(carLot.getCarMaker().matches("[a-zA-Z ]{2,10}")) {
							i = 1;
						}
						else {
							log.info("Invalid input. Please try again.");
						}
					}
				case 2:
					while(i < 2) {
						log.info("Enter the Vehicle Type: ");
						carLot.setCarType(scanner.nextLine());
						if(carLot.getCarType().matches("[a-zA-Z ]{2,10}")) {
							i = 2;
						}
						else {
							log.info("Invalid input. Please try again.");
						}
					}
					
				case 3:
					while(i < 3) {
						log.info("Enter the Vehicle Model: ");
						carLot.setCarModel(scanner.nextLine());
						if(carLot.getCarModel().matches("[a-zA-Z ]{2,10}")) {
							i = 3;
						}
						else {
							log.info("Invalid input. Please try again.");
						}
					}
					
				case 4:
					while(i < 4) {
						log.info("Enter the Vehicle Color: ");
						carLot.setCarColor(scanner.nextLine());
						if(carLot.getCarColor().matches("[a-zA-Z ]{2,10}")) {
							i = 4;
						}
						else {
							log.info("Invalid input. Please try again.");
						}
					}
					
				case 5:
					while(i < 5) {
						log.info("Enter the Vehicle Year: ");
						carLot.setCarYear(scanner.nextLine());
						if(carLot.getCarYear().matches("[1-2]{1}[0-9]{1}[0-9]{1}[0-9]{1}")) {
							i = 5;
						}
						else {
							log.info("Invalid input. Please try again.");
						}
					}
					
				case 6:
					while(i < 6) {
						log.info("Is the Vehicle New or Used? Type Yes or No: ");
						String isNewValidator= scanner.nextLine();
						if(isNewValidator.matches("Yes")) {
							carLot.setNew(true);
							i = 6;
						}
						else if(isNewValidator.matches("No")){
							carLot.setNew(false);
							i = 6;
							}
						else {
							log.info("Invalid input. Please try again.");
						}
					}
					
				case 7:
					while(i < 7) {
						log.info("Enter your Odometer reading: ");
						int odometerValidator = Integer.parseInt(scanner.nextLine());
						if(odometerValidator < 500_000 && odometerValidator > 0) {
							carLot.setOdometerReading(odometerValidator);
							i = 7;
						}
						else {
							log.info("Amount is out of bounds. Please try again.");
						}
					}
					
				case 8:
					while(i < 8) {
						log.info("Enter the vehicle price: ");
						float priceValidator = Float.parseFloat(scanner.nextLine());
						if(priceValidator < 100_000 && priceValidator > 0) {
							carLot.setPrice(priceValidator);
							i = 8;
						}
						else {
							log.info("Amount is out of bounds. Please try again.");
						}
					}
				}
				
			case 75:
				log.info("Redirected back.");
				break;
			default:
				log.info("Invalid input. Please try again.");
				break;
			}
		}while(isReady0 != 75);
		
		
	}

	@Override
	public CarLot getCar() throws BusinessException {
		return carLot;
	}

}
