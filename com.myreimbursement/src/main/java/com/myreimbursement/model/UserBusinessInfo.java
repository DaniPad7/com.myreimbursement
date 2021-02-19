package com.myreimbursement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Column(name = "user_id", nullable = false)
	private int userId;
	@Column(name = "department_name", nullable = false)
	private String departmentName;
	@Column(nullable = false)
	private String position;
	@Column(name = "reports_to", nullable = false)
	private int reportsTo;
	public UserBusinessInfo() {
		super();
	}
	public int getBusinessId() {
		return businessId;
	}
	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
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
	public int getReportsTo() {
		return reportsTo;
	}
	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + businessId;
		result = prime * result + ((departmentName == null) ? 0 : departmentName.hashCode());
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		result = prime * result + reportsTo;
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
		if (reportsTo != other.reportsTo)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserBusinessInfo [businessId=" + businessId + ", userId=" + userId + ", departmentName="
				+ departmentName + ", position=" + position + ", reportsTo=" + reportsTo + "]";
	}
	
	

}
