package com.emp.admin.exception;

public class AdminInvalidPasswordExpection extends RuntimeException{

	private String adminPwd;

	public AdminInvalidPasswordExpection(String adminPwd) {
		super(adminPwd);
		this.adminPwd = adminPwd;
	}
	
}
