package com.yedam.app.department.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.department.service.DepartmentVO;

public interface DepartmentMapper {

		// 전체조회 (다건조회)
		public List<DepartmentVO> selectAllDepartmentInfo();
		
		// 사원조회 (단건조회)
		public DepartmentVO selectDepartmentInfo(DepartmentVO departmentVO);
		
		// 등록
		public int insertDepartmentInfo(DepartmentVO departmentVO);
		
		// 수정
		public int updateDepartmentInfo(DepartmentVO departmentVO);
		
		// 삭제
		public int deleteDepartmentInfo(@Param("departmentId") int employeeId);
}
