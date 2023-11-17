package com.yedam.app.excel.service;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class Task {
	private LocalDateTime start;
	private LocalDateTime end;
	private String text;
	private Integer ordinal;
	private String priority;
}
