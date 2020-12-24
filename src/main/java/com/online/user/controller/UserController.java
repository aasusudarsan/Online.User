package com.online.user.controller;


import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.online.user.dao.UserDAO;
import com.online.user.model.User;

@RestController
@RequestMapping("/user")
@ComponentScan("com.online.user.*")
public class UserController {
	
	@Autowired
	private UserDAO userDAO;
	
	
	@PostMapping("/login")
	public ResponseEntity<User> authenticateUser(@PathParam(value = "username") String username) throws Exception {
		try {
			User userRes = userDAO.getPassword(username);
			if (userRes !=null) {
				return new ResponseEntity<User>(userRes,HttpStatus.ACCEPTED);
			}
			else {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}			
		}catch (Exception e) {
			
			User userWithError = new User();
			return new ResponseEntity<User>(userWithError, HttpStatus.BAD_REQUEST);
		}
	}

}
