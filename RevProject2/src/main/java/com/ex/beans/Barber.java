package com.ex.beans;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="BH_BARBERS")
@AttributeOverrides({
	@AttributeOverride(name="userId", column=@Column(name="BARBER_ID")),
	@AttributeOverride(name="firstName", column=@Column(name="BARBER_FNAME")),
	@AttributeOverride(name="lastName", column=@Column(name="BARBER_LNAME")),
	@AttributeOverride(name="userName", column=@Column(name="BARBER_UNAME")),
	@AttributeOverride(name="pasword", column=@Column(name="BARBER_PASSWORD")),
	@AttributeOverride(name="email", column=@Column(name="BARBER_EMAIL")),
	@AttributeOverride(name="xCoordimate", column=@Column(name="BARBER_XCOOR")),
	@AttributeOverride(name="yCoordimate", column=@Column(name="BARBER_YCOOR")),
	@AttributeOverride(name="userRole", column=@Column(name="BARBER_ROLE"))	
})
public class Barber extends HarborUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9216678735514954595L;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="SHOP_ID", nullable = false)
	private Shop shop;
	

}
