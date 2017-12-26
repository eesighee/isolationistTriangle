package com.rev.barberharbor.model;

import java.io.Serializable;

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
@Table(name="STYLING_SERVICES")
public class StylingService implements Serializable {

	private static final long serialVersionUID = 5086136653480401301L;

	@Id
	@Column(name="STYLING_SERVICES_ID")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name="S_S_SEQ", sequenceName="S_S_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="S_S_SEQ")
	private Long id;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="PRICE")
	private double price;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="BARBERS_ID")
	private Barber barber;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="SERVICE_TYPES_ID")
	private ServiceType type;
}
