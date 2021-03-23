package com.cg.hms.entity;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="Warden_hma")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
/**
 * Entity class for warden entity
 * @author Aniket
 *
 */
public class Warden{
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="warden_id")
	private long wardenId;
	private String WardenName;
	private String email;
	private long hostelId;
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JsonIgnore
	private Admin admin;
	
	/***
	 * 3 Arg constructor for Warden entity
	 * @param wardenId
	 * @param wardenName
	 * @param user
	 */
	public Warden(long wardenId, String wardenName, User user) {
		super();
		this.wardenId = wardenId;
		WardenName = wardenName;
		this.user = user;
	}
	
	
	
}