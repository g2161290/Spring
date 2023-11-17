package com.yedam.app.emp.service;

import java.util.List;

public interface EmpService {
	public List<EmpVO> selectAllEmp();
	
	public EmpVO selectEmpInfo(EmpVO empVO);
	
	public int insertEmpInfo(EmpVO empVO);
}
