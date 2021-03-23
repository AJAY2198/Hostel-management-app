package com.cg.hms.service;

import java.security.Policy;
import java.util.List;

import org.aspectj.weaver.loadtime.Agent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hms.entity.Admin;
import com.cg.hms.entity.Allotment;
import com.cg.hms.entity.Student;
import com.cg.hms.entity.Warden;
import com.cg.hms.exception.HMAException;

/**
 * Admin service interface defines all services provided by admin
 * @author Ajay
 *
 */
public interface AdminService {
	
	/***
	 * Methods for warden
	 */
	
	/***
	 * Method save warden data in database
	 * @param warden
	 * @return warden
	 * @throws HMAException
	 */
	 Warden addWarden(Warden warden) throws HMAException;
	 
	 /***
	  * Method update warden data
	  * @param warden
	  * @return warden
	  * @throws HMAException
	  */
	Warden updateWarden(Warden warden) throws HMAException;
	
	/***
	 * Method delete warden data with matching warden id
	 * @param wardenId
	 * @throws HMAException
	 */
	void deleteWarden(Long wardenId) throws HMAException;
	/***
	 * Method finds warden data with matching warden Id
	 * @param wardenId
	 * @return warden
	 * @throws HMAException
	 */
	Warden getWardenById(Long wardenId) throws HMAException;

	/***
	 * Method returns data for all wardens
	 * @return warden list
	 * @throws HMAException
	 */
	List<Warden> getAllWardens() throws HMAException;
	
	
	/***
	 * Methods for student
	 */
	
	/***
	 * Method add student data to database
	 * @param student
	 * @return student
	 * @throws HMAException
	 */
	 Student addStudent(Student student) throws HMAException;
	/***
	 * Method update student data to database
	 * @param student
	 * @return student
	 * @throws HMAException
	 */
	 Student updateStudent(Student student) throws HMAException;
	
	 /***
	  * Method delete student data of matching student ID
	  * @param studentId
	  * @throws HMAException
	  */
	 void deleteStudent(Long studentId) throws HMAException;
	
	/***
	 * Method returns student sata for matching student ID
	 * @param studentId
	 * @return student
	 * @throws HMAException
	 */
	 Student getStudentById(Long studentId) throws HMAException;
	
	 /***
	  * Method returns data of all students
	  * @return student list
	  * @throws HMAException
	  */
	 List<Student> getAllStudents() throws HMAException;
	
	

	/***
	 * Methods for student
	 */
	 
	/***
	 * Methods add allotment data in database
	 * @param allotment
	 * @return allotment
	 * @throws HMAException
	 */
	Allotment addAllotment(Allotment allotment) throws HMAException;
	/***
	 * Method update allotment data
	 * @param allotment
	 * @return allotment
	 * @throws HMAException
	 */
	Allotment updateAllotment(Allotment allotment) throws  HMAException;
	
	/***
	 * Method deletes allotment data for matching allotmentID  
	 * @param allotmentId
	 * @throws HMAException
	 */
	void deleteAllotment(Long allotmentId) throws  HMAException;
	
	/***
	 * Method get allotment data for matching allotment ID
	 * @param allotmentId
	 * @return allotment
	 * @throws HMAException
	 */
	Allotment getAllotmentById(Long allotmentId) throws  HMAException;
	
	/***
	 * Method returns data of all allotments
	 * @return allotment list
	 * @throws HMAException
	 */
	List<Allotment> getAllAllotments() throws  HMAException;
	
	
}
