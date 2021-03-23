package com.cg.hms.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * Entity class for allotment entity
 * @author Komali
 *
 */
@Entity
@Table(name="Allotment_hma")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Allotment  {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Column(name= "allotment_id")
	private long allotmentId;
	private String hostelName;
	private String roomType;
	private String roomNo;
	private LocalDate allotmentStartDate;
	private LocalDate allotmentEndDate;
	@ManyToOne(cascade= CascadeType.ALL)
	@JsonIgnore
	private Admin admin;
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="application_id")
	private Application application;
	
}