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
@Table(name="BARBER_REVIEWS")
public class BarberReview implements Serializable {

	private static final long serialVersionUID = 4891726448236074939L;

	@Id
	@Column(name="BARBER_REVIEWS_ID")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name="B_R_SEQ", sequenceName="B_R_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="B_R_SEQ")
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="BARBER_ID")
	private Barber barber;
	
	@Column(name="RATING")
	private double rating;
	
	@Column(name="COMMENT")
	private String comment;
}
