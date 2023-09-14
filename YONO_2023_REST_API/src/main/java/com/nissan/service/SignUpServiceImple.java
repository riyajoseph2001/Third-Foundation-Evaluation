package com.nissan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.APIResponse;
import com.nissan.model.User;
import com.nissan.repository.ISignUpRepository;
@Service
public class SignUpServiceImple implements ISignUpService {
	
	@Autowired
	private ISignUpRepository signUpRepo;
	
	@Autowired
	private APIResponse apiResponse;

	@Override
	public APIResponse signUpByNameAndPassword(User user) {
		signUpRepo.save(user);
		apiResponse.setStatus(200);
		apiResponse.setData("Signed in!");
		
		
		return apiResponse;
	}

}
