package com.myreimbursement.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myreimbursement.exceptions.BusinessException;
import com.myreimbursement.model.UserCorpInfo;
import com.myreimbursement.model.UserPersonalInfo;
import com.myreimbursement.service.SystemAuthenticationService;
import com.myreimbursement.service.ViewService;
import com.myreimbursement.service.impl.SystemAuthenticationServiceImpl;
import com.myreimbursement.service.impl.ViewServiceImpl;

public class RequestHelper {
	private ViewService viewService = new ViewServiceImpl();
	private SystemAuthenticationService sas = new SystemAuthenticationServiceImpl();
	
	private UserPersonalInfo controlledUserPersonalInfo = new UserPersonalInfo();
	
	public Object processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		final String URI = request.getRequestURI();
		System.out.println(URI);
		final String RESOURCE = URI.replace("/Dispatcher/api", "");
		System.out.println(RESOURCE);
		try {
			switch(RESOURCE) {
			case "/logout":
				HttpSession session = request.getSession(false);
				if(session != null) {
					session.invalidate();
				}
				break;
			case "/efunc3":
				return viewService.viewPendingReimbursementRequests(controlledUserPersonalInfo.getUserId());
				
			case "/efunc4":
				return viewService.viewResolvedReimbursementRequests(controlledUserPersonalInfo.getUserId());
				
			case "/efunc5":
				return viewService.viewOwnInformation(controlledUserPersonalInfo.getUserId());
				
			case "/mfunc2":
				return viewService.viewAllPendingRequestsOwnEmployees(controlledUserPersonalInfo.getUserId());
				
			case "/mfunc3":
				return viewService.viewAllImageReceiptRequests();
				
			case "/mfunc4":
				return viewService.viewAllResolvedRequestsManagers();
				
			case "/mfunc5":
				return viewService.viewAllEmployessTheirManagers();
				
			case "/mfunc6":
				return viewService.viewSingleEmployeeRequest(controlledUserPersonalInfo.getUserId(), 0);
				
			default:
				response.sendError(404);
				break;
			}
		}catch(BusinessException e) {}
		
		
		return null;
		
	}
	
	public Object processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		final String URI = request.getRequestURI();
		System.out.println(URI);
		final String RESOURCE = URI.replace("/Dispatcher/api", "");
		System.out.println(RESOURCE);
		try {
			switch(RESOURCE) {
			case "/login":
				controlledUserPersonalInfo.setUserId(sas.login(request.getParameter("nameuser"), request.getParameter("userpass")));
				break;
			case "/efunc1":
				break;
			case "/efunc2":
				break;
			case "/efunc6":
				break;
			case "/mfunc1":
				break;
			default:
				response.sendError(404);
				break;
			
			}
		}catch(BusinessException e) {}
		
		
		
		return null;
	}

}
