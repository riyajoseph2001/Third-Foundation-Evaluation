package com.nissan.rest;

import java.nio.file.AccessDeniedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.service.ICustomerService;
import com.nissan.util.JwtUtilCustomer;

@RestController // @Controller+@Configuration
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private APIResponse apiResponse;

	@Autowired
	private ICustomerService customerService;

	@Autowired
	private JwtUtilCustomer jwtUtilCustomer;

	// deposit money
	@GetMapping("/customer/deposite/{accountNo}&{amount}")
	public ResponseEntity<APIResponse> depositeMoney(@PathVariable Integer accountNo, @PathVariable double amount,
			@RequestHeader(value = "customerAuthorization", defaultValue = "") String auth) throws AccessDeniedException {
		jwtUtilCustomer.verify(auth);
		apiResponse = customerService.depositMoney(accountNo, amount);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// withdraw money
	@GetMapping("/customer/withdraw/{accountNo}&{amount}")
	public ResponseEntity<APIResponse> withdrawMoney(@PathVariable Integer accountNo, @PathVariable double amount,
			@RequestHeader(value = "customerAuthorization", defaultValue = "") String auth) throws AccessDeniedException {
		jwtUtilCustomer.verify(auth);
		apiResponse= customerService.withdrawMoney(accountNo, amount);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

	// display balance
	@GetMapping("/customer/balance/{accountNo}")
	public ResponseEntity<APIResponse> balance(@PathVariable Integer accountNo,
			@RequestHeader(value = "customerAuthorization", defaultValue = "") String auth) throws AccessDeniedException {
		jwtUtilCustomer.verify(auth);
		apiResponse = customerService.displayBalance(accountNo);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

	}

	// transfer money
	@GetMapping("/customer/transfer/{accountNo}&{amount}")
	public ResponseEntity<APIResponse> transferAmount(@PathVariable Integer accountNo, @PathVariable double amount,
			@RequestHeader(value = "customerAuthorization", defaultValue = "") String auth) throws AccessDeniedException {
		jwtUtilCustomer.verify(auth);
		apiResponse= customerService.transferAmount(accountNo, amount);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

}
