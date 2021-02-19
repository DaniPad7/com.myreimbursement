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
@Table(name = "user_reim_awarded", schema = "myreimbursement")
public class UserReimAwarded {
	@Id
	@Column(name = "award_id")
	@GeneratedValue(generator = "award_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize = 1, name = "award_id_seq", sequenceName = "award_id_seq")
	private int award_id;
	@Column(name = "request_id", unique = true)
	private int requestId;
	@Column(name = "award_amount", nullable = false)
	private float awardAmount;
	@Column(name = "awarded_by", nullable = false)
	private int awardedBy;
	@Column(name = "award_date")
	private Date awardDate;
	
	public UserReimAwarded() {
		super();
	}
	
	public int getAward_id() {
		return award_id;
	}
	public void setAward_id(int award_id) {
		this.award_id = award_id;
	}
	public int getRequest_id() {
		return requestId;
	}
	public void setRequest_id(int request_id) {
		this.requestId = request_id;
	}
	public float getAwardAmount() {
		return awardAmount;
	}
	public void setAwardAmount(float awardAmount) {
		this.awardAmount = awardAmount;
	}
	public int getAwardedBy() {
		return awardedBy;
	}
	public void setAwardedBy(int awardedBy) {
		this.awardedBy = awardedBy;
	}
	public Date getAward_date() {
		return awardDate;
	}
	public void setAward_date(Date award_date) {
		this.awardDate = award_date;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(awardAmount);
		result = prime * result + ((awardDate == null) ? 0 : awardDate.hashCode());
		result = prime * result + award_id;
		result = prime * result + awardedBy;
		result = prime * result + requestId;
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
		if (award_id != other.award_id)
			return false;
		if (awardedBy != other.awardedBy)
			return false;
		if (requestId != other.requestId)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "UserReimAwarded [award_id=" + award_id + ", request_id=" + requestId + ", awardAmount=" + awardAmount
				+ ", awardedBy=" + awardedBy + ", award_date=" + awardDate + "]";
	}
	
	

}
