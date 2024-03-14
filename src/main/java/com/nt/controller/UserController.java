package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.bean.User;
import com.nt.service.OlxUserServiceImpl;

@RestController
@RequestMapping("/Per")
public class UserController {

	@Autowired
	OlxUserServiceImpl olxUserService;
	
	@PostMapping("/user")
//	@ApiOperation("For User Registration")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		System.out.println("API end point hitted succcessfully");
		System.out.println(user.getFirstName()+""+user.getPhoneNumber());
		User us=olxUserService.registerUser(user);
		return new ResponseEntity<User>(us,HttpStatus.CREATED);
	}
	
	@GetMapping("/user")
//	@ApiOperation("Get All user details")
	public ResponseEntity<List<User>> getAllUser(){
		List<User> us=olxUserService.getAllUser();
		return new ResponseEntity<List<User>>(us,HttpStatus.OK);
	}
	
	@GetMapping("/userbyid/{id}")
//	@ApiOperation("Get User by providing Id")
	public ResponseEntity<User> getUserById(@PathVariable Integer id){
		User us=olxUserService.findUserById(id);
		return new ResponseEntity<User>(us,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/userbyname/{name}")
//	@ApiOperation("Get User By providing Name")
	public ResponseEntity<User> getUserByName(@PathVariable String name){
		User us= olxUserService.findUserByName(name);
		return new ResponseEntity<User>(us,HttpStatus.ACCEPTED);
	}
}
