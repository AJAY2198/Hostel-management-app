package com.cg.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hms.entity.Application;

/**
 * ApplicationDao interface extends JpaRepository 
 * @author Ajidevi
 *
 */
@Repository
public interface ApplicationDAO extends JpaRepository<Application,Long>
{

	//Application findByUserName(String firstName);
	
}