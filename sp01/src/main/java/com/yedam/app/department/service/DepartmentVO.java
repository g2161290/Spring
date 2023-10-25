package com.yedam.app.department.service;

import lombok.Data;

@Data
public class DepartmentVO {
	private int departmentId;
	private String departmentName;
	private Integer managerId;
	private Integer locationId;
}
