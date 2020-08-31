package com.example.demo.util;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.example.demo.entity.User;

public class UserExcelview extends AbstractXlsxView{

	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		
response.setHeader("Content-Disposition", "attachment;filename=UserDetails.xlsx");

		
		@SuppressWarnings("unchecked")
		List<User> User=(List<User>) model.get("userlist");
	
		Sheet sheet=workbook.createSheet("User");
		
		setHead(sheet);
		setBody(sheet,User);
		
	}

	private void setHead(Sheet sheet) {

		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("NAME");
		row.createCell(2).setCellValue("ROLE");
		row.createCell(3).setCellValue("EMAIL");
		row.createCell(4).setCellValue("PHONE");
		row.createCell(5).setCellValue("BUSINESS");
		row.createCell(6).setCellValue("COVID19_EFFECT_ON_BUSINESS");
			}
	
	private void setBody(Sheet sheet, List<User> user) {

		int rowNumber=1;
		for(User u:user) {
			Row row=sheet.createRow(rowNumber++);
			row.createCell(0).setCellValue(u.getId().toString());
			row.createCell(1).setCellValue(u.getName());
		    row.createCell(2).setCellValue(u.getRole());
			row.createCell(3).setCellValue(u.getEmail());
			row.createCell(4).setCellValue(u.getPhone());
			row.createCell(5).setCellValue(u.getBusiness());
			row.createCell(6).setCellValue(u.getCovid19EffectOnBusiness());
			
		}
		
	}
		
		
	}


