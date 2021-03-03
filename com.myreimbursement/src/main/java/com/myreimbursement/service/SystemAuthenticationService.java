package com.myreimbursement.service;

import java.io.IOException;

import javax.servlet.ServletException;

import org.hibernate.HibernateException;

import com.myreimbursement.exceptions.BusinessException;
import com.myreimbursement.model.UserCorpInfo;

public interface SystemAuthenticationService {
	UserCorpInfo login(String username, String password) throws BusinessException, ServletException, IOException;
	void logout() throws BusinessException, ServletException, IOException;

}
