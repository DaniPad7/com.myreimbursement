package com.myreimbursement.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.hibernate.HibernateException;

import com.myreimbursement.exceptions.BusinessException;
import com.myreimbursement.model.UserBusinessInfo;
import com.myreimbursement.model.UserPersonalInfo;
import com.myreimbursement.model.UserReimAwarded;
import com.myreimbursement.model.UserReimRequests;

public interface ViewService {
	List<UserReimRequests> viewPendingReimbursementRequests(int userId) throws BusinessException, HibernateException, ServletException, IOException;
	List<UserReimRequests> viewResolvedReimbursementRequests(int userId) throws BusinessException, HibernateException, ServletException, IOException;
	UserPersonalInfo viewOwnInformation(int userId) throws BusinessException, HibernateException, ServletException, IOException;
	List<UserReimRequests> viewAllPendingRequestsOwnEmployees(int userId) throws BusinessException, HibernateException, ServletException, IOException;
	List<File> viewAllImageReceiptRequests() throws BusinessException, HibernateException, ServletException, IOException;
	List<UserReimAwarded> viewAllResolvedRequestsManagers() throws BusinessException, HibernateException, ServletException, IOException;
	List<UserBusinessInfo> viewAllEmployessTheirManagers() throws BusinessException, HibernateException, ServletException, IOException;
	UserReimRequests viewSingleEmployeeRequest(int userId, int requestId) throws BusinessException, HibernateException, ServletException, IOException;

}
