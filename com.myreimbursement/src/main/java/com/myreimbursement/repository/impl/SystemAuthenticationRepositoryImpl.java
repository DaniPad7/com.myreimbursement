package com.myreimbursement.repository.impl;

import java.io.IOException;

import javax.servlet.ServletException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myreimbursement.exceptions.BusinessException;
import com.myreimbursement.model.UserCorpInfo;
import com.myreimbursement.repository.SystemAuthenticationRepository;
import com.myreimbursement.util.HibernateSessionFactory;

public class SystemAuthenticationRepositoryImpl implements SystemAuthenticationRepository{

	@Override
	public UserCorpInfo login(String username, String password)
			throws BusinessException, HibernateException, ServletException, IOException {
		UserCorpInfo retrievedUCI = null;
		Session session = null;
		Transaction transaction = null;
		try{
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			retrievedUCI = session.createQuery("FROM UserCorpInfo WHERE username = :username AND password = :password",
					UserCorpInfo.class)
					.setParameter("username", username).setParameter("password", password).getSingleResult();
			
		}catch(HibernateException e){
			e.printStackTrace();
			transaction.rollback();
		}finally {
				
		}
		return retrievedUCI;
		
	}

	@Override
	public void logout() throws BusinessException, HibernateException, ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
