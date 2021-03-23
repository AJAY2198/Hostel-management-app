package com.cg.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hms.entity.Student;
/**
 * StudentDao extends JpaRepository
 * @author Aniket
 *
 */
public interface StudentDAO extends JpaRepository<Student,Long>{

}
