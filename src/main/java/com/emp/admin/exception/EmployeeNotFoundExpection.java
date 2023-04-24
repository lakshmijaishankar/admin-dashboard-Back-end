package com.emp.admin.exception;

public class EmployeeNotFoundExpection extends RuntimeException{
	
	private String exp;

	public EmployeeNotFoundExpection(String exp) {
		super(exp);
		this.exp = exp;
	}
	

}
