package com.myreimbursement.service.impl;

import java.io.IOException;

import javax.servlet.ServletException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myreimbursement.exceptions.BusinessException;
import com.myreimbursement.model.UserCorpInfo;
import com.myreimbursement.service.SystemAuthenticationService;
import com.myreimbursement.util.HibernateSessionFactory;

public class SystemAuthenticationServiceImpl implements SystemAuthenticationService{

	@Override
	public int login(String email, String password)
			throws BusinessException, HibernateException, ServletException, IOException {
		int idRetriever = 0;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			//It is as if the table was joined with UserPersonalInfo and the PK was returned. I can use this to improve my queries
			idRetriever = session.get(UserCorpInfo.class, email).getUserId().getUserId();
		}catch(HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}
		return idRetriever;
	}

	@Override
	public void logout() throws BusinessException, HibernateException, ServletException, IOException {
		Session session = null;
		Transaction transaction = null;
		try {
			/*if() {
				do something with Servlet Session here.
			}*/
		}catch(HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}
		
	}

}
