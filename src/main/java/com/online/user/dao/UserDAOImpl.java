package com.online.user.dao;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.user.model.User;
import com.online.user.repository.UserRepository;


@Repository(value="userDAO")
public class UserDAOImpl implements UserDAO {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User getPassword(String username) {
//		System.out.println("Hai before");
		User user = userRepository.findByUsername(username);
		return user;
	}

}