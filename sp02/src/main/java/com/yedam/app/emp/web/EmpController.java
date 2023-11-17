package com.yedam.app.emp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpController {
	@Autowired
	EmpService empService;
	
	//전체조회
	@GetMapping("empList")
	public String empList(Model model) {
		model.addAttribute("empList", empService.selectAllEmp());
		return "empList";
	}
	//단건조회
	@GetMapping("empInfo")
	public String empInfo(EmpVO empVO, Model model) {
		model.addAttribute("empInfo", empService.selectEmpInfo(empVO));
		return "empInfo";
	}
	//등록 - 페이지
	@GetMapping("empInsert")
	public void empInsertForm(Model model) {
		model.addAttribute("empVO", new EmpVO());
	}
	//등록 - 처리
	@PostMapping("empInsert")
	public String empInsertProcess(EmpVO empVO) {
		empService.insertEmpInfo(empVO);
		return "redirect:empList";
	}
}
