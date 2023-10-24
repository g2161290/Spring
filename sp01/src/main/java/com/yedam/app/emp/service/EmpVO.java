package com.yedam.app.emp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmpVO {
	/*
	 * private String employee_id; private String first_name; private String
	 * last_name; private String email; private String hire_date; private String
	 * job_id; private String department_id; private String salary;
	 */
	// 1) 컬럼따라 타입을 구분 or 실제타입대신 String
	// 2) 기본타입(int, double 등)or Wrap클래스(Integer, Double)-null허용
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hireDate;
	private String jobId;
	private double salary;
	private Double commissionPct;
	private Integer managerId;
	private Integer departmentID;
	
}
