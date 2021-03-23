package com.cg.hms.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hms.entity.Warden;
/**
 * WardentDao extends JpaRepository
 * @author Aniket
 *
 */
@Repository
public interface WardenDAO extends JpaRepository<Warden,Long> {

	//Warden findByWardenName(String wardenName);
	
	
}