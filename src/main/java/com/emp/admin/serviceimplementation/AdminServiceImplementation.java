package com.emp.admin.serviceimplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.emp.admin.entity.Admin;
import com.emp.admin.exception.AdminAlreadyExistsExpection;
import com.emp.admin.exception.AdminInavlidEmailIdExpection;
import com.emp.admin.exception.AdminInvalidPasswordExpection;
import com.emp.admin.repository.AdminRepository;
import com.emp.admin.service.AdminService;

@Service
public class AdminServiceImplementation implements AdminService {

	@Autowired
	private AdminRepository rep;

	private BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();

	@Override
	public Object addAdmin(Admin admin) {
		String pwd = bcrypt.encode(admin.getAdminPassword());
		admin.setAdminPassword(pwd);
		try {
			if (rep.findByAdminEmail(admin.getAdminEmail()) != null) {
				throw new AdminAlreadyExistsExpection("Admin already exsists for the given : " + admin.getAdminEmail());
			}
		} catch (AdminAlreadyExistsExpection e) {
			return e.getMessage();
		}
		return rep.save(admin);
	}

	@Override
	public Object adminLogin(String email, String pwd) {
		Admin admin = rep.findByAdminEmail(email);
		try {
			if (admin != null) {
				if (bcrypt.matches(pwd, admin.getAdminPassword())) {
					return "login sucessfull";
				}
				try {
					throw new AdminInvalidPasswordExpection("Invalid admin password");
				} catch (AdminInvalidPasswordExpection e) {
					return e.getMessage();
				}
			}
			throw new AdminInavlidEmailIdExpection("Invalid admin email-id");
		} catch (AdminInavlidEmailIdExpection e) {
			return e.getMessage();
		}
	}

}
