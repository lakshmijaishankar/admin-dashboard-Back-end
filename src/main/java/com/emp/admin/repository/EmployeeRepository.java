package com.emp.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.emp.admin.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{

	@Query(value = "select * from `admin-dashboard`.employee where emp_id=?1",nativeQuery = true)
	public Employee findByEmpId(String empId);
	
	@Query(value = "select count(*) from `admin-dashboard`.employee where emp_designation='Java Developer'",nativeQuery = true)
	public int getJavaDeveloper();
	
	@Query(value = "select count(*) from `admin-dashboard`.employee where emp_designation='Web Developer'",nativeQuery = true)
	public int getWebDeveloper();
	
	@Query(value = "select count(*) from `admin-dashboard`.employee where emp_designation='Sql Developer'",nativeQuery = true)
	public int getSqlDeveloper();
	
	@Query(value = "select count(*) from `admin-dashboard`.employee where emp_designation='Mern Developer'",nativeQuery = true)
	public int getMernDeveloper();
}
