package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.common.APIResponse;
import com.nissan.common.Validation;
import com.nissan.dto.ActiveCustomersListDTO;
import com.nissan.model.Customer;
import com.nissan.repository.IAdminRepository;

@Service
public class AdminServiceImple implements IAdminService {

	@Autowired
	private IAdminRepository adminRepo;

	@Autowired
	private Validation validation;

	@Autowired
	private AutoGenerator autoGenerator;

	@Autowired
	private APIResponse apiResponse;

	@Override
	public List<Customer> getCustomer() {
		return (List<Customer>) adminRepo.findAll();
	}

	@Override
	public APIResponse saveCustomer(Customer customer) {
		customer.setAccountNo(autoGenerator.getAccountNo());
		customer.setAtmPin(autoGenerator.getPin());
		if (validation.isNameValid(customer.getCustomerName())) {
			if (validation.checkMobile(customer.getMobileNumber())) {
				adminRepo.save(customer);
				apiResponse.setData("Customer Added Successfully");
				apiResponse.setStatus(200);
				return apiResponse;
			} else {
				apiResponse.setData("Mobile number should be 10 digits!");
				apiResponse.setStatus(500);
				return apiResponse;
			}

		} else {
			apiResponse.setData("Name should contain only letters and less than 30 letters");
			apiResponse.setStatus(500);
			return apiResponse;
		}
	}

	@Override
	public Customer getCustomer(int accountNo) {
		return adminRepo.findById(accountNo)
				.orElseThrow(() -> new RuntimeException("Customer not found for id" + accountNo));
	}

	@Transactional
	@Override
	public void deleteCustomer(int accountNo) {
		if (adminRepo.findById(accountNo) == null) {
			throw new RuntimeException("Customer not found for id" + accountNo);

		} else {
			adminRepo.deleteByAccountNo(accountNo);
		}

	}

	@Override
	public APIResponse saveUpdatedCustomer(Customer customer) {
		if (validation.isNameValid(customer.getCustomerName())) {
			if (validation.checkMobile(customer.getMobileNumber())) {
				adminRepo.save(customer);
				apiResponse.setData("Customer Updated Successfully");
				apiResponse.setStatus(200);
				return apiResponse;
			} else {
				apiResponse.setData("Mobile number should be 10 digits!");
				apiResponse.setStatus(500);
				return apiResponse;
			}

		} else {
			apiResponse.setData("Name should contain only letters and less than 30 letters");
			apiResponse.setStatus(500);
			return apiResponse;
		}
	}

	@Override
	public List<ActiveCustomersListDTO> getAllDTOCustomers() {
		// TODO Auto-generated method stub
		return adminRepo.findAllActiveCustomers();
	}

}
