package com.yedam.app.department.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.department.mapper.DepartmentMapper;
import com.yedam.app.department.service.DepartmentService;
import com.yedam.app.department.service.DepartmentVO;
@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	DepartmentMapper departmentMapper;
	
	@Override
	public List<DepartmentVO> getDepartmentAll() {
		return departmentMapper.selectAllDepartmentInfo();
	}

	@Override
	public DepartmentVO getDepartmentInfo(DepartmentVO departmentVO) {
		return departmentMapper.selectDepartmentInfo(departmentVO);
	}

	@Override
	public int insertDepartmentInfo(DepartmentVO departmentVO) {
		int result=departmentMapper.insertDepartmentInfo(departmentVO);
		int id=0;
		if(result == 1) {
			id = departmentVO.getDepartmentId();
		} else {
			id = -1;
		}
		return id;
	}

	@Override
	public Map<String, Object> updateDepartmentInfo(DepartmentVO departmentVO) {
		return null;
	}

	@Override
	public boolean deleteDepartmentInfo(int employeeId) {
		return false;
	}

}
