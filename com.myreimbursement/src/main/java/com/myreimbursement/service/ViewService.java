package com.myreimbursement.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;

import org.hibernate.HibernateException;

import com.myreimbursement.exceptions.BusinessException;
import com.myreimbursement.model.UserBusinessInfo;
import com.myreimbursement.model.UserPersonalInfo;
import com.myreimbursement.model.UserReimAwarded;
import com.myreimbursement.model.UserReimRequests;

public interface ViewService {
	List<UserReimRequests> viewPendingReimbursementRequests(int userId) throws BusinessException, ServletException, IOException;
	List<UserReimRequests> viewResolvedReimbursementRequests(int userId) throws BusinessException, ServletException, IOException;
	UserPersonalInfo viewOwnInformation(int userId) throws BusinessException, ServletException, IOException;
	List<UserReimRequests> viewAllPendingRequestsOwnEmployees(int userId) throws BusinessException, ServletException, IOException;
	List<File> viewAllImageReceiptRequests() throws BusinessException, ServletException, IOException;
	List<UserReimAwarded> viewAllResolvedRequestsManagers() throws BusinessException, ServletException, IOException;
	List<UserBusinessInfo> viewAllEmployessTheirManagers() throws BusinessException, ServletException, IOException;
	UserReimRequests viewSingleEmployeeRequest(int userId, int requestId) throws BusinessException, ServletException, IOException;

}
