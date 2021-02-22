package com.myreimbursement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	public static Object processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		final String URI = request.getRequestURI();
		System.out.println(URI);
		final String RESOURCE = URI.replace("/Dispatcher/api", "");
		System.out.println(RESOURCE);
		switch(RESOURCE) {
		case "1":
			break;
		case "2":
			break;
		default:
			break;
		}
		
		return null;
		
	}
	
	public static Object processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		final String URI = request.getRequestURI();
		System.out.println(URI);
		final String RESOURCE = URI.replace("/Dispatcher/api", "");
		System.out.println(RESOURCE);
		switch(RESOURCE) {
		case "/login":
			break;
		default:
			response.sendError(404);
			break;
		
		}
		
		
		return null;
	}

}
