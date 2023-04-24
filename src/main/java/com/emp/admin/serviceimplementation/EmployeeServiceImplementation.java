package com.emp.admin.serviceimplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.admin.entity.Employee;
import com.emp.admin.exception.EmployeeNotFoundExpection;
import com.emp.admin.repository.EmployeeRepository;
import com.emp.admin.service.EmployeeService;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private EmployeeRepository rep;
//Saving employee to the database
	@Override
	public Employee addEmp(Employee emp) {
		List<Employee> temp=rep.findAll();
		int count=0;
		String id = "2023TCS";
		if(temp.size()>0) {
			count=temp.get(temp.size()-1).getId();
			count++;
		}else {
			count++;
		}
		emp.setEmpId(id +count);
		emp.setId(count);
		return rep.save(emp);
	}
//Retrieving all employee details
	@Override
	public List<Employee> getAllEmployee() {
		return rep.findAll();
	}

	@Override
	public Object getByEmpId(String empId) {
		Employee temp=rep.findByEmpId(empId);
		try {
			if(temp==null) {
				throw new EmployeeNotFoundExpection("Employee not found for the given id : "+empId);
			}
		}
		catch (EmployeeNotFoundExpection e) {
			return e.getMessage();
		}
		return rep.findByEmpId(empId);
	}
//Deleting Employee Based on Id
	@Override
	public Object removeEmployeeByID(String empid) {
		try {
			if(!rep.existsById(empid)) {
				throw new EmployeeNotFoundExpection("Employee has been not found for the given id : "+empid);
			}
		}
		catch (Exception e) {
			return e.getMessage();
		}
		rep.deleteById(empid);
		return "Employee has been removed from the database";
	}
//Retrieving total number of developer
	@Override
	public List<Integer> getAllDeveloper() {
		List<Integer> list=new ArrayList<>();
		list.add(rep.getJavaDeveloper());
		list.add(rep.getWebDeveloper());
		list.add(rep.getSqlDeveloper());
		list.add(rep.getMernDeveloper());
		return list;
	}

}
