package com.cg.hms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hms.entity.Allotment;
/**
 * AllotmentDao interface extends JpaRepository 
 * @author Komali
 *
 */
@Repository
public interface AllotmentDAO extends JpaRepository<Allotment,Long> {
	//public String findByUserName(String userName);
}