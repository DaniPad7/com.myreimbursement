package com.myreimbursement.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user_reimbursement", schema = "myreimbursement")
public class UserReimbursement {
	@Id
	@Column(name = "reimbursement_id")
	@GeneratedValue(generator = "reimbursement_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize = 1, name = "reimbursement_id_seq", sequenceName = "reimbursement_id_seq")
	private int reimbursementId;
	@Column(name = "user_id", unique = true)
	private int userId;
	@Column(name = "available_reimbursement", nullable = false)
	private float availableReimbursement;
	@Column(name = "pending_reim")
	private float pendingReim;
	@Column(name = "awarded_reim")
	private float awardedReim;
	@Column(name = "date_created")
	private Date dateCreated;
	@Column(name = "year_cycle", nullable = false)
	private int yearCycle;
	
	public UserReimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public float getAvailableReimbursement() {
		return availableReimbursement;
	}

	public void setAvailableReimbursement(float availableReimbursement) {
		this.availableReimbursement = availableReimbursement;
	}

	public float getPendingReim() {
		return pendingReim;
	}

	public void setPendingReim(float pendingReim) {
		this.pendingReim = pendingReim;
	}

	public float getAwardedReim() {
		return awardedReim;
	}

	public void setAwardedReim(float awardedReim) {
		this.awardedReim = awardedReim;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public int getYearCycle() {
		return yearCycle;
	}

	public void setYearCycle(int yearCycle) {
		this.yearCycle = yearCycle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(availableReimbursement);
		result = prime * result + Float.floatToIntBits(awardedReim);
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + Float.floatToIntBits(pendingReim);
		result = prime * result + reimbursementId;
		result = prime * result + userId;
		result = prime * result + yearCycle;
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
		UserReimbursement other = (UserReimbursement) obj;
		if (Float.floatToIntBits(availableReimbursement) != Float.floatToIntBits(other.availableReimbursement))
			return false;
		if (Float.floatToIntBits(awardedReim) != Float.floatToIntBits(other.awardedReim))
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (Float.floatToIntBits(pendingReim) != Float.floatToIntBits(other.pendingReim))
			return false;
		if (reimbursementId != other.reimbursementId)
			return false;
		if (userId != other.userId)
			return false;
		if (yearCycle != other.yearCycle)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserReimbursement [reimbursementId=" + reimbursementId + ", userId=" + userId
				+ ", availableReimbursement=" + availableReimbursement + ", pendingReim=" + pendingReim
				+ ", awardedReim=" + awardedReim + ", dateCreated=" + dateCreated + ", yearCycle=" + yearCycle + "]";
	}
	
	
	
}
