package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	
	@GetMapping(value = "/excelExp") 
	public ModelAndView doExcelExport() {   
		List<User> Userlist=userservice.loadAllUsers();
		ModelAndView m=new ModelAndView();
		UserExcelview uev=new UserExcelview();
		m.setView(uev);
		m.addObject("userlist", Userlist);
		return m;

		
	} 
}
