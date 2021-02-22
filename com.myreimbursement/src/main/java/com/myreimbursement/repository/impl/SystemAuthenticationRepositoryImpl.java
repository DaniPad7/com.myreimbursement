package com.myreimbursement.repository.impl;

import java.io.IOException;

import javax.servlet.ServletException;

import org.hibernate.HibernateException;

import com.myreimbursement.exceptions.BusinessException;
import com.myreimbursement.model.UserCorpInfo;
import com.myreimbursement.repository.SystemAuthenticationRepository;

public class SystemAuthenticationRepositoryImpl implements SystemAuthenticationRepository{

	@Override
	public UserCorpInfo login(String email, String password)
			throws BusinessException, HibernateException, ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void logout() throws BusinessException, HibernateException, ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
