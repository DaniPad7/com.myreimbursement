package com.myreimbursement.model;

import java.io.File;
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
@Table(name = "user_reim_requests", schema = "myreimbursement")
public class UserReimRequests {
	@Id
	@Column(name = "request_id")
	@GeneratedValue(generator = "request_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize = 1, name = "request_id_seq", sequenceName = "request_id_seq")
	private int requestId;
	@OneToOne(mappedBy = "requestId")
	private UserReimAwarded userReimAwarded;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "reimbursement_id", nullable = false, referencedColumnName = "reimbursement_id")
	private UserReimbursement reimbursementId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "reason_id", nullable = false, referencedColumnName = "reason_id")
	private Reasons reasonId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "upload_type_id", nullable = false, referencedColumnName = "upload_type_id")
	private UploadTypes uploadTypeId;
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

	public UserReimAwarded getUserReimAwarded() {
		return userReimAwarded;
	}

	public void setUserReimAwarded(UserReimAwarded userReimAwarded) {
		this.userReimAwarded = userReimAwarded;
	}

	public UserReimbursement getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(UserReimbursement reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public Reasons getReasonId() {
		return reasonId;
	}

	public void setReasonId(Reasons reasonId) {
		this.reasonId = reasonId;
	}

	public UploadTypes getUploadTypeId() {
		return uploadTypeId;
	}

	public void setUploadTypeId(UploadTypes uploadTypeId) {
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
		result = prime * result + ((reasonId == null) ? 0 : reasonId.hashCode());
		result = prime * result + ((reimbursementId == null) ? 0 : reimbursementId.hashCode());
		result = prime * result + ((requestDate == null) ? 0 : requestDate.hashCode());
		result = prime * result + requestId;
		result = prime * result + ((upload == null) ? 0 : upload.hashCode());
		result = prime * result + ((uploadTypeId == null) ? 0 : uploadTypeId.hashCode());
		result = prime * result + ((userReimAwarded == null) ? 0 : userReimAwarded.hashCode());
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
		if (reasonId == null) {
			if (other.reasonId != null)
				return false;
		} else if (!reasonId.equals(other.reasonId))
			return false;
		if (reimbursementId == null) {
			if (other.reimbursementId != null)
				return false;
		} else if (!reimbursementId.equals(other.reimbursementId))
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
		if (uploadTypeId == null) {
			if (other.uploadTypeId != null)
				return false;
		} else if (!uploadTypeId.equals(other.uploadTypeId))
			return false;
		if (userReimAwarded == null) {
			if (other.userReimAwarded != null)
				return false;
		} else if (!userReimAwarded.equals(other.userReimAwarded))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserReimRequests [requestId=" + requestId + ", userReimAwarded=" + userReimAwarded
				+ ", reimbursementId=" + reimbursementId + ", reasonId=" + reasonId + ", uploadTypeId=" + uploadTypeId
				+ ", upload=" + upload + ", amount=" + amount + ", isAwarded=" + isAwarded + ", requestDate="
				+ requestDate + "]";
	}
	
	
	
	

}
