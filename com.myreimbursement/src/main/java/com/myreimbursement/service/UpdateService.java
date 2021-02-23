package com.myreimbursement.service;

import java.io.IOException;

import javax.servlet.ServletException;

import org.hibernate.HibernateException;

import com.myreimbursement.exceptions.BusinessException;
import com.myreimbursement.model.UserPersonalInfo;
import com.myreimbursement.model.UserReimRequests;

public interface UpdateService {
	void uploadRequestReceiptImage(UserReimRequests userReimRequest) throws BusinessException, ServletException, IOException;
	void updateOwnInformation(UserPersonalInfo userPersonalInfo) throws BusinessException, ServletException, IOException;
	void acceptOrDenyOwnEmployeeRequests(int userId, int requestId, UserReimRequests userReimRequests) throws BusinessException, ServletException, IOException;
	//int employeeResetPassword() throws BusinessException, ServletException, IOException;
}
