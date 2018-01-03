package com.rev.barberharbor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rev.barberharbor.model.Appointment;
import com.rev.barberharbor.model.Barber;
import com.rev.barberharbor.repository.AppointmentRepo;
import com.rev.barberharbor.repository.UserRepo;

@Service
@Transactional
public class AppointmentService {
	
	@Autowired
	private AppointmentRepo appoints;
	
	@Autowired
	private BarberService barbServ;
	
	//persist a new appoint to database
	public Appointment addAppointment(Appointment appoint) {
		
		return appoints.save(appoint);
	}
	
	//find appointments for a specific customer
	public List<Appointment> findByCustomerID(Long customerID){
		
		return appoints.findByCustomer_Id(customerID);
	}
	
//	public List<Appointment> findByBarberID(Long barberID){
//		return appoints.findByBarber_Id(barberID);
//	}

	//find appointments for specific barbers
//	public List<Appointment> findByBarber_ID(Long barberID){
//		
//		return appoints.findByBarber_Id(barberID);
//	}
	
	//find all appointments for a shop
//	public List<Appointment> findByShop_ID(Long shopID){
//		
//		return appoints.findByBarber_Id(shopID);
//	}
//	
	//find all pending appointments for a shop
	public List<Appointment> findPendingAppointments(Long shopID){
		//get all appointments
		List<Appointment> allAppoints;
		
		// need to implement this function first --> allAppoints = appoints.findByShop_Id(shopID);
		
		//filter for pending appointments and return them
		//not sure how to filter them yet
		List<Appointment> pendingAppoints = null;
		return pendingAppoints;
	}
	
	
}
