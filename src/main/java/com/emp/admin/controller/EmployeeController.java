package com.emp.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.emp.admin.entity.Employee;
import com.emp.admin.service.EmployeeService;

@RestController
@CrossOrigin
public class EmployeeController {
	
	@Autowired
	private EmployeeService ser;
	
	@PostMapping("/addemp")
	public ResponseEntity<Employee> saveEmp(@RequestBody Employee emp){
		Employee temp=ser.addEmp(emp);
		return ResponseEntity.status(200).body(temp);
	}
	
	@GetMapping("/getallemp")
	public ResponseEntity<List<Employee>> getAllEmployeeDetails(){
		return ResponseEntity.status(200).body(ser.getAllEmployee());
	}
	
	@GetMapping("/getbyempid/{empId}")
	public ResponseEntity<Object> getByEmployeeId(@PathVariable(name = "empId") String id){
		Object obj=ser.getByEmpId(id);
		return obj instanceof Employee?ResponseEntity.status(200).body(obj):ResponseEntity.status(200).body(obj);
	}

	@DeleteMapping("/deleteEmpById")
	public ResponseEntity<Object> deleteEmployeeById(@RequestHeader String id){
		Object obj2=ser.removeEmployeeByID(id);
		return obj2.equals("Employee has been removed from the database")?ResponseEntity.status(200).body(obj2)
				:ResponseEntity.status(400).body(obj2);
	}
	
	@GetMapping("/getalldeveloper")
	public ResponseEntity<List<Integer>> getTotalNumberOfDeveloper(){
		return ResponseEntity.status(200).body(ser.getAllDeveloper());
	}

}
