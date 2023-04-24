package com.emp.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.admin.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	Admin findByAdminEmail(String email);

}
