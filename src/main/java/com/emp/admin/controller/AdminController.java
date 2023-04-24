package com.emp.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emp.admin.entity.Admin;
import com.emp.admin.service.AdminService;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService ser;

	@PostMapping("/save")
	public ResponseEntity<Object> saveAdmin(@RequestBody Admin admin) {
		Object obj = ser.addAdmin(admin);
		if (obj instanceof Admin) {
			return ResponseEntity.status(200).body(obj);
		}
		return ResponseEntity.status(400).body(obj);
	}

	@GetMapping("/login")
	public ResponseEntity<Object> login(@RequestHeader String email,@RequestHeader String pwd){
		Object adminObj=ser.adminLogin(email, pwd);
		return adminObj.equals("login sucessfull")
				?ResponseEntity.status(200).body(adminObj)
				:ResponseEntity.status(400).body(adminObj);
	}

}
