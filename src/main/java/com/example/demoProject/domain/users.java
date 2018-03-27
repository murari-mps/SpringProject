package com.example.demoProject.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class users implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 11456258L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String userName;
	private String emailId;
	private String password;
	private String address;
	@OneToMany
	private List<AccountDetails> accountDetails;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<AccountDetails> getAccountDetails() {
		return accountDetails;
	}
	public void setAccountDetails(List<AccountDetails> accountDetails) {
		this.accountDetails = accountDetails;
	}
	
}
