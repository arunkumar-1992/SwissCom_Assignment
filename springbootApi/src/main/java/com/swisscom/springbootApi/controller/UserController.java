package com.swisscom.springbootApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swisscom.springbootApi.model.User;
import com.swisscom.springbootApi.service.UserService;


@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/Users")
	public ResponseEntity<User> createUser(@RequestBody User user){
		return new ResponseEntity<User>(userService.update(user),HttpStatus.ACCEPTED);
		
	}

	@GetMapping("/Users")
	public ResponseEntity<List<User>> getAllUsers(){
		return new ResponseEntity<List<User>>(userService.findAllUsers(),HttpStatus.ACCEPTED);	
	}
	
	@PutMapping("/Users/{firstName}")
	public ResponseEntity<User> updateUser(@PathVariable String firstName,  @RequestBody User newUser){
		User user=userService.findUserByFirstName(firstName);
		user.setEmailId(newUser.getEmailId());
		user.setPassword(newUser.getPassword());
		return new ResponseEntity<User>(userService.update(user),HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/Users/{firstName}")
	public ResponseEntity<String> deleteUser(@PathVariable String firstName){
		User user=userService.findUserByFirstName(firstName);
		userService.DeleteUser(user);
		return new  ResponseEntity<String>("User Record Deleted",HttpStatus.ACCEPTED);
		
	}
	
	

}
