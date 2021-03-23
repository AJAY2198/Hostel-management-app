package com.cg.hms.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/***
 * Entity class for transaction entity
 * @author Sunny
 *
 */
@Entity
@Table(name="Transaction_hma")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class Transaction{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "transaction_id")
	private long transactionId;	
	private Double totalFee;
	private LocalDate TransactionDate;
	private Double paidFee;
	private Double remainingFee;
	@ManyToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name= "application_id")
	//@JsonIgnore
	private Application application;
	
	
}