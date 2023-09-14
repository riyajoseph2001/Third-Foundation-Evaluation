package com.nissan.dto;

public class ActiveCustomersListDTO {

	private Integer accountNo;
	private String customerName;
	private String mobileNumber;
	private String emailId;
	private boolean isActive=true;
	
	
	public ActiveCustomersListDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ActiveCustomersListDTO(Integer accountNo, String customerName, String mobileNumber, String emailId,
			boolean isActive) {
		super();
		this.accountNo = accountNo;
		this.customerName = customerName;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
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


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
	

}
