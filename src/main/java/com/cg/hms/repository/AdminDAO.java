package com.cg.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hms.entity.Admin;
import com.cg.hms.entity.Allotment;
/**
 * AdminDao interface extends JpaRepository 
 * @author Ajay
 *
 */
public interface AdminDAO extends JpaRepository<Admin,Long>{

}
