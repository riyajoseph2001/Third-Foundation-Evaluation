package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.common.Validation;
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

	@Override
	public List<Customer> getCustomer() {
		return (List<Customer>) adminRepo.findAll();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		customer.setAccountNo(autoGenerator.getAccountNo());
		customer.setAtmPin(autoGenerator.getPin());
		if(validation.isNameValid(customer.getCustomerName())) {
			return adminRepo.save(customer);
		}
		return null;
	}

	@Override
	public Customer getCustomer(int accountNo) {
		return adminRepo.findById(accountNo).orElseThrow(()->new RuntimeException("Employee not found for id"+accountNo));
	}
	@Transactional
	@Override
	public void deleteCustomer(int accountNo) {
		adminRepo.deleteByAccountNo(accountNo);

	}

	@Override
	public Customer saveUpdatedCustomer(Customer customer) {
		if(validation.isNameValid(customer.getCustomerName())) {
			return adminRepo.save(customer);
		}
		return null;
	}


}
