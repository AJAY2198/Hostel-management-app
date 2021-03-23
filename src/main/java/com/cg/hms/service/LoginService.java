package com.cg.hms.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hms.entity.User;
import com.cg.hms.exception.DuplicateRecordException;
import com.cg.hms.exception.HMAException;
import com.cg.hms.exception.InvalidLoginCredentialsException;
import com.cg.hms.exception.RecordNotFoundException;

public interface LoginService {
	/**
	 * Methods for Login operations
	 * 
	 */
	
	/**
	 * Method for user signup
	 * @param user
	 * @return String
	 * @throws DuplicateRecordException
	 */
	public String signup(User user)throws DuplicateRecordException;
	
	/**
	 * Method to check if user credentials are correct
	 * @param user_id
	 * @param password
	 * @return String
	 * @throws InvalidLoginCredentialsException
	 */
	public String checkUser(long user_id, String password)throws InvalidLoginCredentialsException;
	
	/***
	 * Method to check if username exist or not
	 * @param userName
	 * @return true / false
	 * @throws RecordNotFoundException
	 */
	public boolean userNameExists(String userName)throws RecordNotFoundException ;
	
	/***
	 * Method to authenticate user
	 * @param username
	 * @param pwd
	 * @return string
	 * @throws HMAException
	 */
	String AuthenticateUser(String username, String pwd)throws HMAException;
	
	/**
	 * Method to change password
	 * @param username
	 * @param newPassword
	 * @return string
	 * @throws HMAException
	 */
	String changePassword(String username, String newPassword) throws HMAException;
	/**
	 * Method 
	 * @param user_id
	 * @return user
	 * @throws RecordNotFoundException
	 */
	public User getUserById(long user_id)throws RecordNotFoundException;
	

}
