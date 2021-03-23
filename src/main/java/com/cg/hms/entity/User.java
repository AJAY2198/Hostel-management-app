package com.cg.hms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class for user entity
 * @author Ajay
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="User_hma")
public class User{
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	public long userId;
	public String user_name;
	public String password;
	public String email_id;
	public long contact_no;
	public String address;
	public String role;
	@OneToOne(mappedBy= "user")
	@JsonIgnore
	private Admin admin;
	
	@OneToOne(mappedBy="user")
	@JsonIgnore
	private Warden warden;
	
	@OneToOne(mappedBy="user")
	@JsonIgnore
	private Student student;
	

}

	

	

