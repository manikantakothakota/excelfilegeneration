package com.example.demo.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.UserExcelview;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@GetMapping(value = "/allusers")
	private List<User> getAllUsers() {
		List<User> Userlist=userservice.loadAllUsers();
		return Userlist;
	}
	
	@GetMapping(value = "/excelExp",produces = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") 
	public ResponseEntity<InputStreamResource> excelCustomersReport() throws IOException {
		List<User> Userlist=userservice.loadAllUsers();
    
    ByteArrayInputStream in = UserExcelview.UsersToExcel(Userlist);
    // return IOUtils.toByteArray(in);
    
    HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=Users.xlsx");
    
     return ResponseEntity
                  .ok()
                  .headers(headers)
                  .body(new InputStreamResource(in)
                		);
    }
}
