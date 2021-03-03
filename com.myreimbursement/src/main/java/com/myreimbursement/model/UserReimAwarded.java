package com.myreimbursement.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user_reim_awarded", schema = "myreimbursement")
public class UserReimAwarded {
	@Id
	@Column(name = "award_id")
	@GeneratedValue(generator = "award_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize = 1, name = "award_id_seq", sequenceName = "award_id_seq")
	private int awardId;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "request_id", unique = true, referencedColumnName = "request_id")
	private UserReimRequests requestId;
	@Column(name = "award_amount", nullable = false)
	private float awardAmount;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "awarded_by", nullable = false, referencedColumnName = "user_id")
	private UserPersonalInfo awardedBy;
	@Column(name = "award_date")
	private Date awardDate;
	
	public UserReimAwarded() {
		super();
	}

	public int getAward_id() {
		return awardId;
	}

	public void setAward_id(int award_id) {
		this.awardId = award_id;
	}

	public UserReimRequests getRequestId() {
		return requestId;
	}

	public void setRequestId(UserReimRequests requestId) {
		this.requestId = requestId;
	}

	public float getAwardAmount() {
		return awardAmount;
	}

	public void setAwardAmount(float awardAmount) {
		this.awardAmount = awardAmount;
	}

	public UserPersonalInfo getAwardedBy() {
		return awardedBy;
	}

	public void setAwardedBy(UserPersonalInfo awardedBy) {
		this.awardedBy = awardedBy;
	}

	public Date getAwardDate() {
		return awardDate;
	}

	public void setAwardDate(Date awardDate) {
		this.awardDate = awardDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(awardAmount);
		result = prime * result + ((awardDate == null) ? 0 : awardDate.hashCode());
		result = prime * result + awardId;
		result = prime * result + ((awardedBy == null) ? 0 : awardedBy.hashCode());
		result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
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
		UserReimAwarded other = (UserReimAwarded) obj;
		if (Float.floatToIntBits(awardAmount) != Float.floatToIntBits(other.awardAmount))
			return false;
		if (awardDate == null) {
			if (other.awardDate != null)
				return false;
		} else if (!awardDate.equals(other.awardDate))
			return false;
		if (awardId != other.awardId)
			return false;
		if (awardedBy == null) {
			if (other.awardedBy != null)
				return false;
		} else if (!awardedBy.equals(other.awardedBy))
			return false;
		if (requestId == null) {
			if (other.requestId != null)
				return false;
		} else if (!requestId.equals(other.requestId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserReimAwarded [award_id=" + awardId + ", requestId=" + requestId + ", awardAmount=" + awardAmount
				+ ", awardedBy=" + awardedBy + ", awardDate=" + awardDate + "]";
	}
	
	
	
	

}
