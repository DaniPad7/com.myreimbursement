package com.myreimbursement.repository.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myreimbursement.exceptions.BusinessException;
import com.myreimbursement.model.UserBusinessInfo;
import com.myreimbursement.model.UserPersonalInfo;
import com.myreimbursement.model.UserReimAwarded;
import com.myreimbursement.model.UserReimRequests;
import com.myreimbursement.repository.ViewRepository;
import com.myreimbursement.util.HibernateSessionFactory;

public class ViewRepositoryImpl implements ViewRepository{

	@Override
	public List<UserReimRequests> viewPendingReimbursementRequests(int userId)
			throws BusinessException, ServletException, IOException {
		List<UserReimRequests> pendingRequests = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			pendingRequests = session.createQuery("FROM user_reim_requests WHERE is_awarded = false AND reimbursement_id = " + userId, UserReimRequests.class).getResultList();
			transaction.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}
		return pendingRequests;
	}

	@Override
	public List<UserReimRequests> viewResolvedReimbursementRequests(int userId)
			throws BusinessException, ServletException, IOException {
		List<UserReimRequests> resolvedRequests = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			resolvedRequests = session.createQuery("FROM user_reim_requests WHERE is_awarded = true AND reimbursement_id = " + userId, UserReimRequests.class).getResultList();
			transaction.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}
		return resolvedRequests;
	}

	@Override
	public UserPersonalInfo viewOwnInformation(int userId)
			throws BusinessException, ServletException, IOException {
		UserPersonalInfo userPersonalInfo = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			userPersonalInfo = session.get(UserPersonalInfo.class, userId);
			transaction.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			//session.close();
		}
		return userPersonalInfo;
	}

	@Override
	public List<UserReimRequests> viewAllPendingRequestsOwnEmployees(int userId)
			throws BusinessException, ServletException, IOException {
		List<UserReimRequests> pendingRequests = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			pendingRequests = session.createQuery("FROM user_reim_requests WHERE is_awarded = false", UserReimRequests.class).getResultList();
			transaction.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}
		return pendingRequests;
	}

	@Override
	public List<File> viewAllImageReceiptRequests()
			throws BusinessException, ServletException, IOException {
		/*List<File> receiptImages = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			receiptImages = session.createQuery("FROM user_reim_requests WHERE is_awarded = false", UserReimRequests.class).getResultList();
			transaction.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}*/
		return null;
	}

	@Override
	public List<UserReimAwarded> viewAllResolvedRequestsManagers()
			throws BusinessException, ServletException, IOException {
		List<UserReimAwarded> awardedRequests = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			awardedRequests = session.createQuery("FROM user_reim_awarded", UserReimAwarded.class).getResultList();
			transaction.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}
		return awardedRequests;
	}

	@Override
	public List<UserBusinessInfo> viewAllEmployessTheirManagers()
			throws BusinessException, ServletException, IOException {
		List<UserBusinessInfo> userBusinessInfo = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			userBusinessInfo = session.createQuery("FROM UserBusinessInfo", UserBusinessInfo.class).getResultList();
			transaction.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			//session.close();
		}
		return userBusinessInfo;
	}

	@Override
	public UserReimRequests viewSingleEmployeeRequest(int userId, int requestId)
			throws BusinessException, ServletException, IOException {
		UserReimRequests userReimRequest = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			userReimRequest = session.createQuery("FROM user_reim_requests WHERE reimbursement_id ANY(SELECT user_id FROM user_business_info WHERE reports_to ="+ userId + ") AND request_id =" + requestId, UserReimRequests.class).getSingleResult();
			transaction.commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			session.close();
		}
		return userReimRequest;
	}

}
