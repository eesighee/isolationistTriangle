package com.ex.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="PH_ARTISTS")
public class Artist implements Serializable{
	
	@Id
	@Column(name="ARTIST_ID")
	@SequenceGenerator(name="ARTIST_SEQ", sequenceName="ARTIST_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ARTIST_SEQ")
	private int barberId;
	
	@Column(name="ARTIST_FNAME")
	private String firstName;
	
	@Column(name="ARTIST_LNAME")
	private String lastName;
	
	@Column(name="ARTIST_USRNAME")
	private String username;
	
	@Column(name="ARTIST_PSWRD")
	private String password;
	
	@Column(name="ARTIST_EMAIL")
	private String email;
		
	@Column(name="ARTIST_XCOOR")
	private double xCoordinate;
	
	@Column(name="ARTIST_YCOOR")
	private double yCoordinate;

}
