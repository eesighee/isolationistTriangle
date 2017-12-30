package com.rev.barberharbor.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="APPOINTMENTS")
public class Appointment implements Serializable {

	private static final long serialVersionUID = 4428577253569817632L;

	@Id
	@Column(name = "APPOINTMENTS_ID")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "APT_SEQ", sequenceName = "APT_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APT_SEQ")
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="CUSTOMERS_ID")
	private User customer;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="BARBERS_ID")
	private Barber barber;
	
	@Column(name = "TIME")
	private Date time;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="APPOINTMENTS_SERVICES", 
		joinColumns= @JoinColumn(name="APPOINTMENTS_ID", referencedColumnName="APPOINTMENTS_ID"), 
		inverseJoinColumns=@JoinColumn(name="SERVICES_ID", referencedColumnName="STYLING_SERVICES_ID"))
	private Set<StylingService> services;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="STATUS_ID")
	private AppointmentStatus status;

	public Appointment() {
		super();
	}

	public Appointment(User customer, Barber barber, Date time, AppointmentStatus status) {
		super();
		this.customer = customer;
		this.barber = barber;
		this.time = time;
		this.status = status;
	}

	public Appointment(Long id, User customer, Barber barber, Date time,
			AppointmentStatus status) {
		super();
		this.id = id;
		this.customer = customer;
		this.barber = barber;
		this.time = time;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public Barber getBarber() {
		return barber;
	}

	public void setBarber(Barber barber) {
		this.barber = barber;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Set<StylingService> getServices() {
		return services;
	}

	public void setServices(Set<StylingService> services) {
		this.services = services;
	}

	public AppointmentStatus getStatus() {
		return status;
	}

	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}

	

}