package com.cg.hms.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hms.entity.Visitor;
import com.cg.hms.exception.HMAException;
import com.cg.hms.exception.RecordNotFoundException;


/**
 * Visitor service interface defines all services provided for visitor
 * @author Deeksha
 *
 */
public interface VisitorService {
	
	/**
	 * Methods for Visitor operations
	 * 
	 */
	/**
	 * Method to add visitor to database
	 * @param visitor
	 * @return visitor
	 */
	public Visitor add(Visitor visitor ) ;
	
	/**
	 * Method to update visitor data
	 * @param visitor
	 * @return visitor
	 */
	public Visitor update(Visitor  visitor ) ;
	
	/**
	 * Method to delete visitor record tith mathicng visitor id
	 * @param visitorId
	 * @throws RecordNotFoundException
	 */
	public void deleteById( long visitorId) throws RecordNotFoundException ;
	/**
	 * Method to find visitor data of given visitor ID
	 * @param visitorId
	 * @return visitor
	 * @throws RecordNotFoundException
	 */
	public Visitor findByVisitorId(long visitorId) throws RecordNotFoundException;
	/**
	 * Method to get list of all visitors
	 * @return visitor list
	 */
	public List<Visitor> search();
	
	
}