package com.rev.barberharbor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rev.barberharbor.model.Appointment;
import com.rev.barberharbor.repository.AppointmentRepo;


@RestController
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private AppointmentRepo appointServ;
	
	//@Autowired private ArtworkCommentService ArtworkCommentServ;
	
	
	@CrossOrigin
	@RequestMapping(value="/addAppointment",method=RequestMethod.POST)
	public Appointment addAppointment(@RequestBody Appointment appoint) {
		
		
		return appointServ.save(appoint);
		
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public List<Appointment> findApppointments(@PathVariable Long id) {
		return appointServ.findByCustomer_Id(id);		
	}
	
//	@CrossOrigin
//	@RequestMapping(value="/findComments",method=RequestMethod.POST)
//	public List<ArtworkComment> findAppointments(@RequestBody String[] data){
//		return ArtworkCommentServ.findByUser_Id(Long.parseLong(data[0]));
//	}
	
}