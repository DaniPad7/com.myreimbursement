package com.myreimbursement.service;

import java.io.IOException;

import javax.servlet.ServletException;

import org.hibernate.HibernateException;

import com.myreimbursement.exceptions.BusinessException;

public interface UpdateService {
	int uploadRequestReceiptImage(int receptId) throws BusinessException, HibernateException, ServletException, IOException;
	int updateOwnInformation(int userId) throws BusinessException, HibernateException, ServletException, IOException;
	int acceptOrDenyOwnEmployeeRequests(int userId, int requestId) throws BusinessException, HibernateException, ServletException, IOException;
	//int employeeResetPassword() throws BusinessException, HibernateException, ServletException, IOException;
}
