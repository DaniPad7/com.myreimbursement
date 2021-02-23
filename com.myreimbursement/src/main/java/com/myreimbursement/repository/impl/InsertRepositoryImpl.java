package com.myreimbursement.repository.impl;

import java.io.IOException;

import javax.servlet.ServletException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myreimbursement.exceptions.BusinessException;
import com.myreimbursement.model.UserReimAwarded;
import com.myreimbursement.model.UserReimRequests;
import com.myreimbursement.model.UserReimbursement;
import com.myreimbursement.repository.InsertRepository;
import com.myreimbursement.util.HibernateSessionFactory;

public class InsertRepositoryImpl implements InsertRepository{

	@Override
	public void submitReimbursementRequest(UserReimRequests userReimRequests)
			throws BusinessException, ServletException, IOException {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.save(userReimRequests);
			transaction.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}
		
	}

	@Override
	public void createUserReimAwarded(UserReimAwarded userReimAwarded)
			throws BusinessException, ServletException, IOException {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.save(userReimAwarded);
			transaction.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}
		
	}

	/*@Override
	public void employeeRegistration() throws BusinessException, ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUserReimbursement(UserReimbursement userReimbursement)
			throws BusinessException, ServletException, IOException {
		// TODO Auto-generated method stub
		
	}*/

}
