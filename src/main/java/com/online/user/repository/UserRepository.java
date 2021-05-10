package com.online.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.online.user.model.User;

public interface UserRepository extends JpaRepository<User, String>{
	@Query(
			  value = "SELECT * FROM user u WHERE u.username = ?1", 
			  nativeQuery = true)
	User findByUsername(String username);
}