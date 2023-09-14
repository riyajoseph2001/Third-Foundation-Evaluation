package com.nissan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id //making as primary key
	@Column(name="accountNo")
	private Integer accountNo;
	
	@Column(name="customerName",nullable=false,length=60)
	private String customerName;
	
	@Column(name="accountType",nullable=false,length=60)
	private String accountType;
	
	@Column(name="balance",nullable=false,length=60)
	private double balance;
	
	@Column(name="minimumBalance",nullable=false,length=60)
	private double minimumBalance=1000;
	
	@Column(name="mobileNumber",nullable=false,length=60)
	private String mobileNumber;
	
	@Column(name="emailId",nullable=false,length=60)
	private String emailId;
	
	@Column(name="atmPin",nullable=false,length=60)
	private int atmPin;
	
	//check status of customer
	private boolean isActive=true;

	public Customer() {
		
	}

	public Customer(Integer accountNo, String customerName, String accountType, double balance, double minimumBalance,
			String mobileNumber, String emailId, int atmPin, boolean isActive) {
		super();
		this.accountNo = accountNo;
		this.customerName = customerName;
		this.accountType = accountType;
		this.balance = balance;
		this.minimumBalance = minimumBalance;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.atmPin = atmPin;
		this.isActive = isActive;
	}

	public Integer getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getAtmPin() {
		return atmPin;
	}

	public void setAtmPin(int atmPin) {
		this.atmPin = atmPin;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Customer [accountNo=" + accountNo + ", customerName=" + customerName + ", accountType=" + accountType
				+ ", balance=" + balance + ", minimumBalance=" + minimumBalance + ", mobileNumber=" + mobileNumber
				+ ", emailId=" + emailId + ", atmPin=" + atmPin + ", isActive=" + isActive + "]";
	}
	
	

}
