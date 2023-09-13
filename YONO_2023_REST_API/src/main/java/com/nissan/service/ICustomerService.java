package com.nissan.service;

import com.nissan.common.APIResponse;

public interface ICustomerService {
	
	//deposit money
	public APIResponse depositMoney(int accountNo,double amount);
	
	//withdraw money
	public APIResponse withdrawMoney(int accountNo,double amount);
	
	// Display balance
	public APIResponse displayBalance(int accountNo);
	
	//Transfer money
	public APIResponse transferAmount(int accountNo,double amount);


}
