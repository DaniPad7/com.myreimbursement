package com.myreimbursement.service.impl;

import java.io.IOException;

import javax.servlet.ServletException;

import org.hibernate.HibernateException;

import com.myreimbursement.exceptions.BusinessException;
import com.myreimbursement.model.UserReimAwarded;
import com.myreimbursement.model.UserReimRequests;
import com.myreimbursement.model.UserReimbursement;
import com.myreimbursement.repository.InsertRepository;
import com.myreimbursement.repository.impl.InsertRepositoryImpl;
import com.myreimbursement.service.InsertService;

public class InsertServiceImpl implements InsertService{
	private InsertRepository insertRepository = new InsertRepositoryImpl();

	@Override
	public void submitReimbursementRequest(UserReimRequests userReimRequests)
			throws BusinessException, ServletException, IOException {
		insertRepository.submitReimbursementRequest(userReimRequests);
		
	}

	@Override
	public void createUserReimAwarded(UserReimAwarded userReimAwarded)
			throws BusinessException, ServletException, IOException {
		if(userReimAwarded != null) {
		insertRepository.createUserReimAwarded(userReimAwarded);
		}
		else{
			throw new BusinessException();
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
