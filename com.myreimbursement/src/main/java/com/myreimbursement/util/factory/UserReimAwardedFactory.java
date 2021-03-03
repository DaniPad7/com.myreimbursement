package com.myreimbursement.util.factory;

import java.sql.Date;

import com.myreimbursement.model.UserPersonalInfo;
import com.myreimbursement.model.UserReimAwarded;
import com.myreimbursement.model.UserReimRequests;

public class UserReimAwardedFactory {
	private UserReimAwarded ura = new UserReimAwarded();
	
	public void setUserReimAwarded(int userId, UserReimRequests urr) {
		UserPersonalInfo uri = new UserPersonalInfo();
		uri.setUserId(userId);
		
		ura.setAward_id(0);
		ura.setRequestId(urr);
		ura.setAwardAmount(urr.getAmount());
		ura.setAwardedBy(uri);
		ura.setAwardDate(Date.valueOf("2005-05-05"));
		
	}
	
	public UserReimAwarded getUserReimAwarded() {
		return ura;
	}

}
