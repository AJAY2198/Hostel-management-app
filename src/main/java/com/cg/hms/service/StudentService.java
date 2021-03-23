package com.cg.hms.service;



import com.cg.hms.entity.Student;
import com.cg.hms.entity.Transaction;
import com.cg.hms.exception.HMAException;
import com.cg.hms.exception.RecordNotFoundException;
/**
 * Student service interface defines all services provided for student
 * @author Aniket
 *
 */
public interface StudentService {
	
	/**
	 * Methods for Student operations
	 * 
	 */
	
	/**
	 * Method to update stydent data in database
	 * @param student
	 * @return student
	 */
	public Student updateStudent(Student student);
	
	/**
	 * Method to get data of student with matching student ID
	 * @param student_id
	 * @return student
	 * @throws RecordNotFoundException
	 */
	public  Student getProfile(long student_id) throws RecordNotFoundException;
	
	/**
	 * Method to get transaction with matching transaction ID
	 * @param transaction_id
	 * @return transaction
	 * @throws RecordNotFoundException
	 */
	public Transaction getTransaction(long transaction_id) throws RecordNotFoundException;
	
}
