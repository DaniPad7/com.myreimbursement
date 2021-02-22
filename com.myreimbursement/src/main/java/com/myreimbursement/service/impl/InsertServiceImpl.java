package com.myreimbursement.service.impl;

import java.io.IOException;

import javax.servlet.ServletException;

import org.hibernate.HibernateException;

import com.myreimbursement.exceptions.BusinessException;
import com.myreimbursement.model.UserReimAwarded;
import com.myreimbursement.model.UserReimRequests;
import com.myreimbursement.service.InsertService;

public class InsertServiceImpl implements InsertService{

	@Override
	public int submitReimbursementRequest(UserReimRequests userReimRequests)
			throws BusinessException, HibernateException, ServletException, IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int createUserReimAwarded(UserReimAwarded userReimAwarded)
			throws BusinessException, HibernateException, ServletException, IOException {
		// TODO Auto-generated method stub
		return 0;
	}

}
