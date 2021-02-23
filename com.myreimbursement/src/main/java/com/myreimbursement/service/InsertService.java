package com.myreimbursement.service;

import java.io.IOException;

import javax.servlet.ServletException;

import org.hibernate.HibernateException;

import com.myreimbursement.exceptions.BusinessException;
import com.myreimbursement.model.UserReimAwarded;
import com.myreimbursement.model.UserReimRequests;
import com.myreimbursement.model.UserReimbursement;

public interface InsertService {
	void submitReimbursementRequest(UserReimRequests userReimRequests) throws BusinessException, ServletException, IOException;
	void createUserReimAwarded(UserReimAwarded userReimAwarded) throws BusinessException, ServletException, IOException;
	//void employeeRegistration() throws BusinessException, ServletException, IOException;
	//void createUserReimbursement(UserReimbursement userReimbursement) throws BusinessException, ServletException, IOException;

}
