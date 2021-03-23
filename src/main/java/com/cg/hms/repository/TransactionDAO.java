package com.cg.hms.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.hms.entity.Transaction;
/**
 * TransactinDao interface extends JpaRepository
 * @author Sunny
 *
 */
@Repository
public interface TransactionDAO extends JpaRepository<Transaction,Long> { 

}
