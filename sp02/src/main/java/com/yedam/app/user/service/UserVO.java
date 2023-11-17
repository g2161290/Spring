package com.yedam.app.user.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class UserVO {
	private String id;
	private String password;
	private String gender;
	private String name;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	//@JsonFormat(pattern="yyyy/MM/dd")
	private Date joinDate;
}
