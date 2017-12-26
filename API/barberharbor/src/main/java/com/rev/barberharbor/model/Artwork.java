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
@Table(name="ARTWORK")
public class Artwork implements Serializable{

	private static final long serialVersionUID = 7950480741964804253L;
	
	@Id
	@Column(name="ARTWORK_ID")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name="ART_SEQ", sequenceName="ART_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ART_SEQ")
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="BARBERS_ID")
	private Barber barber;
	
	@Column(name="PATH")
	private String picturePath;

}
