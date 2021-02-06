package com.mydealership.model;

import java.sql.Date;

public class UsersTransactionHistory {
	private int transactionId;
	private int userId;
	private int carId;
	private float amount;
	private float remainingBalance;
	private float nextPayment;
	private int paymentsLeft;
	private Date transactionDate;
	
	public UsersTransactionHistory() {
		super();
	}

	public UsersTransactionHistory(int transactionId, int userId, int carId, float amount, float remainingBalance,
			float nextPayment, int paymentsLeft, Date transactionDate) {
		super();
		this.transactionId = transactionId;
		this.userId = userId;
		this.carId = carId;
		this.amount = amount;
		this.remainingBalance = remainingBalance;
		this.nextPayment = nextPayment;
		this.paymentsLeft = paymentsLeft;
		this.transactionDate = transactionDate;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public float getRemainingBalance() {
		return remainingBalance;
	}

	public void setRemainingBalance(float remainingBalance) {
		this.remainingBalance = remainingBalance;
	}

	public float getNextPayment() {
		return nextPayment;
	}

	public void setNextPayment(float nextPayment) {
		this.nextPayment = nextPayment;
	}

	public int getPaymentsLeft() {
		return paymentsLeft;
	}

	public void setPaymentsLeft(int paymentsLeft) {
		this.paymentsLeft = paymentsLeft;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + carId;
		result = prime * result + Float.floatToIntBits(nextPayment);
		result = prime * result + paymentsLeft;
		result = prime * result + Float.floatToIntBits(remainingBalance);
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
		result = prime * result + transactionId;
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
		UsersTransactionHistory other = (UsersTransactionHistory) obj;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (carId != other.carId)
			return false;
		if (Float.floatToIntBits(nextPayment) != Float.floatToIntBits(other.nextPayment))
			return false;
		if (paymentsLeft != other.paymentsLeft)
			return false;
		if (Float.floatToIntBits(remainingBalance) != Float.floatToIntBits(other.remainingBalance))
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		if (transactionId != other.transactionId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsersTransactionHistory [transactionId=" + transactionId + ", userId=" + userId + ", carId=" + carId
				+ ", amount=" + amount + ", remainingBalance=" + remainingBalance + ", nextPayment=" + nextPayment
				+ ", paymentsLeft=" + paymentsLeft + ", transactionDate=" + transactionDate + "]";
	}

	
	
	

}
