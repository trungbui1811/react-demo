package com.react.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.react.form.UserForm;
import com.react.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserForm>> getAllUsers(){
		List<UserForm> lst = userService.getAllUsers();
		return new ResponseEntity<List<UserForm>>(lst, new HttpHeaders(), HttpStatus.OK);
	}
}
