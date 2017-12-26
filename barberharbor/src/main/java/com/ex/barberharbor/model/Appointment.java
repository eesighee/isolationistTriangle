package com.ex.barberharbor.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="BH_APPOINTMENTS")
public class Appointment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4428577253569817632L;

	@Id
	@Column(name="APPNTMNT_ID")
	@SequenceGenerator(name="APPNTMNT_SEQ", sequenceName="APPNTMNT_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="APPNTMNT_SEQ")
	private Integer appointmentId;
	
	@Column(name="APPNTMNT_DATE", nullable = false)
	private Date date;
	
	@Column(name="APPNTMNT_START", nullable = false)
	private Time startTime;
	
	@Column(name="APPNTMNT_END", nullable = false)
	private Time endTime;
	
	//TODO Make this a  many to many relationship
	@ManyToOne(fetch=FetchType.EAGER) //Many appointment to One StylingService
	@JoinColumn(name="SERVICE_ID", nullable = false)
	private StylingService service;
	
	@ManyToOne(fetch=FetchType.EAGER) //Many appointments to One client
	@JoinColumn(name="CLIENT_ID", nullable = false)
	private HarborUser client;
	
	@ManyToOne(fetch=FetchType.EAGER) //Many appointments to One client
	@JoinColumn(name="STATUS_ID", nullable = false)
	private AppointmentStatus appointmentStatus;
	
	public Appointment() {
		super();
	}

		
	
}
