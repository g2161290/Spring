package com.yedam.app.department.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.department.service.DepartmentService;
import com.yedam.app.department.service.DepartmentVO;

@Controller
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	//전체조회
	@GetMapping("departmentList")
	public String getDepartmentList(Model model) {
		List<DepartmentVO> list = departmentService.getDepartmentAll();
		model.addAttribute("departmentList", list);
		return "department/departmentList";
	}
	
	//단건조회
	@GetMapping("departmentInfo")
	public String getDepartmentInfo(DepartmentVO departmentVO, Model model) {
		DepartmentVO findVO = departmentService.getDepartmentInfo(departmentVO);
		model.addAttribute("departmentInfo", findVO);
		return "department/departmentInfo";
	}
	
	//등록
	@GetMapping("departmentInsert")
	public String insertdepartmentInfoForm() {
		return "department/departmentInsert";
	}
	@PostMapping("departmentInsert")
	public String insertDepartmentInfoProcess(DepartmentVO departmentVO) {
		int departmentId=departmentService.insertDepartmentInfo(departmentVO);
		
		String path = null;
		if(departmentId > -1) {
			path = "redirect:departmentInfo?departmentId="+departmentId;
		} else {
			path = "redirect:departmentList";
		}
		return path;
	}
}
