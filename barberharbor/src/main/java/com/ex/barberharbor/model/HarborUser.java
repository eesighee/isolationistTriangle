package com.ex.barberharbor.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="BH_USER")
public class HarborUser implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6642676211590376933L;
	
	@Id
	@Column(name="USER_ID")
	@SequenceGenerator(name="USER_SEQ", sequenceName="USER_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_SEQ")
	private Integer userId;
	
	@Column(name="USER_FNAME", nullable=false)
	private String firstName;
	
	@Column(name="USER_LNAME", nullable=false)
	private String lastName;
	
	@Column(name="USER_UNAME", nullable=false)
	private String username;
	
	@Column(name="USER_PASSWORD", nullable=false)
	private String password;
	
	@Column(name="USER_EMAIL", nullable=false)
	private String email;
	
	//private int roleId;
	
	//TODO discuss with group
	@Column(name="USER_XCOOR")
	private Double xCoordinate;
	
	//TODO discuss with group
	@Column(name="USER_YCOOR")
	private Double yCoordinate;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="USER_ROLE", nullable=false)
	private UserRole userRole;
	
	public HarborUser() {
		super();
	}
	
	public HarborUser(String firstName, String lastName, String username, String password, String email,
			double xCoordinate, double yCoordinate, UserRole userRole) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.userRole = userRole;
	}

	public HarborUser(Integer userId, String firstName, String lastName, String username, String password, String email,
			double xCoordinate, double yCoordinate, UserRole userRole) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.userRole = userRole;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(double xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public double getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(double yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "HarborUser [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", email=" + email + ", xCoordinate=" + xCoordinate
				+ ", yCoordinate=" + yCoordinate + ", userRole=" + userRole + "]";
	}
	
	
}
