package com.myreimbursement.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.DateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.DateFormatter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myreimbursement.exceptions.BusinessException;
import com.myreimbursement.model.Reasons;
import com.myreimbursement.model.UploadTypes;
import com.myreimbursement.model.UserBusinessInfo;
import com.myreimbursement.model.UserCorpInfo;
import com.myreimbursement.model.UserPersonalInfo;
import com.myreimbursement.model.UserReimRequests;
import com.myreimbursement.model.UserReimbursement;
import com.myreimbursement.service.InsertService;
import com.myreimbursement.service.SystemAuthenticationService;
import com.myreimbursement.service.UpdateService;
import com.myreimbursement.service.ViewService;
import com.myreimbursement.service.impl.InsertServiceImpl;
import com.myreimbursement.service.impl.SystemAuthenticationServiceImpl;
import com.myreimbursement.service.impl.UpdateServiceImpl;
import com.myreimbursement.service.impl.ViewServiceImpl;
import com.myreimbursement.util.validators.RequestParameterValidators;

public class RequestHelper {
	public ObjectMapper om;
	DateFormatter df  = new DateFormatter();
	private ViewService viewService = new ViewServiceImpl();
	private InsertService insertService = new InsertServiceImpl();
	private UpdateService updateService = new UpdateServiceImpl();
	private SystemAuthenticationService sas = new SystemAuthenticationServiceImpl();
	private RequestParameterValidators rpv = new RequestParameterValidators();
	
	private UserCorpInfo controlledUCI = new UserCorpInfo();
	private UserPersonalInfo controlledUserPersonalInfo = new UserPersonalInfo();
	
	private HttpSession httpSession = null;
	private File directory = new File("Receipts");
	
	public Object processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		if((httpSession != null && httpSession.getAttribute("username") != null)) {
			final String URI = request.getRequestURI();
			System.out.println(URI);
			final String RESOURCE = URI.replace("/com.myreimbursement/Dispatcher/api", "");
			System.out.println(RESOURCE);
			try {
				switch(RESOURCE) {
				case "/logout":
					HttpSession session = request.getSession(false);
					if(session != null) {
						response.sendRedirect("/com.myreimbursement/Pages/logout.html");
						session.invalidate();
						
						response.setStatus(200);
					}
					break;
				case "/efunc3":
					response.setStatus(200);
					return viewService.viewPendingReimbursementRequests(controlledUserPersonalInfo.getUserId());
					
				case "/efunc4":
					response.setStatus(200);
					return viewService.viewResolvedReimbursementRequests(controlledUserPersonalInfo.getUserId());
					
				case "/efunc5":
					UserPersonalInfo userPersonalInfo = null;
					response.setStatus(200);
					userPersonalInfo = viewService.viewOwnInformation(controlledUserPersonalInfo.getUserId());
					System.out.println(userPersonalInfo);
					return userPersonalInfo;
					
				case "/mfunc2":
					response.setStatus(200);
					return viewService.viewAllPendingRequestsOwnEmployees(controlledUserPersonalInfo.getUserId());
					
				case "/mfunc3":
					response.setStatus(200);
					return viewService.viewAllImageReceiptRequests();
					
				case "/mfunc4":
					response.setStatus(200);
					return viewService.viewAllResolvedRequestsManagers();
					
				case "/mfunc5":
					List<UserBusinessInfo> userBusinessInfo = null;
					response.setStatus(200);
					userBusinessInfo = viewService.viewAllEmployessTheirManagers();
					System.out.println(userBusinessInfo);
					return userBusinessInfo;
					
				case "/mfunc6":
					response.setStatus(200);
					return viewService.viewSingleEmployeeRequest(controlledUserPersonalInfo.getUserId(), 0);
					
				default:
					response.sendError(404);
					break;
				}
			}catch(BusinessException e) {}
		}else {
			response.sendError(401);
			
		}
		
