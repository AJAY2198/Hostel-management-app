package com.cg.hms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hms.entity.Warden;

/**
 * Warden service interface defines all services provided for warden
 * @author Aniket
 *
 */
public interface WardenService {
	
	
	/**
	 * Methods for Warden operations
	 * 
	 */
	
	/**
	 * Method to add warden to database
	 * @param warden
	 * @return warden
	 */
	public Warden add(Warden warden);
	/**
	 * Method to update warden data 
	 * @param warden
	 * @return warden
	 */
	public abstract Warden update(Warden warden) ;
	
	/**
	 * Method to delete warden data with matching wardenID
	 * @param wardenId
	 */
	public void delete(long wardenId);
	
	/**
	 * Method to find warden data with matching wardenID
	 * @param wardenId
	 * @return warden
	 */
	public  Warden findByWardenId(long wardenId);
	
	/**
	 * Method to get list of all wardens
	 * @return
	 */
	public List<Warden> getAllWarden();
	
	
	
	
	
}
	
