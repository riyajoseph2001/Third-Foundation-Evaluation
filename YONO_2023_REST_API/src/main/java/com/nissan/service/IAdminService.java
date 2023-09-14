package com.nissan.service;

import java.util.List;

import com.nissan.common.APIResponse;
import com.nissan.dto.ActiveCustomersListDTO;
import com.nissan.model.Customer;

public interface IAdminService {
		//list
		public List<Customer> getCustomer();
		
		//Add
		public APIResponse saveCustomer(Customer customer);
		
		//search by account number
		public Customer getCustomer(int accountNo);
		
		//delete 
		public void deleteCustomer(int accountNo);
		
		//update
		public APIResponse saveUpdatedCustomer(Customer customer);
		
		//list details of active customers
		public List<ActiveCustomersListDTO> getAllDTOCustomers();

}
