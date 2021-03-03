package com.myreimbursement.repository.impl;

import java.io.IOException;

import javax.servlet.ServletException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myreimbursement.exceptions.BusinessException;
import com.myreimbursement.model.UserPersonalInfo;
import com.myreimbursement.model.UserReimRequests;
import com.myreimbursement.repository.UpdateRepository;
import com.myreimbursement.util.HibernateSessionFactory;

public class UpdateRepositoryImpl implements UpdateRepository{

	@Override
	public void uploadRequestReceiptImage(UserReimRequests userReimRequest)
			throws BusinessException, ServletException, IOException {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.update(userReimRequest);
			transaction.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}
		
	}

	@Override
	public void updateOwnInformation(UserPersonalInfo userPersonalInfo)
			throws BusinessException, HibernateException, ServletException, IOException {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.update(userPersonalInfo);
			transaction.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}
		
	}

	@Override
	public void acceptOrDenyOwnEmployeeRequests(int userId, UserReimRequests userReimRequests)
			throws BusinessException, HibernateException, ServletException, IOException {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.update(userReimRequests);
			//do an automatic save(userReimAwarded)
			transaction.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}
		
	}

}
