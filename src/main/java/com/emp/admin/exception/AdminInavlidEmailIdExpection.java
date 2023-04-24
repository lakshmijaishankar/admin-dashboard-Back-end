package com.emp.admin.exception;

public class AdminInavlidEmailIdExpection extends RuntimeException{
	
	private String invalidEmail;

	public AdminInavlidEmailIdExpection(String invalidEmail) {
		super(invalidEmail);
		this.invalidEmail = invalidEmail;
	}
	

}
