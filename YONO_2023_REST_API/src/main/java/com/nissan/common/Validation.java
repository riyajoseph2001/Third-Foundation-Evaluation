package com.nissan.common;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

import javax.naming.InvalidNameException;

import org.springframework.stereotype.Component;

@Component
public class Validation {
	// name validation
	public Boolean isNameValid(String name) {
		boolean bool = false;
		try {
			Pattern namePattern = Pattern.compile("[^ A-Za-z]");
			Matcher nameMatcher = namePattern.matcher(name);
			boolean finder = nameMatcher.find();
			if (finder) {
				throw new InvalidNameException("Hey! Invalid name");
			} else if(name.length()>30) {
				throw new InvalidNameException("Hey! Invalid name");
				
			}
			else {
				bool = true;
			}
		} catch (InvalidNameException e) {
			e.getMessage();
		}
		return bool;
	}

	// Mobile number validation
	public Boolean checkMobile(String mobileNumber) {
		boolean bool = false;
		try {

			Pattern pattern = Pattern.compile("[^0-9]");
			Matcher matcher = pattern.matcher(mobileNumber);
			boolean finder = matcher.find();
			if (finder) {
				throw new Exception("Invalid Entry!!Enter valid mobile number!");

			} else if (mobileNumber.length() != 10) {
				throw new Exception("Invalid Entry!!Enter valid mobile number!");
			} else {
				bool = true;
			}
		} catch (Exception e) {

		}
		return bool;
	}

	// Account number validation
	public Boolean checkAccountNumber(int accountNo) {
		String accNo = Integer.toString(accountNo);
		boolean bool = false;
		try {
			Pattern pattern = Pattern.compile("[^0-9]");

			Matcher matcher = pattern.matcher(accNo);
			boolean finder = matcher.find();
			if (finder) {
				throw new Exception("Invalid Entry!!Enter valid account number!");

			} else if (accNo.length() != 9) {
				throw new Exception("Invalid Entry!!Enter valid account number!");
			} else {
				bool = true;
			}
		} catch (Exception e) {
		}
		return bool;
	}

}
