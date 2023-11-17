package com.yedam.app.excel.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yedam.app.excel.service.ExcelData;
import com.yedam.app.excel.service.ExcelDownload;

@Controller
public class ExcelController {
	@GetMapping("/excel")
	public String main() { // 1
		return "excel";
	}
	@GetMapping("/gantt")
	public String gantt() {
		return "gantt";
	}
	@GetMapping("/api/tasks/create")
	@ResponseBody
	public void ajax() {
		System.out.println("==========");
	}

	@PostMapping("/excel/read")
	public String readExcel(@RequestParam("file") MultipartFile file, Model model) throws IOException { // 2

		List<ExcelData> dataList = new ArrayList<>();
		ExcelData label = new ExcelData();
		String extension = FilenameUtils.getExtension(file.getOriginalFilename()); // 3

		if (!extension.equals("xlsx") && !extension.equals("xls")) {
			throw new IOException("엑셀파일만 업로드 해주세요.");
		}

		Workbook workbook = null;

		if (extension.equals("xlsx")) {
			workbook = new XSSFWorkbook(file.getInputStream());
		} else if (extension.equals("xls")) {
			workbook = new HSSFWorkbook(file.getInputStream());
		}

		Sheet worksheet = workbook.getSheetAt(0);
		Row row = worksheet.getRow(1);
		label.setRequireId(row.getCell(0).getStringCellValue());
		label.setRequireName(row.getCell(1).getStringCellValue());
		label.setRequireContent(row.getCell(2).getStringCellValue());
		label.setRequireType(row.getCell(3).getStringCellValue());
		label.setEntityType(row.getCell(4).getStringCellValue());
		label.setRank(row.getCell(5).getStringCellValue());
		label.setApply(row.getCell(6).getStringCellValue());
		
		ExcelDownload ed = new ExcelDownload();
		for (int i = 2; i < worksheet.getPhysicalNumberOfRows(); i++) {

			row = worksheet.getRow(i);

			ExcelData data = new ExcelData();

			data.setRequireId(row.getCell(0).getStringCellValue());
			data.setRequireName(row.getCell(1).getStringCellValue());
			data.setRequireContent(row.getCell(2).getStringCellValue());
			data.setRequireType(row.getCell(3).getStringCellValue());
			data.setEntityType(row.getCell(4).getStringCellValue());
			data.setRank(row.getCell(5).getStringCellValue());
			data.setApply(row.getCell(6).getStringCellValue());
			dataList.add(data);
		}
		ed.setExcelDatas(dataList);
		model.addAttribute("label", label);
		model.addAttribute("datas", dataList); // 5
		
		model.addAttribute("excelData", ed);
		return "excelList";
	}
	
	//등록 - 처리
	@PostMapping("excelList")
	public void empInsertProcess(HttpServletResponse response, ExcelDownload ed, ExcelData excelData) throws IOException {
//      Workbook wb = new HSSFWorkbook();
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("첫번째 시트");
		Row row = null;
		Cell cell = null;
		int rowNum = 0;

		// Header
		row = sheet.createRow(rowNum++);
		cell = row.createCell(0);
		cell.setCellValue("번호");
		cell = row.createCell(1);
		cell.setCellValue("이름");
		cell = row.createCell(2);
		cell.setCellValue("제목");
		cell = row.createCell(3);
		cell.setCellValue("제목");
		cell = row.createCell(4);
		cell.setCellValue("제목");
		cell = row.createCell(5);
		cell.setCellValue("제목");

		// Body
		for (int i = 0; i < ed.getExcelDatas().size(); i++) {
			row = sheet.createRow(rowNum++);
			cell = row.createCell(0);
			cell.setCellValue(ed.getExcelDatas().get(i).getRequireId());
			cell = row.createCell(1);
			cell.setCellValue(ed.getExcelDatas().get(i).getRequireName());
			cell = row.createCell(2);
			cell.setCellValue(ed.getExcelDatas().get(i).getRequireContent());
		}

		// 컨텐츠 타입과 파일명 지정
		response.setContentType("ms-vnd/excel");
//      response.setHeader("Content-Disposition", "attachment;filename=example.xls");
		response.setHeader("Content-Disposition", "attachment;filename=example.xlsx");

		// Excel File Output
		wb.write(response.getOutputStream());
		wb.close();
	}
	
}
