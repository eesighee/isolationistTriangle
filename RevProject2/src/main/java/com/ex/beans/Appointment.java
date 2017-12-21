package com.ex.beans;

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
@Table(name="PH_APPOINTMENTS")
public class Appointment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4428577253569817632L;

	@Id
	@Column(name="APPNTMNT_ID")
	@SequenceGenerator(name="APPNTMNT_SEQ", sequenceName="APPNTMNT_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="APPNTMNT_SEQ")
	private int appointmentId;
	
	@Column(name="APPNTMNT_DATE", nullable = false)
	private Date date;
	
	@Column(name="APPNTMNT_START", nullable = false)
	private Time startTime;
	
	@Column(name="APPNTMNT_END", nullable = false)
	private Time endTime;
	
	@OneToMany(fetch=FetchType.EAGER) //One appointment to Many StylingService(s)
	@JoinColumn(name="SERVICE_ID", nullable = false)
	private Set<Integer> services;
	
	@ManyToOne(fetch=FetchType.EAGER) //Many appointments to One client
	@JoinColumn(name="CLIENT_ID", nullable = false)
	private int clientId;
	
	public Appointment() {
		super();
	}

	public Appointment(Date date, Time startTime, Time endTime, Set<Integer> services, int clientId) {
		super();
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.services = services;
		this.clientId = clientId;
	}

	public Appointment(int appointmentId, Date date, Time startTime, Time endTime, Set<Integer> services,
			int clientId) {
		super();
		this.appointmentId = appointmentId;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.services = services;
		this.clientId = clientId;
	}
	
	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public Set<Integer> getservices() {
		return services;
	}

	public void setservices(Set<Integer> services) {
		this.services = services;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", date=" + date + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", services=" + services + ", clientId=" + clientId + "]";
	}
		
	
}
