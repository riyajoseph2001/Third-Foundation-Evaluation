package com.nissan.service;

import java.util.List;

import com.nissan.model.Customer;

public interface IAdminService {
		//list
		public List<Customer> getCustomer();
		
		//Add
		public Customer saveCustomer(Customer customer);
		
		//search by account number
		public Customer getCustomer(int accountNo);
		
		//delete 
		public void deleteCustomer(int accountNo);
		
		//update
		public Customer saveUpdatedCustomer(Customer customer);

}
