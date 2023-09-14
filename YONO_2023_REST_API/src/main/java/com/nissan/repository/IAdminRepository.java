package com.nissan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.dto.ActiveCustomersListDTO;
import com.nissan.model.Customer;


@Repository
public interface IAdminRepository extends CrudRepository<Customer, Integer>{
	@Modifying
	@Query("UPDATE com.nissan.model.Customer SET isActive=0 WHERE accountNo=?1")
	public void deleteByAccountNo(Integer accountNo);
	
	//details of active customer
	@Query("SELECT new com.nissan.dto.ActiveCustomersListDTO(c.accountNo,c.customerName,c.mobileNumber,c.emailId,c.isActive) FROM Customer c WHERE isActive=1")
	public List<ActiveCustomersListDTO> findAllActiveCustomers();
}
