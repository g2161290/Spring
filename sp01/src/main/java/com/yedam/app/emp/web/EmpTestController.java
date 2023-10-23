package com.yedam.app.emp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpTestController {
	
	@GetMapping("parameterTest")
	public String getMethodTest(EmpVO empVO) {
		System.out.println(empVO);
		return "";
	}
	
	@PostMapping("parameterTest")
	public String postMehodTest(EmpVO empVO) {
		System.out.println(empVO);
		return "";
	}
}
