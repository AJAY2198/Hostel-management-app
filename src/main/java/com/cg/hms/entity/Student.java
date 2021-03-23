package com.cg.hms.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity class for student entity
 * @author Aniket
 *
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name="Student_hma")
public class Student {
     @Id
   //   @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name="student_id")
	private long studentId;
	private String student_Name;
	private String email;
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	@OneToOne(cascade= CascadeType.ALL)
	//@JoinColumn(name="application_id")
	private Application application;
	@ManyToOne(cascade= CascadeType.ALL)
	@JsonIgnore
	private Admin admin;
	@OneToMany(mappedBy="student")
	@JsonIgnore
	private Set<Visitor> visitor;
	
	/***
	 * 3 Arg constructor for Student entity
	 * @param studentId
	 * @param student_Name
	 * @param user
	 */
	public Student(long studentId, String student_Name, User user) {
		super();
		this.studentId = studentId;
		this.student_Name = student_Name;
		this.user = user;
	}
	
}