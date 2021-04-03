package com.user.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
public class UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	@NotBlank(message = "firstname is mandatory")
	private String firstName;
	@NotBlank(message = "lastname is mandatory")
	private String lastName;
	@Column(unique = true)
	private String userName;
	@Column
	private Long mobileNumber;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dateOfBirth;
 
	public String getFirstName() {
		return firstName;
	}  

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
