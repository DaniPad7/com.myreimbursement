package com.myreimbursement.service.impl;

import java.io.IOException;

import javax.servlet.ServletException;

import com.myreimbursement.exceptions.BusinessException;
import com.myreimbursement.model.UserPersonalInfo;
import com.myreimbursement.model.UserReimRequests;
import com.myreimbursement.repository.UpdateRepository;
import com.myreimbursement.repository.impl.UpdateRepositoryImpl;
import com.myreimbursement.service.InsertService;
import com.myreimbursement.service.UpdateService;
import com.myreimbursement.util.factory.UserReimAwardedFactory;

public class UpdateServiceImpl implements UpdateService{
	private UpdateRepository updateRepository = new UpdateRepositoryImpl();
	private InsertService insertService = new InsertServiceImpl();
	private UserReimAwardedFactory uraf = new UserReimAwardedFactory();

	@Override
	public void uploadRequestReceiptImage(UserReimRequests userReimRequest)
			throws BusinessException, ServletException, IOException {
		updateRepository.uploadRequestReceiptImage(userReimRequest);
		
	}

	@Override
	public void updateOwnInformation(UserPersonalInfo userPersonalInfo)
			throws BusinessException, ServletException, IOException {
		updateRepository.updateOwnInformation(userPersonalInfo);
		
	}

	@Override
	public void acceptOrDenyOwnEmployeeRequests(int userId, UserReimRequests userReimRequests)
			throws BusinessException, ServletException, IOException {
		if(userReimRequests.isAwarded() == true) {
			updateRepository.acceptOrDenyOwnEmployeeRequests(userId, userReimRequests);
			uraf.setUserReimAwarded(userId, userReimRequests);
			insertService.createUserReimAwarded(uraf.getUserReimAwarded());
		}
		
	}

}
