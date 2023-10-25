package com.yedam.app.department.service;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
	
	// 전체조회 (다건조회)
	public List<DepartmentVO> getDepartmentAll();
		
	// 사원조회 (단건조회)
	public DepartmentVO getDepartmentInfo(DepartmentVO departmentVO);
			
	// 등록
	public int insertDepartmentInfo(DepartmentVO departmentVO);
			
	// 수정
	public Map<String, Object> updateDepartmentInfo(DepartmentVO departmentVO);
	
	// 삭제
	public boolean deleteDepartmentInfo(int employeeId);
}
