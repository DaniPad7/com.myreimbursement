package com.myreimbursement.model;

import java.io.File;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user_reim_requests", schema = "myreimbursement")
public class UserReimRequests {
	@Id
	@Column(name = "request_id")
	@GeneratedValue(generator = "request_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize = 1, name = "request_id_seq", sequenceName = "request_id_seq")
	private int requestId;
	@Column(name = "reimbursement_id", nullable = false)
	private int reimbursementId;
	@Column(name = "reason_id", nullable = false)
	private int reasonId;
	@Column(name = "upload_type_id", nullable = false)
	private int uploadTypeId;
	@Column(nullable = false)
	private File upload;
	@Column(nullable = false)
	private float amount;
	@Column(name = "is_awarded", nullable = false)
	private boolean isAwarded;
	@Column(name = "request_date")
	private Date requestDate;
	
	public UserReimRequests() {
		super();
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getReimbursementId() {
		return reimbursementId;
	}
	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}
	public int getReasonId() {
		return reasonId;
	}
	public void setReasonId(int reasonId) {
		this.reasonId = reasonId;
	}
	public int getUploadTypeId() {
		return uploadTypeId;
	}
	public void setUploadTypeId(int uploadTypeId) {
		this.uploadTypeId = uploadTypeId;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public boolean isAwarded() {
		return isAwarded;
	}
	public void setAwarded(boolean isAwarded) {
		this.isAwarded = isAwarded;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + (isAwarded ? 1231 : 1237);
		result = prime * result + reasonId;
		result = prime * result + reimbursementId;
		result = prime * result + ((requestDate == null) ? 0 : requestDate.hashCode());
		result = prime * result + requestId;
		result = prime * result + ((upload == null) ? 0 : upload.hashCode());
		result = prime * result + uploadTypeId;
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
		UserReimRequests other = (UserReimRequests) obj;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (isAwarded != other.isAwarded)
			return false;
		if (reasonId != other.reasonId)
			return false;
		if (reimbursementId != other.reimbursementId)
			return false;
		if (requestDate == null) {
			if (other.requestDate != null)
				return false;
		} else if (!requestDate.equals(other.requestDate))
			return false;
		if (requestId != other.requestId)
			return false;
		if (upload == null) {
			if (other.upload != null)
				return false;
		} else if (!upload.equals(other.upload))
			return false;
		if (uploadTypeId != other.uploadTypeId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserReimRequests [requestId=" + requestId + ", reimbursementId=" + reimbursementId + ", reasonId="
				+ reasonId + ", uploadTypeId=" + uploadTypeId + ", upload=" + upload + ", amount=" + amount
				+ ", isAwarded=" + isAwarded + ", requestDate=" + requestDate + "]";
	}
	
	

}
