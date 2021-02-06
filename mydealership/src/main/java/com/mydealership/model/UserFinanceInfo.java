package com.mydealership.model;

import java.sql.Date;

public class UserFinanceInfo {
	private int offerId;
	private int carId;
	private int userId;
	private float principalLoan;
	private int loanLength;
	private int creditScore;
	private double apr;
	private boolean isAccepted;
	private Date offerDate;
	
	public UserFinanceInfo() {
		super();
	}

	public UserFinanceInfo(int offerId, int carId, int userId, float principalLoan, int loanLength, double apr,
			int creditScore, boolean isAccepted, Date offerDate) {
		super();
		this.offerId = offerId;
		this.carId = carId;
		this.userId = userId;
		this.principalLoan = principalLoan;
		this.loanLength = loanLength;
		this.apr = apr;
		this.creditScore = creditScore;
		this.isAccepted = isAccepted;
		this.offerDate = offerDate;
	}

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public float getPrincipalLoan() {
		return principalLoan;
	}

	public void setPrincipalLoan(float principalLoan) {
		this.principalLoan = principalLoan;
	}

	public int getLoanLength() {
		return loanLength;
	}

	public void setLoanLength(int loanLength) {
		this.loanLength = loanLength;
	}

	public double getApr() {
		return apr;
	}

	public void setApr(double apr) {
		this.apr = apr;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	public Date getOfferDate() {
		return offerDate;
	}

	public void setOfferDate(Date offerDate) {
		this.offerDate = offerDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(apr);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + carId;
		result = prime * result + creditScore;
		result = prime * result + (isAccepted ? 1231 : 1237);
		result = prime * result + loanLength;
		result = prime * result + ((offerDate == null) ? 0 : offerDate.hashCode());
		result = prime * result + offerId;
		result = prime * result + Float.floatToIntBits(principalLoan);
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserFinanceInfo other = (UserFinanceInfo) obj;
		if (Double.doubleToLongBits(apr) != Double.doubleToLongBits(other.apr))
			return false;
		if (carId != other.carId)
			return false;
		if (creditScore != other.creditScore)
			return false;
		if (isAccepted != other.isAccepted)
			return false;
		if (loanLength != other.loanLength)
			return false;
		if (offerDate == null) {
			if (other.offerDate != null)
				return false;
		} else if (!offerDate.equals(other.offerDate))
			return false;
		if (offerId != other.offerId)
			return false;
		if (Float.floatToIntBits(principalLoan) != Float.floatToIntBits(other.principalLoan))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserFinanceInfo [offerId=" + offerId + ", carId=" + carId + ", userId=" + userId + ", principalLoan="
				+ principalLoan + ", loanLength=" + loanLength + ", apr=" + apr + ", creditScore=" + creditScore
				+ ", isAccepted=" + isAccepted + ", offerDate=" + offerDate + "]";
	}
	
	

}
