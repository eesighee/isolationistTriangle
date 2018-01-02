package com.rev.barberharbor.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="SHOPS")
public class Shop implements Serializable{

	private static final long serialVersionUID = -3684529311993553829L;
	
	@Id
	@Column(name="SHOPS_ID")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name="SHOP_SEQ", sequenceName="SHOP_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SHOP_SEQ")
	private Long id;

	@Column(name="NAME")
	private String name;
	
	@Column(name="LATITUDE")
	private double latitude;
	
	@Column(name="LONGITUDE")
	private double longitude;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="WEBSITE")
	private String website;
	
	@Column(name="ADDRESS")
	private String address;
		
	@Column(name="DESCRIPTION")
	private String description;	
	
	@Column(name="HOURS_OF_OPERATION")
	private String hoursOfOperation;

	public Shop() {
		super();
	}

	public Shop(String name, double latitude, double longitude, String phone, String website, String address,
			String description, String hoursOfOperation) {
		super();
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.phone = phone;
		this.website = website;
		this.address = address;
		this.description = description;
		this.hoursOfOperation = hoursOfOperation;
	}

	public Shop(Long id, String name, double latitude, double longitude, String phone, String website, String address,
			String description, String hoursOfOperation) {
		super();
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.phone = phone;
		this.website = website;
		this.address = address;
		this.description = description;
		this.hoursOfOperation = hoursOfOperation;
	}

	public Long getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHoursOfOperation() {
		return hoursOfOperation;
	}

	public void setHoursOfOperation(String hoursOfOperation) {
		this.hoursOfOperation = hoursOfOperation;
	}
	
}
