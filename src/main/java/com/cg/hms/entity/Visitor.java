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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/***
 * Entity class for visitor entity
 * @author Deeksha
 *
 */

@Entity
@Table(name = "Visitor_hma")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class Visitor{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="visitor_id")
	private long visitorId;
	private String visitorName;
	private String contactNo;
	private String address;
	private String relation;
	private String purpose;
	private LocalDate visitingDate;
	@ManyToOne(cascade=CascadeType.ALL)
	@JsonIgnore
	private Student student;

}