package com.example.demoProject.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccountDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 14125856L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String accountNo;
	private String accountType;
	private long amount;
	private String accountHolderName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
