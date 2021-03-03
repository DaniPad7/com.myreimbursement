package com.myreimbursement.service.impl;

import java.io.IOException;

import javax.servlet.ServletException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myreimbursement.exceptions.BusinessException;
import com.myreimbursement.model.UserCorpInfo;
import com.myreimbursement.repository.SystemAuthenticationRepository;
import com.myreimbursement.repository.impl.SystemAuthenticationRepositoryImpl;
import com.myreimbursement.service.SystemAuthenticationService;
import com.myreimbursement.util.HibernateSessionFactory;

public class SystemAuthenticationServiceImpl implements SystemAuthenticationService{
	private SystemAuthenticationRepository systemAuthRepo = new SystemAuthenticationRepositoryImpl();

	@Override
	public UserCorpInfo login(String username, String password)
			throws BusinessException, HibernateException, ServletException, IOException {
		UserCorpInfo retrievedUCI = null;
		//It is as if the table was joined with UserPersonalInfo and the PK was returned. I can use this to improve my queries
		//	if(username.matches("^[A-Za-z0-9]{10}$") && password.matches("^[A-Za-z0-9]{10}$")) {
				retrievedUCI = systemAuthRepo.login(username, password);
				if(retrievedUCI != null) {
					retrievedUCI.setPassword("");
					retrievedUCI.setUsername("");
				}
		//	}
			
		return retrievedUCI;
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