		return null;
		
	}
	
	public Object processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		final String URI = request.getRequestURI();
		System.out.println(URI);
		final String RESOURCE = URI.replace("/com.myreimbursement/Dispatcher/api", "");
		System.out.println(RESOURCE);
		try {
			switch(RESOURCE) {
			case "/login":
				//UserCorpInfo ufo = om.readValue(request.getInputStream(), UserCorpInfo.class);
				System.out.println(request.getParameter("nameuser"));
				UserCorpInfo retrievedUCI = sas.login(request.getParameter("nameuser"), request.getParameter("userpass"));
				System.out.println(retrievedUCI.toString());
				if(retrievedUCI != null) {
					controlledUserPersonalInfo.setUserId(retrievedUCI.getUserId().getUserId());
					controlledUCI.setManager(retrievedUCI.isManager());
					if(controlledUserPersonalInfo.getUserId() > 0 && controlledUCI.isManager() == true) {
						httpSession = request.getSession();
						httpSession.setAttribute("username", request.getParameter("nameuser"));
						response.sendRedirect("/com.myreimbursement/Pages/mhome.html");
						response.setStatus(200);
					}
					if(controlledUserPersonalInfo.getUserId() > 0 && controlledUCI.isManager() == false) {
						httpSession = request.getSession();
						httpSession.setAttribute("username", request.getParameter("nameuser"));
						response.sendRedirect("/com.myreimbursement/Pages/ehome.html");
						response.setStatus(200);
					}
				}
				break;
			case "/efunc1":
				if(httpSession != null && httpSession.getAttribute("username") != null) {
					
					/*UserReimRequests urr = new UserReimRequests();
					Reasons reasons = new Reasons();
					UserReimbursement uReim = new UserReimbursement();
					UploadTypes up = new UploadTypes();
					
					//final Integer REQUESTID = Integer.parseInt(request.getParameter("param1"));
					//final Integer REIMBURSEMENTID =Integer.parseInt(request.getParameter("param2")) ;
					final Integer REASONID = Integer.parseInt(request.getParameter("reasonId"));
					//final Integer UPLOADTYPEID = Integer.parseInt(request.getParameter("param4"));
					//final String UPLOAD = request.getParameter("param5");
					final Float AMOUNT = Float.parseFloat(request.getParameter("amount"));
					//final Boolean ISAWARDED = Boolean.parseBoolean(request.getParameter("param7"));
					//final Date REQUESTDATE = Date.valueOf(request.getParameter("param8"));
					
					reasons.setReasonId(REASONID);
					
					uReim.setReimbursementId(controlledUserPersonalInfo.getUserId());
					
					up.setUploadTypeId(1);
					
					urr.setRequestId(1);
					urr.setReimbursementId(uReim);
					urr.setReasonId(reasons);
					urr.setUploadTypeId(up);
					urr.setUpload(null);
					urr.setAmount(AMOUNT);
					urr.setAwarded(false);
					urr.setRequestDate(Date.valueOf("2005-05-05"));*/
					System.out.println(directory.getAbsolutePath());
					UserReimRequests urr = new UserReimRequests();
					final String DIRECTORY = "";
					//Part filepart = request.getPart("myFile1");
					//String filename  = Paths.get(filePart.getSubmitted)
					
					/*Part filePart = request.getPart("myFile1");
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		String file_path = "C:\\Users\\ca132\\Desktop" + fileName;
		File file = new File(file_path);
*/
					String file_path = "";
					System.out.println(request.getInputStream().toString());
					
					if(rpv.isInteger(request.getParameter("requestId")) == true &&
							rpv.isInteger(request.getParameter("reimbursementId")) == true &&
							rpv.isInteger(request.getParameter("reasonId")) == true &&
							rpv.isInteger(request.getParameter("uploadTypeId")) == true &&
							rpv.isFloat(request.getParameter("amount")) == true &&
							rpv.isBoolean(request.getParameter("isAwarded").toLowerCase()) == true &&
							rpv.isDate(request.getParameter("requestDate")) == true
							) {
						System.out.println("I am here.");
						final Integer REQUESTID = Integer.parseInt(request.getParameter("requestId"));
						final Integer REIMBURSEMENTID =Integer.parseInt(request.getParameter("reimbursementId"));
						final Integer REASONID = Integer.parseInt(request.getParameter("reasonId"));
						final Integer UPLOADTYPEID = Integer.parseInt(request.getParameter("uploadTypeId"));
						
						//final File UPLOAD = File.createTempFile(URI, request.getParameter("param5"),  ) ;
						final Boolean ISAWARDED = Boolean.parseBoolean(request.getParameter("isAwarded").toLowerCase());
						final Date REQUESTDATE = Date.valueOf(request.getParameter("requestDate"));
						System.out.println(ISAWARDED);
						if(ISAWARDED == false) {
							
							urr.setRequestId(REQUESTID);
							
							final Float AMOUNT = Float.parseFloat(request.getParameter("amount"));
							System.out.println(AMOUNT);
							urr.setAmount(AMOUNT);
							urr.setAwarded(ISAWARDED);
						}
						
					}
					
					
					//insertService.submitReimbursementRequest(urr);
					
					
				}else {
					response.sendError(401);
				}
				break;
			case "/efunc2":
				if(httpSession != null && httpSession.getAttribute("username") != null) {
					UserReimRequests urr = new UserReimRequests();
					Reasons reasons = new Reasons();
					UserReimbursement uReim = new UserReimbursement();
					UploadTypes up = new UploadTypes();
					
					final Integer REQUESTID = Integer.parseInt(request.getParameter("param1"));
					//final Integer REIMBURSEMENTID =Integer.parseInt(request.getParameter("param2")) ;
					//final Integer REASONID = Integer.parseInt(request.getParameter("param3"));
					//final Integer UPLOADTYPEID = Integer.parseInt(request.getParameter("param4"));
					//final File UPLOAD = request.getParameter("param5"); *important*
					//final Float AMOUNT = Float.parseFloat(request.getParameter("param6"));
					//final Boolean ISAWARDED = Boolean.parseBoolean(request.getParameter("param7"));
					//final Date REQUESTDATE = Date.valueOf(request.getParameter("param8"));
					
					urr.setRequestId(REQUESTID);
					urr.setReimbursementId(null);
					urr.setReasonId(null);
					urr.setUploadTypeId(null);
					urr.setUpload(null);
					urr.setAmount(0);
					urr.setAwarded(false);
					urr.setRequestDate(Date.valueOf("2005-05-05"));
					
					
					updateService.uploadRequestReceiptImage(urr);
				}else {
					response.sendError(401);
				}
				break;
			case "/efunc6":
				if(httpSession != null && httpSession.getAttribute("username") != null) {
					UserPersonalInfo upi = new UserPersonalInfo();
					
					//final Integer USERID = Integer.parseInt(request.getParameter("param1"));
					final String FIRSTNAME = request.getParameter("param2");
					final String LASTNAME = request.getParameter("param3");
					final String EMAIL = request.getParameter("param4");
					final String PHONENUMBER = request.getParameter("param5");
					final String CITY = request.getParameter("param6");
					final String STATE = request.getParameter("param7");
					final String COUNTRY = request.getParameter("param8");
					
					upi.setUserId(controlledUserPersonalInfo.getUserId());
					upi.setFirstName(FIRSTNAME);
					upi.setLastname(LASTNAME);
					upi.setEmail(EMAIL);
					upi.setPhoneNumber(PHONENUMBER);
					upi.setCity(CITY);
					upi.setState(STATE);
					upi.setCountry(COUNTRY);
					
					updateService.updateOwnInformation(upi);
				}else {
					response.sendError(401);
				}
				break;
			case "/mfunc1":
				if(httpSession != null && httpSession.getAttribute("username") != null) {
					UserReimRequests urr = new UserReimRequests();
					final String DIRECTORY = "";
					
					if(rpv.isInteger(request.getParameter("requestId")) == true &&
							rpv.isInteger(request.getParameter("reimbursementId")) == true &&
							rpv.isInteger(request.getParameter("reasonId")) == true &&
							rpv.isInteger(request.getParameter("uploadTypeId")) == true &&
							rpv.isFloat(request.getParameter("amount")) == true &&
							rpv.isBoolean(request.getParameter("isAwarded").toLowerCase()) == true &&
							rpv.isDate(request.getParameter("requestDate")) == true
							) {
						final Integer REQUESTID = Integer.parseInt(request.getParameter("requestId"));
						final Integer REIMBURSEMENTID =Integer.parseInt(request.getParameter("reimbursementId"));
						final Integer REASONID = Integer.parseInt(request.getParameter("reasonId"));
						final Integer UPLOADTYPEID = Integer.parseInt(request.getParameter("uploadTypeId"));
						//final File UPLOAD = File.createTempFile(URI, RESOURCE, ) request.getParameter("param5");
						final Boolean ISAWARDED = Boolean.parseBoolean(request.getParameter("isAwarded").toLowerCase());
						final Date REQUESTDATE = Date.valueOf(request.getParameter("requestDate"));
						System.out.println(ISAWARDED);
						if(ISAWARDED == false) {
							
							urr.setRequestId(REQUESTID);
							
							final Float AMOUNT = Float.parseFloat(request.getParameter("amount"));
							System.out.println(AMOUNT);
							urr.setAmount(AMOUNT);
							urr.setAwarded(ISAWARDED);
						}
						
					}
				
					
					//updateService.acceptOrDenyOwnEmployeeRequests(controlledUserPersonalInfo.getUserId(), urr);
				}else {
					response.sendError(401);
				}
				break;
			default:
				response.sendError(404);
				break;
			
			}
		}catch(BusinessException e) {}
		
		
		
		return null;
	}

}
