package com.cg.hms.service;


import java.util.List;
/**
 * This is a interface for Application with methods of add,update,delete..
 * 
 * @author Ajidevi
 * 
 **/

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hms.entity.Allotment;
import com.cg.hms.entity.Application;

/**
 * Application service interface defines all services provided for application
 * @author Ajidevi
 *
 */
public interface ApplicationService {
	/**
	 * Methods for Allotment operations
	 * 
	 */
	
	/***
	 * Method to add application data
	 * @param application
	 * @return application
	 */
	public Application addApplication(Application application);
	
	/***
	 * Method to update application data
	 * @param application
	 */
	public void updateApplication(Application application);
	
	/***
	 * Method to delete application data
	 * @param application
	 */
	public void deleteApplication(Application application);
	
	/***
	 * Method to find application data with matching application ID
	 * @param applicationId
	 * @return application
	 */
	public Application findByApplicationId(long applicationId);
	
	/***
	 * Method to return a list of all applications
	 * @return application list
	 */
	public List<Application> searchApplication();

	
}


