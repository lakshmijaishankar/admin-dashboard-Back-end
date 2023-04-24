package com.emp.admin.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	private int id;
	@Id
	private String empId;
	private String empEmail;
	private long empPhone;
	private String empName;
	private double empSalary;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
	private  Date empDoj;
	private String empDesignation;
	private String empState;

}
