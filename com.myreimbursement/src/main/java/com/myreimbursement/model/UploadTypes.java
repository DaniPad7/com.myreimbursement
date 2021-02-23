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
@Table(name = "upload_types", schema = "myreimbursement")
public class UploadTypes {
	@Id
	@Column(name = "upload_type_id")
	@GeneratedValue(generator = "upload_type_id_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(allocationSize = 1, name = "upload_type_id_seq", sequenceName = "upload_type_id_seq")
	private int uploadTypeId;
	@OneToMany(mappedBy = "uploadTypeId")
	private Set<UserReimRequests> userReimRequests;
	@Column(name = "upload_name")
	private String uploadName;
	
	public UploadTypes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUploadTypeId() {
		return uploadTypeId;
	}

	public void setUploadTypeId(int uploadTypeId) {
		this.uploadTypeId = uploadTypeId;
	}

	public String getUploadName() {
		return uploadName;
	}

	public void setUploadName(String uploadName) {
		this.uploadName = uploadName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((uploadName == null) ? 0 : uploadName.hashCode());
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
		UploadTypes other = (UploadTypes) obj;
		if (uploadName == null) {
			if (other.uploadName != null)
				return false;
		} else if (!uploadName.equals(other.uploadName))
			return false;
		if (uploadTypeId != other.uploadTypeId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UploadTypes [uploadTypeId=" + uploadTypeId + ", uploadName=" + uploadName + "]";
	}
	
	
 
}
