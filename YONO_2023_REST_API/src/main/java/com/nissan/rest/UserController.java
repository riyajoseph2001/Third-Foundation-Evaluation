package com.nissan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.service.IUserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping("/users/{userName}&{password}")
	public ResponseEntity<APIResponse> finfUserByNameAndPassword(@PathVariable String userName,
			@PathVariable String password) {
		APIResponse apiresponse = userService.findUserByNameAndPassword(userName, password);
		return ResponseEntity.status(apiresponse.getStatus()).body(apiresponse);
	}

}

