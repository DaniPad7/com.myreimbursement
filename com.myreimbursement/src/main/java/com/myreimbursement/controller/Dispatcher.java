package com.myreimbursement.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Dispatcher extends HttpServlet{
	public ObjectMapper om = new ObjectMapper();
	private RequestHelper requestHelper =new RequestHelper();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter writer = response.getWriter();	
		
		final String JSON = om.writeValueAsString(requestHelper.processGet(request, response));
		System.out.println("Hello: " + JSON);
		writer.write(JSON);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		requestHelper.processPost(request, response);
		
	}
		
		
}
