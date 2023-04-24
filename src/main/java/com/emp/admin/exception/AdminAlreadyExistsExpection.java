package com.emp.admin.exception;

public class AdminAlreadyExistsExpection extends RuntimeException{
	
	private String email;

	public AdminAlreadyExistsExpection(String email) {
		super(email);
		this.email = email;
	}
	
	

}
