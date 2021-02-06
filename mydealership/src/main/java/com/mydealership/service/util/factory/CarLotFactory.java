package com.mydealership.service.util.factory;

import com.mydealership.exception.BusinessException;
import com.mydealership.model.CarLot;

public interface CarLotFactory {
	void setCar() throws BusinessException;
	CarLot getCar() throws BusinessException;

}
