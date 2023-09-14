package com.nissan.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.APIResponse;
import com.nissan.common.Validation;
import com.nissan.repository.ICustomerRepository;

@Service
public class CustomerServiceImple implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepo;

	@Autowired
	private APIResponse apiResponse;

	@Autowired
	private Validation validation;

	@Transactional
	@Override
	public APIResponse depositMoney(int accountNo, double amount) {
		if (validation.checkAccountNumber(accountNo)) {
			if (amount > 50000) {
				customerRepo.depositeAmount(accountNo, amount);
				apiResponse.setData("Enter pan number");
				apiResponse.setStatus(200);
				return apiResponse;
			} else {
				customerRepo.depositeAmount(accountNo, amount);
				apiResponse.setData("Amount Deposited Sucessfully");
				apiResponse.setStatus(200);
				return apiResponse;
			}
		} else {
			apiResponse.setData("Invalid Entry!!Account number should be 9 digits long");
			apiResponse.setStatus(500);
			return apiResponse;
		}

	}

	@Transactional
	@Override
	public APIResponse withdrawMoney(int accountNo, double amount) {
		if (validation.checkAccountNumber(accountNo)) {
			if (customerRepo.getBalance(accountNo) > amount) {

				customerRepo.withdrawAmount(accountNo, amount);
				apiResponse.setData("Amount " + amount + " is debited");
				apiResponse.setStatus(200);
				return apiResponse;

			} else {
				apiResponse.setData("Insufficient Funds!");
				apiResponse.setStatus(500);
				return apiResponse;

			}
		} else {
			apiResponse.setData("Invalid Entry!!Account number should be 9 digits long");
			apiResponse.setStatus(500);
			return apiResponse;
		}

	}

	@Override
	public APIResponse displayBalance(int accountNo) {
		if (validation.checkAccountNumber(accountNo)) {
			double balance = customerRepo.getBalance(accountNo);
			apiResponse.setData("Balance is " + balance);
			apiResponse.setStatus(200);
			return apiResponse;
		} else {
			apiResponse.setData("Invalid Entry!!Account number should be 9 digits long");
			apiResponse.setStatus(500);
			return apiResponse;
		}
	}

	@Transactional
	@Override
	public APIResponse transferAmount(int accountNo, double amount) {
		if (validation.checkAccountNumber(accountNo)) {
			if (customerRepo.getBalance(accountNo) > amount) {

				customerRepo.transferAmount(accountNo, amount);
				apiResponse.setData("Amount " + amount + " is transferred sucessfully");
				apiResponse.setStatus(200);
				return apiResponse;

			} else {
				apiResponse.setData("Insufficient Funds!");
				apiResponse.setStatus(500);
				return apiResponse;

			}
		} else {
			apiResponse.setData("Invalid Entry!!Account number should be 9 digits long");
			apiResponse.setStatus(500);
			return apiResponse;
		}

	}

}
