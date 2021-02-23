package com.myreimbursement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user_business_info", schema = "myreimbursement")
public class UserBusinessInfo {
	@Id
	@Column(name = "business_id")
	@GeneratedValue(generator = "business_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize = 1, name = "business_id_seq", sequenceName = "business_id_seq")
	private int businessId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false, referencedColumnName = "user_id")
	private UserPersonalInfo userId;
	@Column(name = "department_name", nullable = false)
	private String departmentName;
	@Column(nullable = false)
	private String position;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "reports_to", nullable = false, referencedColumnName = "user_id")
	private UserPersonalInfo reportsTo;
	
	public UserBusinessInfo() {
		super();
	}

	public int getBusinessId() {
		return businessId;
	}

	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}

	public UserPersonalInfo getUserId() {
		return userId;
	}

	public void setUserId(UserPersonalInfo userId) {
		this.userId = userId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public UserPersonalInfo getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(UserPersonalInfo reportsTo) {
		this.reportsTo = reportsTo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + businessId;
		result = prime * result + ((departmentName == null) ? 0 : departmentName.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((reportsTo == null) ? 0 : reportsTo.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		UserBusinessInfo other = (UserBusinessInfo) obj;
		if (businessId != other.businessId)
			return false;
		if (departmentName == null) {
			if (other.departmentName != null)
				return false;
		} else if (!departmentName.equals(other.departmentName))
			return false;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (reportsTo == null) {
			if (other.reportsTo != null)
				return false;
		} else if (!reportsTo.equals(other.reportsTo))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserBusinessInfo [businessId=" + businessId + ", userId=" + userId + ", departmentName="
				+ departmentName + ", position=" + position + ", reportsTo=" + reportsTo + "]";
	}
	
	
	
	

}
