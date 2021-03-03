package com.myreimbursement.service.impl;

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
import com.myreimbursement.repository.ViewRepository;
import com.myreimbursement.repository.impl.ViewRepositoryImpl;
import com.myreimbursement.service.ViewService;

public class ViewServiceImpl implements ViewService{
	private ViewRepository viewRepository = new ViewRepositoryImpl();

	@Override
	public List<UserReimRequests> viewPendingReimbursementRequests(int userId)
			throws BusinessException, ServletException, IOException {
		List<UserReimRequests> pendingRequests = null;
		if(userId > 0) {
			pendingRequests = viewRepository.viewPendingReimbursementRequests(userId);
		}
		return pendingRequests;
	}

	@Override
	public List<UserReimRequests> viewResolvedReimbursementRequests(int userId)
			throws BusinessException, ServletException, IOException {
		List<UserReimRequests> resolvedRequests = null;
		if(userId > 0) {
			resolvedRequests = viewRepository.viewResolvedReimbursementRequests(userId);
		}
		return resolvedRequests;
	}

	@Override
	public UserPersonalInfo viewOwnInformation(int userId)
			throws BusinessException, ServletException, IOException {
		UserPersonalInfo userPersonalInfo = null;
		if(userId > 0) {
			userPersonalInfo = viewRepository.viewOwnInformation(userId);
		}
		return userPersonalInfo;
	}

	@Override
	public List<UserReimRequests> viewAllPendingRequestsOwnEmployees(int userId)
			throws BusinessException, ServletException, IOException {
		List<UserReimRequests> pendingRequests = null;
		if(userId > 0) {
			pendingRequests = viewRepository.viewAllPendingRequestsOwnEmployees(userId);
		}
		return pendingRequests;
	}

	@Override
	public List<File> viewAllImageReceiptRequests()
			throws BusinessException, ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserReimAwarded> viewAllResolvedRequestsManagers()
			throws BusinessException, ServletException, IOException {
		List<UserReimAwarded> awardedRequests = null;
		awardedRequests = viewRepository.viewAllResolvedRequestsManagers();
		return awardedRequests;
	}

	@Override
	public List<UserBusinessInfo> viewAllEmployessTheirManagers()
			throws BusinessException, ServletException, IOException {
		List<UserBusinessInfo> userBusinessInfo = null;
		userBusinessInfo = viewRepository.viewAllEmployessTheirManagers();
		return userBusinessInfo;
	}

	@Override
	public UserReimRequests viewSingleEmployeeRequest(int userId, int requestId)
			throws BusinessException, HibernateException, ServletException, IOException {
		UserReimRequests userReimRequest = null;
		if(userId > 0) {
			userReimRequest = viewRepository.viewSingleEmployeeRequest(userId, requestId);
			
		}
		return userReimRequest;
	}

}
