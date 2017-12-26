package com.rev.barberharbor.model;

import java.io.Serializable;

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
	
	@Column(name="SALES")
	private double sales;
	
	@Column(name="PHONE")
	private String phone;
	
	@Column(name="WEBSITE")
	private String website;
}
