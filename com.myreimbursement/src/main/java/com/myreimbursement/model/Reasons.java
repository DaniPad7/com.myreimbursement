package com.myreimbursement.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "reasons", schema = "myreimbursement")
public class Reasons {
	@Id
	@Column(name = "reason_id")
	@GeneratedValue(generator = "reason_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize = 1, name = "reason_id_seq", sequenceName = "reason_id_seq")
	private int reasonId;
	@OneToMany(mappedBy = "reasonId")
	private Set<UserReimRequests> userReimRequests;
	@Column(name = "reason_name")
	private String reasonName;
	
	public Reasons() {
		super();
	}
	public int getReasonId() {
		return reasonId;
	}
	public void setReasonId(int reasonId) {
		this.reasonId = reasonId;
	}
	public String getReasonName() {
		return reasonName;
	}
	public void setReasonName(String reasonName) {
		this.reasonName = reasonName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + reasonId;
		result = prime * result + ((reasonName == null) ? 0 : reasonName.hashCode());
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
		Reasons other = (Reasons) obj;
		if (reasonId != other.reasonId)
			return false;
		if (reasonName == null) {
			if (other.reasonName != null)
				return false;
		} else if (!reasonName.equals(other.reasonName))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Reasons [reasonId=" + reasonId + ", reasonName=" + reasonName + "]";
	}
	
	

}
