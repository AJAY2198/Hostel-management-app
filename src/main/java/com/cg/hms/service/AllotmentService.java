package com.cg.hms.service;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.cg.hms.entity.Allotment;
import com.cg.hms.exception.RecordNotFoundException;


/**
 * Allotment service interface defines all services provided for allotment
 * @author Komali
 *
 */
public interface AllotmentService {
	
	/**
	 * Methods for allotment operations
	 * 
	 */
	/***
	 * Method add allotment data to database
	 * @param allotment
	 * @return allotment
	 */
	public Allotment add(Allotment allotment);
	
	/***
	 * Method to update allotment data
	 * @param allotment
	 * @return allotment
	 */
	public Allotment update(Allotment allotment);
	
	/***
	 * Method to delete allotment data
	 * @param allotment
	 */
	public void delete(Allotment allotment);
	
	/***
	 * Method to find allotment data with matching allotment ID
	 * @param allotmentId
	 * @return allotment
	 * @throws Exception
	 */
	public Allotment findByAllotmentId(long allotmentId) throws Exception;
	
	/***
	 * Method to return list of all allotments
	 * @return allotment list
	 */
	public List<Allotment> search();
	
}