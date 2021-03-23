package com.capgemini.hms.application;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.hms.application.HostelManagementAppApplication;
import com.cg.hms.entity.User;
import com.cg.hms.exception.DuplicateRecordException;
import com.cg.hms.repository.LoginDAO;
import com.cg.hms.service.LoginService;

@SpringBootTest(classes=HostelManagementAppApplication.class)
  
  public class LoginControllerTest{ 
  private final Integer userId=1; 
  private final String userName="Virat";
  private final String userEmail="virat@gmail.com"; 
  private final String userPassword="virat@123";
  private final long contact_no=191L;
  private final String address="9-B,NGO Colony,Chennai,690001";
  private final String role="student";
  
  
  @Mock
  LoginService loginService;
    
  @Mock
  LoginDAO loginDAO;
  
  @Test
  void testSignUp() throws DuplicateRecordException
  {
	  User user=new User();
	  user.setUserId(1L); 
	  user.setUser_name(userName);
	  user.setEmail_id(userEmail); 
	  user.setPassword(userPassword);
	  user.setContact_no(contact_no);
	  user.setAddress(address);
	  user.setRole(role);
	  String result=loginService.signup(user);
	  verify(loginService, times(1)).signup(user);

	  
  }
  
  @Test void testGetUserById() throws Exception 
  { 
	User user=new User();
  user.setUserId(1L); 
  user.setUser_name(userName);
  user.setEmail_id(userEmail); 
  user.setPassword(userPassword);
  user.setContact_no(contact_no);
  user.setAddress(address);
  user.setRole(role);
  Mockito.when(loginService.getUserById(userId)).thenReturn(user); 
  }
  
  @Test void testChangePassword()
  {
	  User user=new User();
	  user.setUserId(1L); 
	  user.setUser_name(userName);
	  user.setEmail_id(userEmail); 
	  user.setPassword(userPassword);
	  user.setContact_no(contact_no);
	  user.setAddress(address);
	  user.setRole(role);
	  user.setPassword("987654");
	  loginDAO.save(user);
	  assertEquals("987654", user.getPassword());
		
   }
  
  @Test void testAuthenticateUser()
  {
	  User user=new User();
	  user.setUserId(1L); 
	  user.setUser_name(userName);
	  user.setEmail_id(userEmail); 
	  user.setPassword(userPassword);
	  user.setContact_no(contact_no);
	  user.setAddress(address);
	  user.setRole(role);	  
	  
		when(loginService.AuthenticateUser( userName, userPassword)).thenReturn("Validated");
		
		String check = loginService.AuthenticateUser(userName, userPassword);
		verify(loginService, times(1)).AuthenticateUser(userName, userPassword);
		
		assertNotNull(check);
		assertEquals("Validated", check);

  }
 
  
  }
