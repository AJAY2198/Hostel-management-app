
package com.cg.hms.service.impl;


import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hms.entity.Student;
import com.cg.hms.entity.Transaction;
import com.cg.hms.exception.HMAException;
import com.cg.hms.exception.RecordNotFoundException;
import com.cg.hms.repository.StudentDAO;
import com.cg.hms.repository.TransactionDAO;
import com.cg.hms.service.StudentService;

/**
 * Student service implementation class implements all methods declared in student service interface
 * @author Aniket
 *
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDAO studentDao;
	@Autowired
	private TransactionDAO transactionDao;
	
	
	
	
	@Override
	public Student updateStudent(Student student) {
		try {			
			return   studentDao.save(student);
			
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new HMAException(e.getMessage());
		}
	}

	@Override
	public Student getProfile(long student_id) throws RecordNotFoundException {
		try {
			Optional<Student> optional= studentDao.findById(student_id);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new RecordNotFoundException("Invalid StudentID");
			}
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new HMAException(e.getMessage());
		}
	}

	@Override
	public Transaction getTransaction(long transaction_id) throws RecordNotFoundException {
		try {
		Optional<Transaction> transaction= transactionDao.findById(transaction_id);
			if(transaction.isPresent()) {
				return transaction.get();
			}else {
				throw new RecordNotFoundException("Invalid TransactionID");
			}
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new HMAException(e.getMessage());
		}
	}

}
