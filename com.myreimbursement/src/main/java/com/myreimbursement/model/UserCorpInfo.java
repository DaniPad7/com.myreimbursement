package com.myreimbursement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_corporate_info", schema = "myreimbursement")
public class UserCorpInfo {
	@Id
	@Column(nullable = false)
	private String username;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", unique = true, referencedColumnName = "user_id")
	private UserPersonalInfo userId;
	@Column(nullable = false)
	private String password;
	@Column(name = "is_manager", nullable = false)
	private boolean isManager;
	
	public UserCorpInfo() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserPersonalInfo getUserId() {
		return userId;
	}

	public void setUserId(UserPersonalInfo userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isManager ? 1231 : 1237);
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		UserCorpInfo other = (UserCorpInfo) obj;
		if (isManager != other.isManager)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserCorpInfo [username=" + username + ", userId=" + userId + ", password=" + password + ", isManager="
				+ isManager + "]";
	}

	

	
	

}
