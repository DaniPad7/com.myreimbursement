package com.myreimbursement.util.validators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class RequestParameterValidators {
	private DateTimeFormatter dateFormatter;
	
	
	
	public boolean isBoolean(String parameter) {
		if(parameter.equalsIgnoreCase("true") || parameter.equalsIgnoreCase("false"))  {
			return true;
		}
		else return false;
	}
	
	public boolean isInteger(String parameter) {
		if(parameter.matches("[0-9]")){
			return true;
		}
		else return false;
	}
	
	public boolean isFloat(String parameter) {
		if(parameter.matches("[0-9]")) {
			return true;
		}
		else return false;
	}
	
	public boolean isDate(String parameter) {
		try {
			LocalDate.parse(parameter, dateFormatter);
		}catch(DateTimeParseException e) {
			return false;
		}
		return true;
	}

}
