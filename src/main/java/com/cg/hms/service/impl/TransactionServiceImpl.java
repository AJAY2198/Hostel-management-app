package com.cg.hms.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cg.hms.entity.Transaction;
import com.cg.hms.exception.HMAException;
import com.cg.hms.exception.RecordNotFoundException;
import com.cg.hms.repository.TransactionDAO;
import com.cg.hms.service.TransactionService;


/***
 * This class implements TransactionService interface from service layer 
 * and implements its methods.
 * @author sunny
 *
 */
@Service
@Transactional
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	private TransactionDAO transactionDao;
	
	@Override
	public Transaction add(Transaction transaction) {
		try {
			return transactionDao.save(transaction);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new HMAException(e.getMessage());
		}
	}

	@Override
	public Transaction update(Transaction transaction) {
		try {
			return transactionDao.save(transaction);
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new HMAException(e.getMessage());
		}
	}

	@Override
	public Transaction delete(long transactionId) {
		try {
			Optional<Transaction> optional= transactionDao.findById(transactionId) ;
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new RecordNotFoundException("Invalid Transaction Id");
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
	public Transaction findByTransactionId(long transactionId) {
		try {
			Optional<Transaction> optional= transactionDao.findById(transactionId) ;
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new RecordNotFoundException("Invalid Transaction Id");
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
	public List<Transaction> search() {
		try {
			return transactionDao.findAll();
		}catch(DataAccessException e) {
			//converting SQLException to EmployeeException
			throw new HMAException(e.getMessage());
		}catch(Exception e) {
			//converting SQLException to EmployeeException
			throw new HMAException(e.getMessage());
		}
	}

}
