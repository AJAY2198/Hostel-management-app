package com.cg.hms.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hms.entity.Allotment;
import com.cg.hms.exception.HMAException;
import com.cg.hms.exception.RecordNotFoundException;
import com.cg.hms.repository.AllotmentDAO;
import com.cg.hms.service.AllotmentService;
/**
 * Allotment service implementation class emplements all the methods declared in allotment service interface
 * @author Komali
 *
 */
@Service
@Transactional
public class AllotmentServiceImpl implements AllotmentService {

	@Autowired
	private AllotmentDAO allotmentDAO;

	@Override
	public Allotment add(Allotment allotment) throws HMAException {
		try
		{
		return allotmentDAO.save(allotment);
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
	public Allotment update(Allotment allotment)throws HMAException {
		try
		{
		  return allotmentDAO.save(allotment);
		}catch(DataAccessException e)
		{
			throw new HMAException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new HMAException(e.getMessage());
		}
	}

	@Override
	public void delete(Allotment allotment) throws HMAException{
		try
		{
		allotmentDAO.delete(allotment);
		}catch(DataAccessException e)
		{
			throw new HMAException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new HMAException(e.getMessage());
		}
	}


	@Override
	public Allotment findByAllotmentId(long allotmentId) throws HMAException {
		
		try
		{
			Optional<Allotment> allotmentOpt = allotmentDAO.findById(allotmentId);
		if (allotmentOpt == null || allotmentOpt.equals(" ")) 
		{
			throw new HMAException("Allotment not found : " + allotmentId);
		}
		     return allotmentOpt.get();
		}catch(DataAccessException e)
		{
			throw new HMAException(e.getMessage());
		}
		catch(Exception e)
		{
			throw new HMAException(e.getMessage());
		}
	}

	@Override
	public List<Allotment> search() throws HMAException {
		try
		{
		return allotmentDAO.findAll();
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
