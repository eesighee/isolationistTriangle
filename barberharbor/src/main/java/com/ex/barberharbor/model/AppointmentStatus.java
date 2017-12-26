package com.ex.barberharbor.model;

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
@Table(name="AppointmentStatuses")
public class AppointmentStatus {
	
	@Id
	@Column(name="A_STATUS_ID")
	@SequenceGenerator(name="APPNTMNT_SEQ", sequenceName="APPNTMNT_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="APPNTMNT_SEQ")
	private Integer statusId;
	private String statusName;

}
