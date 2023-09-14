package com.nissan.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.model.Customer;
@Repository
public interface ICustomerRepository extends CrudRepository<Customer, Integer> {

	// deposit money
	@Modifying
	@Query("UPDATE Customer SET balance= balance + ?2 WHERE accountNo=?1")
	public void depositeAmount(Integer accountNo,double amount);

	// withdraw money
	@Modifying
	@Query("UPDATE Customer SET balance= balance - ?2 WHERE accountNo=?1")
	public void withdrawAmount(Integer accountNo,double amount);

	// Display balance
	@Query("SELECT balance FROM Customer WHERE accountNo=?1")
	public double getBalance(Integer accountNo);

	//Transfer money
	@Modifying
	@Query("UPDATE Customer SET balance= balance - ?2 WHERE accountNo=?1")
	public void transferAmount(Integer accountNo,double amount);

}
