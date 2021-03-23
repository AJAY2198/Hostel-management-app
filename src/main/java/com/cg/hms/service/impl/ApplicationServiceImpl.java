package com.cg.hms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hms.entity.Application;
import com.cg.hms.exception.DuplicateRecordException;
import com.cg.hms.exception.HMAException;
import com.cg.hms.exception.RecordNotFoundException;
import com.cg.hms.repository.ApplicationDAO;
import com.cg.hms.service.ApplicationService;
/**
 * Application service implementation class emplements all the methods declared in application service interface
 * @author Ajidevi
 *
 */
@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	private ApplicationDAO applicationDAO;

	
	@Override
	public Application addApplication(Application application) throws HMAException {
		try
		{
			return applicationDAO.save(application);
		}
		catch(DataAccessException e)
		{
			throw new HMAException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new HMAException(e.getMessage());
		}

	}
	

	@Override
	public void updateApplication(Application application) throws HMAException{
		try
		{
			applicationDAO.save(application);
		}
		catch(DataAccessException e)
		{
			throw new HMAException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new HMAException(e.getMessage());
		}


	}
	


	@Override
	public void deleteApplication(Application application)throws HMAException {

		try
		{
			applicationDAO.delete(application);
		}
		catch(DataAccessException e)
		{
			throw new HMAException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new HMAException(e.getMessage());
		}
		
		
	}
	
	

	@Override
	public Application findByApplicationId(long applicationId) throws HMAException {

		try{
			Optional<Application> optional=applicationDAO.findById(applicationId);
		
		if(optional.isPresent())
		{
			return optional.get();
		}
		else
		{
			throw new Exception("Invalid Application Id : "+applicationId);
		}
		}
		catch(DataAccessException e)
		{
			throw new HMAException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new HMAException(e.getMessage());
		}
	}
	

	@Override
	public List<Application> searchApplication() throws HMAException {
		try 
		{
		return (List<Application>)applicationDAO.findAll();
		}
		catch(DataAccessException e)
		{
			throw new HMAException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new HMAException(e.getMessage());
		}
	}
	


}