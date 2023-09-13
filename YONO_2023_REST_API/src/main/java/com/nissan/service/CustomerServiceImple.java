package com.nissan.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.APIResponse;
import com.nissan.repository.ICustomerRepository;

@Service
public class CustomerServiceImple implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepo;

	@Autowired
	private APIResponse apiResponse;
	
	@Transactional
	@Override
	public APIResponse depositMoney(int accountNo, double amount) {
		if (amount > 50000) {
			System.out.println("Enter pan number");
			customerRepo.depositeAmount(accountNo, amount);
			apiResponse.setData("Amount Deposited Sucessfully");
			return apiResponse;
		} else {
			customerRepo.depositeAmount(accountNo, amount);
			apiResponse.setData("Amount Deposited Sucessfully");
			return apiResponse;
		}

	}
	@Transactional
	@Override
	public APIResponse withdrawMoney(int accountNo, double amount) {
		if (customerRepo.getBalance(accountNo) > amount) {

			customerRepo.withdrawAmount(accountNo, amount);
			apiResponse.setData("Amount "+amount+ " is debited");
			return apiResponse;

		} else {
			apiResponse.setData("Insufficient Funds!");
			return apiResponse;

		}

	}

	@Override
	public APIResponse displayBalance(int accountNo) {
		double balance = customerRepo.getBalance(accountNo);
		apiResponse.setData("Balance is "+balance);
		return apiResponse;
	}
	
	@Transactional
	@Override
	public APIResponse transferAmount(int accountNo,double amount) {
		if (customerRepo.getBalance(accountNo) > amount) {

			customerRepo.transferAmount(accountNo, amount);
			apiResponse.setData("Amount "+amount+ " is transferred sucessfully");
			return apiResponse;

		} else {
			apiResponse.setData("Insufficient Funds!");
			return apiResponse;

		}

	}
	

}
