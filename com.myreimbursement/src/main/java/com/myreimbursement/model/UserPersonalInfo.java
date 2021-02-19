package com.myreimbursement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user_personal_info", schema = "myreimbursement")
public class UserPersonalInfo {
@Id
@Column(name = "user_id")
@GeneratedValue(generator = "user_id_seq", strategy = GenerationType.AUTO)
@SequenceGenerator(allocationSize = 1, name = "user_id_seq", sequenceName = "user_id_seq")
private int userId;
@Column(name = "first_name", nullable = false)
private String firstName;
@Column(name = "last_name", nullable = false)
private String lastname;
@Column
private String email;
@Column(name = "phone_number", nullable = true)
private String phoneNumber;
@Column(nullable = false)
private String city;
@Column(nullable = false)
private String state;
@Column(nullable = false)
private String country;

public UserPersonalInfo() {
	super();
}

public int getUserId() {

	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((city == null) ? 0 : city.hashCode());
	result = prime * result + ((country == null) ? 0 : country.hashCode());
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
	result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
	result = prime * result + ((state == null) ? 0 : state.hashCode());
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
	UserPersonalInfo other = (UserPersonalInfo) obj;
	if (city == null) {
		if (other.city != null)
			return false;
	} else if (!city.equals(other.city))
		return false;
	if (country == null) {
		if (other.country != null)
			return false;
	} else if (!country.equals(other.country))
		return false;
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	if (firstName == null) {
		if (other.firstName != null)
			return false;
	} else if (!firstName.equals(other.firstName))
		return false;
	if (lastname == null) {
		if (other.lastname != null)
			return false;
	} else if (!lastname.equals(other.lastname))
		return false;
	if (phoneNumber == null) {
		if (other.phoneNumber != null)
			return false;
	} else if (!phoneNumber.equals(other.phoneNumber))
		return false;
	if (state == null) {
		if (other.state != null)
			return false;
	} else if (!state.equals(other.state))
		return false;
	if (userId != other.userId)
		return false;
	return true;
}



@Override
public String toString() {
	return "UserPersonalInfo [userId=" + userId + ", firstName=" + firstName + ", lastname=" + lastname + ", email="
			+ email + ", phoneNumber=" + phoneNumber + ", city=" + city + ", state=" + state + ", country=" + country
			+ "]";
}



}
