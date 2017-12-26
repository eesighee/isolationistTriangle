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
@Table(name="APPOINTMENT_STATUS")
public class AppointmentStatus implements Serializable{

	private static final long serialVersionUID = -256656356354475814L;

	@Id
	@Column(name="STATUS_ID")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name="APT_STATIS_SEQ", sequenceName="APT_STATIS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="APT_STATIS_SEQ")
	private Long id;
	
	@Column(name="STATUS")
	private String status;
	
	
	
}
