package com.cg.hms.service.impl;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hms.entity.Admin;
import com.cg.hms.entity.Student;
import com.cg.hms.entity.User;
import com.cg.hms.entity.Warden;
import com.cg.hms.exception.DuplicateRecordException;
import com.cg.hms.exception.HMAException;
import com.cg.hms.exception.InvalidLoginCredentialsException;
import com.cg.hms.exception.RecordNotFoundException;
import com.cg.hms.repository.AdminDAO;
import com.cg.hms.repository.LoginDAO;
import com.cg.hms.repository.StudentDAO;
import com.cg.hms.repository.WardenDAO;
import com.cg.hms.service.LoginService;


@Service
@Transactional
public class LoginServiceImpl implements LoginService{
	Scanner s=new Scanner(System.in);
	@Autowired
	private LoginDAO loginDao;
	@Autowired
	private AdminDAO adminDao;
	@Autowired
	private WardenDAO wardenDao;
	@Autowired
	private StudentDAO studentDao;
	@Override
	public String signup(User user) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		try {			
			loginDao.save(user);
			if(!userNameExists(user.user_name))
			{throw new DuplicateRecordException("Username already exists");}
			else {
				if(user.getRole().toLowerCase().equals("admin"))
				{
					Admin admin=new Admin(user.getUserId(),user.getUser_name(),user);
					adminDao.save(admin);
				}
				else if(user.getRole().toLowerCase().equals("warden"))
				{
					Warden warden= new Warden(user.getUserId(),user.getUser_name(),user);
					wardenDao.save(warden);
				}
				else if(user.getRole().toLowerCase().equals("student"))
				{
					Student student=new Student(user.getUserId(),user.getUser_name(),user);
					studentDao.save(student);
				}
				return "Added!";
			}
		}catch(Exception e) {
			throw new HMAException(e.getMessage());
		}
	}



	@Override
	public String checkUser(long user_id, String password) throws HMAException {
		try {			
			Optional<User> optional = loginDao.findById(user_id);
			if(optional.isPresent()) {
				User temp = optional.get();
				if(temp.getPassword().equals(password)) {
					return "Login Successful";
				}else {
					throw new InvalidLoginCredentialsException("Wrong password");
					//return "Wrong password";
				}
			}else {
				//return "User doesn't exist";
				throw new Exception("User doesn't exit");
			}
		}catch(DataAccessException e) {
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			throw new HMAException(e.getMessage());
		}
	}



	@Override
	public boolean userNameExists(String userName) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		User check = loginDao.findByName(userName);
		if(check!=null)
		{return true;
		} 
		return false;
	}
	@Override
	public String AuthenticateUser(String username, String pwd) throws HMAException {
		// TODO Auto-generated method stub
		try {			
			Optional<User> optional = loginDao.findByUsername(username);
			if(optional.isPresent()) {
				User temp = optional.get();
				if(temp.getPassword().equals(pwd)) {
					return "Login Successful";
				}else {
					//throw new Exception("Wrong password");
					return "Wrong password";
				}
			}else {
				return "User doesn't exist";
				//throw new Exception("User doesn't exit");
			}
		}catch(DataAccessException e) {
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			throw new HMAException(e.getMessage());
		}
	}


	@Override
	public String changePassword(String username, String newPassword) throws HMAException {
		// TODO Auto-generated method stub

		try {			
			Optional<User> optional = loginDao.findByUsername(username);
			if(optional.isPresent()) {
				User user = optional.get();
				user.setPassword(newPassword);
				return "Password changed!";

			}
			else {
				return "Invalid UserName";
				//throw new Exception("Invalid username");
			}
		}catch(DataAccessException e) {
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			throw new HMAException(e.getMessage());
		}
		//finally
		//{ return "Password not changed,Invalid username";}
	}


	@Override
	public User getUserById(long user_id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		try {
			Optional<User> optional= loginDao.findById(user_id);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new RecordNotFoundException("Invalid User no");
			}
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new HMAException(e.getMessage());
		}
	}
}


