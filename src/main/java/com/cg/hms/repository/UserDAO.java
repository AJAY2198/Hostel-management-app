package com.cg.hms.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.hms.entity.User;


/**
 * userDao interface extends JpaRepository 
 * @author Ajay
 *
 */
@Repository
public interface UserDAO extends JpaRepository <User,Long>{

	

	

}
