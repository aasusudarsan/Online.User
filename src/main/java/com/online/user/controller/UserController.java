package com.online.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.online.user.model.User;
import com.online.user.service.UserService;

@RestController
@RequestMapping("/user")
@ComponentScan("com.online.user.*")
@CrossOrigin(origins="*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/login")
	public ResponseEntity<User> authenticateUser(@RequestBody User user) throws Exception {
		try {
			User userRes = userService.autheticateUserLogin(user);
			if (userRes !=null) {
				return new ResponseEntity<User>(userRes,HttpStatus.ACCEPTED);
			}
			else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}			
		}catch (Exception e) {
			
			User userWithError = new User();
			userWithError.setMessage("Invalid username or password");
			return new ResponseEntity<User>(userWithError, HttpStatus.BAD_REQUEST);
		}
	}

}
