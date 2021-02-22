package com.myreimbursement.repository.impl;

import java.io.IOException;

import javax.servlet.ServletException;

import org.hibernate.HibernateException;

import com.myreimbursement.exceptions.BusinessException;
import com.myreimbursement.model.UserReimAwarded;
import com.myreimbursement.model.UserReimRequests;
import com.myreimbursement.repository.InsertRepository;

public class InsertRepositoryImpl implements InsertRepository{

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
