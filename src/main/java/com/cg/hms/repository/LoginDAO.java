package com.cg.hms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.hms.entity.User;


public interface LoginDAO extends JpaRepository<User,Long> {
	
//	public String addAccount(User us) throws  UserNameAlreadyExistsException;
	
//	@Query("SELECT u FROM User_hma u WHERE u.user_name = ?1 AND u.password = ?2")
//	User findByUsernameandPassword(String username, String password);
	
	@Query("SELECT u FROM User u WHERE u.user_name = ?1")
	Optional<User> findByUsername(String username);	
	
	@Query("SELECT u FROM User u WHERE u.user_name = ?1")
	User findByName(String username);	
	
	
	
//	public void checkUser( String userName, String password) throws InvalidLoginCredentialsException;
//
//	public boolean userNameExists(String userName) throws  UserNameAlreadyExistsException ;
//	

}