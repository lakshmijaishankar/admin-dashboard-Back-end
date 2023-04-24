package com.emp.admin.service;

import com.emp.admin.entity.Admin;

public interface AdminService {

	 Object addAdmin(Admin admin);
	 
	 Object adminLogin(String email,String pwd);
}
