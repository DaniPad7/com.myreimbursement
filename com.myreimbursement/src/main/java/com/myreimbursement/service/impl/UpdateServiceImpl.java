package com.myreimbursement.service.impl;

import java.io.IOException;

import javax.servlet.ServletException;

import org.hibernate.HibernateException;

import com.myreimbursement.exceptions.BusinessException;
import com.myreimbursement.model.UserPersonalInfo;
import com.myreimbursement.model.UserReimRequests;
import com.myreimbursement.service.UpdateService;

public class UpdateServiceImpl implements UpdateService{

	@Override
	public void uploadRequestReceiptImage(UserReimRequests userReimRequest)
			throws BusinessException, ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOwnInformation(UserPersonalInfo userPersonalInfo)
			throws BusinessException, ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void acceptOrDenyOwnEmployeeRequests(int userId, int requestId, UserReimRequests userReimRequests)
			throws BusinessException, ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
