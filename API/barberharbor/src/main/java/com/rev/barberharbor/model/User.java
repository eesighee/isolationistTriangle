package com.rev.barberharbor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="USERS")
public class User implements Serializable{

	private static final long serialVersionUID = 8148563436384263702L;
	
	@Id
	@Column(name="USERS_ID")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name="USER_SEQ", sequenceName="USER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_SEQ")
	private Long id;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="FNAME")
	private String fname;
	
	@Column(name="LNAME")
	private String lname;
	
	@Column(name="EMAIL")
	private String email;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="USER_ROLES_ID")
	private UserRole role;

}
