package com.myreimbursement.repository.impl;

import java.io.IOException;

import javax.servlet.ServletException;

import org.hibernate.HibernateException;

import com.myreimbursement.exceptions.BusinessException;
import com.myreimbursement.repository.UpdateRepository;

public class UpdateRepositoryImpl implements UpdateRepository{

	@Override
	public int uploadRequestReceiptImage(int receptId)
			throws BusinessException, HibernateException, ServletException, IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOwnInformation(int userId)
			throws BusinessException, HibernateException, ServletException, IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int acceptOrDenyOwnEmployeeRequests(int userId, int requestId)
			throws BusinessException, HibernateException, ServletException, IOException {
		// TODO Auto-generated method stub
		return 0;
	}

}
