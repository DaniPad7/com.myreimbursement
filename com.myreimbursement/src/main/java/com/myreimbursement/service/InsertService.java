package com.myreimbursement.service;

import java.io.IOException;

import javax.servlet.ServletException;

import org.hibernate.HibernateException;

import com.myreimbursement.exceptions.BusinessException;
import com.myreimbursement.model.UserReimAwarded;
import com.myreimbursement.model.UserReimRequests;
import com.myreimbursement.model.UserReimbursement;

public interface InsertService {
	int submitReimbursementRequest(UserReimRequests userReimRequests) throws BusinessException, HibernateException, ServletException, IOException;
	int createUserReimAwarded(UserReimAwarded userReimAwarded) throws BusinessException, HibernateException, ServletException, IOException;
	//int employeeRegistration() throws BusinessException, HibernateException, ServletException, IOException;
	//int createUserReimbursement(UserReimbursement userReimbursement) throws BusinessException, HibernateException, ServletException, IOException;

}
