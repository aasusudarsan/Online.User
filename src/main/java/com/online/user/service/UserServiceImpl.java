package com.online.user.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.user.dao.UserDAO;
import com.online.user.model.User;

@Service(value="userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public User autheticateUserLogin(User user) {
		User userFromDb = userDAO.getPassword(user.getUsername());
		if(userFromDb.getPassword().matches(user.getPassword())) {
			User userSuccess = new User();
			userSuccess.setEmailid(userFromDb.getEmailid());
			userSuccess.setPhone(userFromDb.getPhone());
			userSuccess.setUsername(userFromDb.getUsername());
			userSuccess.setMessage("User Authentication Success");
			return userSuccess;
		}
		else {
			User userError = null;
			return userError;
			}
			
		}
		
	
}

