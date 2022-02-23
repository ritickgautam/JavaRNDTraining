package com.ritick.lms.model;

import java.sql.Date;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	private String name;
	private String userName;
	private String password;
	private String userEmail;
	private Date expiryDate;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String name, String userName, String password, String userEmail, Date expiryDate) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.userEmail = userEmail;
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", userName=" + userName + ", password=" + password
				+ ", userEmail=" + userEmail + ", expiryDate=" + expiryDate + "]";
	}



}
