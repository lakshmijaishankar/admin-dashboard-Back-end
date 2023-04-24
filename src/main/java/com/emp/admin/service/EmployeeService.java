package com.emp.admin.service;

import java.util.List;

import com.emp.admin.entity.Employee;

public interface EmployeeService {

	public Employee addEmp(Employee emp);
	
	public List<Employee> getAllEmployee();
	
	public Object getByEmpId(String empId);
	
	public Object removeEmployeeByID(String empid);
	
	public List<Integer> getAllDeveloper();
}
