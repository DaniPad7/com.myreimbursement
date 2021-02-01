package com.mydealership.model;

public class UserCorpInfo {
	private int userId;
	private String username;
	private String password;
	private boolean isEmployee;
	
	public UserCorpInfo() {
		super();
	}

	public UserCorpInfo(int userId, String username, String password, boolean isEmployee) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.isEmployee = isEmployee;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEmployee() {
		return isEmployee;
	}

	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isEmployee ? 1231 : 1237);
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + userId;
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
		if (isEmployee != other.isEmployee)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId != other.userId)
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
		return "UserCorpInfo [userId=" + userId + ", username=" + username + ", password=" + password + ", isEmployee="
				+ isEmployee + "]";
	}
	
	

}
