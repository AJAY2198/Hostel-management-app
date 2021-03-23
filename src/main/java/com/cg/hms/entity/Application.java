package com.cg.hms.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/***
 * Entity class for application entity
 * @author Ajidevi
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Application_hma")
@ToString
public class Application{

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name= "application_id")
	private long applicationId;
	private String firstName;
	private String lastName;
	private LocalDate registrationDate;
	private String qualification;
	private String address;
	private String mobile;
	private Date birthDate;
	private Month duration;
	
	@OneToOne(mappedBy="application")
	@JsonIgnore
	private Allotment allotment;
	
	@OneToMany(mappedBy="application")
	@JsonIgnore
	private Set<Transaction> transactionSet;
	
	@OneToOne(mappedBy="application")
	@JsonIgnore
	private Student student;
	
}