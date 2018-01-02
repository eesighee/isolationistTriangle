package com.rev.barberharbor.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rev.barberharbor.model.Appointment;
import com.rev.barberharbor.model.Barber;
import com.rev.barberharbor.model.StylingService;
import com.rev.barberharbor.service.AppointmentService;
import com.rev.barberharbor.service.BarberService;
import com.rev.barberharbor.service.StylingService2;

@RestController
@RequestMapping(value="/barber")
public class BarberController {

	@Autowired
	private BarberService service;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private StylingService2 stylingService;
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Barber getById(@PathVariable Long id) {
		return service.getById(id);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public List<Barber> findAllBarbers() {
		return service.getAllBarbers();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/shop/{id}", method = RequestMethod.GET, produces = "application/json")
	public List<Barber> findAllByShop_Id(@PathVariable Long id) {
		return service.findAllByShop_Id(id);
	}

	@CrossOrigin
	@RequestMapping(value= "/{id}/appntmnts", method= RequestMethod.GET)
	public List<Appointment> findAppointsByBarberId(@PathVariable long id){
		return appointmentService.findAllByBarber_Id(id);
	}
	
	@CrossOrigin
	@RequestMapping(value= "/{id}/services", method= RequestMethod.GET)
	public List<StylingService> findStylingServicesByBarberId(@PathVariable long id){
		return stylingService.findStylingServicesByBarber_id(id);
	}
	
	@CrossOrigin
	@RequestMapping(value= "/{id}/services", method= RequestMethod.POST)
	public List<StylingService> addStylingServicesByBarberId(@PathVariable long id){
		return stylingService.findStylingServicesByBarber_id(id);
	}
	
}
