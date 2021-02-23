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
import com.myreimbursement.service.ViewService;

public class ViewServiceImpl implements ViewService{

	@Override
	public List<UserReimRequests> viewPendingReimbursementRequests(int userId)
			throws BusinessException, ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserReimRequests> viewResolvedReimbursementRequests(int userId)
			throws BusinessException, ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPersonalInfo viewOwnInformation(int userId)
			throws BusinessException, ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserReimRequests> viewAllPendingRequestsOwnEmployees(int userId)
			throws BusinessException, ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserBusinessInfo> viewAllEmployessTheirManagers()
			throws BusinessException, ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserReimRequests viewSingleEmployeeRequest(int userId, int requestId)
			throws BusinessException, HibernateException, ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
