package com.cg.hms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.hms.entity.Transaction;
import com.cg.hms.exception.HMAException;
import com.cg.hms.exception.RecordNotFoundException;


/**
 * Transaction service interface provides services for transactions.
 * @author Sunny
 *
 */
public interface TransactionService {
	
	/**
	 * Methods for Transaction operations
	 * 
	 */
	
	/***
	 * Method to add transaction data
	 * @param transaction
	 * @return transaction
	 * @throws HMAException
	 */
	public Transaction add(Transaction transaction)throws HMAException;
	
	/**
	 * Method to update transaction data
	 * @param transaction
	 * @return transaction
	 * @throws HMAException
	 */
	public Transaction  update(Transaction transaction)throws HMAException;
	/**
	 * Method to delete transaction data of matching transaction ID
	 * @param transactionId
	 * @return transaction
	 * @throws RecordNotFoundException
	 */
	public Transaction  delete(long transactionId)throws RecordNotFoundException;
	
	/**
	 * Method to find transaction data by given ID
	 * @param transactionId
	 * @return transaction
	 * @throws RecordNotFoundException
	 */
	public Transaction findByTransactionId(long transactionId)throws RecordNotFoundException;
	
	/**
	 * Method to get list of all transactions
	 * @return transaction list
	 * @throws HMAException
	 */
	public List<Transaction> search()throws HMAException;
}
