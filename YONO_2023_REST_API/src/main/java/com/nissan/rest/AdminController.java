package com.nissan.rest;

import java.nio.file.AccessDeniedException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.dto.ActiveCustomersListDTO;
import com.nissan.model.Customer;
import com.nissan.service.IAdminService;
import com.nissan.util.JwtUtilAdmin;

@RestController // @Controller+@Configuration
@RequestMapping("/api")
public class AdminController {

	@Autowired
	private APIResponse apiResponse;

	@Autowired
	private IAdminService adminService;

	@Autowired
	private JwtUtilAdmin jwtUtilAdmin;

	// add customers
	@PostMapping("/admin")
	public ResponseEntity<APIResponse> addCustomer(@RequestBody Customer customer,
			@RequestHeader(value = "adminAuthorization", defaultValue = "") String auth) throws AccessDeniedException {
		jwtUtilAdmin.verify(auth);
		apiResponse=adminService.saveCustomer(customer);

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}

	// update customer
	@PutMapping("/admin")
	public ResponseEntity<APIResponse> updateCustomer(@RequestBody Customer customer,
			@RequestHeader(value = "adminAuthorization", defaultValue = "") String auth) throws AccessDeniedException {
		jwtUtilAdmin.verify(auth);
		apiResponse=adminService.saveUpdatedCustomer(customer);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}

	// list customer
	@GetMapping("/admin")
	public List<Customer> getCustomer(@RequestHeader(value = "adminAuthorization", defaultValue = "") String auth)
			throws AccessDeniedException {
		jwtUtilAdmin.verify(auth);
		return adminService.getCustomer();
	}

	// search by account number
	@GetMapping("/admin/{accountNo}")
	public Customer getCustomer(@PathVariable int accountNo,
			@RequestHeader(value = "adminAuthorization", defaultValue = "") String auth) throws AccessDeniedException {
		jwtUtilAdmin.verify(auth);
		return adminService.getCustomer(accountNo);
	}

	// disable or delete customer
	@DeleteMapping("/admin/{accountNo}")
	public ResponseEntity<APIResponse> deleteCustomer(@PathVariable int accountNo,
			@RequestHeader(value = "adminAuthorization", defaultValue = "") String auth) throws AccessDeniedException {
		jwtUtilAdmin.verify(auth);
		adminService.deleteCustomer(accountNo);
		apiResponse.setData("CUSTOMER DELETED SUCCESSFULLY");
		apiResponse.setStatus(200);

		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}
	
	// fetch details of active customers
		@GetMapping("/admin/dto")
		public List<ActiveCustomersListDTO> getAllDTOCustomers(
				@RequestHeader(value = "adminAuthorization", defaultValue = "") String auth) throws AccessDeniedException {
			jwtUtilAdmin.verify(auth);
			return adminService.getAllDTOCustomers();
		}

}
