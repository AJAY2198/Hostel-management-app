package com.cg.hms.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hms.entity.User;
import com.cg.hms.entity.Visitor;
import com.cg.hms.exception.HMAException;
import com.cg.hms.exception.RecordNotFoundException;
import com.cg.hms.repository.VisitorDAO;
import com.cg.hms.service.VisitorService;

import java.util.Optional;

/***
 * This class implements VisitorService interface from service layer 
 * and implements its methods.
 * @author Deeksha
 *
 */
@Service
@Transactional
public class VisitorServiceImpl implements VisitorService{
 
	@Autowired
	private VisitorDAO visitorDAO;
	
	
	@Override
	public Visitor add(Visitor visitor) {
		try {			
			return visitorDAO.save(visitor);
		}catch(DataAccessException e) {


			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			
			throw new HMAException(e.getMessage());
		}
	}

	@Override
	public Visitor update(Visitor visitor) {
		try {			
			return visitorDAO.save(visitor);
		}catch(DataAccessException e) {


			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			
			throw new HMAException(e.getMessage());
		}
	}

	@Override
	public void deleteById( long visitorId) throws RecordNotFoundException {
		try {			
			 visitorDAO.deleteById(visitorId);;
		}catch(DataAccessException e) {
			
			throw new RecordNotFoundException(e.getMessage());
		}catch(Exception e) {
			
			throw new HMAException(e.getMessage());
		}
		
	}

//	@Override
//	public Visitor findByName(String visitorName) {
//		try {			
//			Visitor visitor= visitorDAO.findByName(visitorName);
//			if(visitor==null) {
//				throw new Exception("Invalid VisitorName");
//			}else {
//				return visitor;
//			}
//		}catch(DataAccessException e) {
//			
//			throw new HMAException(e.getMessage());
//		}catch(Exception e) {
//			
//			throw new HMAException(e.getMessage());
//		}
//	}

	@Override
	public Visitor findByVisitorId(long visitorId) throws RecordNotFoundException{
		try {
			Optional<Visitor> optional= visitorDAO.findById(visitorId);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new RecordNotFoundException("Invalid Visitor Id");
			}
		}catch(DataAccessException e) {
			
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
						throw new HMAException(e.getMessage());
		}
	}

	@Override
	public List<Visitor> search() {
		try {			
			 return visitorDAO.findAll();
		}catch(DataAccessException e) {
			
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			
			throw new HMAException(e.getMessage());
		}
	}

}