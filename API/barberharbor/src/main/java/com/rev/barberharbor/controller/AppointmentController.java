package com.rev.barberharbor.controller;


import java.io.IOException;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.rev.barberharbor.model.Appointment;
import com.rev.barberharbor.model.AppointmentStatus;
import com.rev.barberharbor.service.AppointmentService;

@RestController
@RequestMapping(value="/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appService;
	
	@CrossOrigin
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Appointment addAppointment(@RequestBody Appointment app) {
		return appService.addAppointment(app);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/complete", method = RequestMethod.POST)
	public Appointment completeAppointment(@RequestBody Long id) {
		Appointment app = appService.getAppointment(id);
		app.setStatus(new AppointmentStatus(2L, "Completed"));
		return appService.updateAppointment(app);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	public Appointment cancelAppointment(@RequestBody Long id) {
		Appointment app = appService.getAppointment(id);
		app.setStatus(new AppointmentStatus(3L, "Cancelled"));
		return appService.updateAppointment(app);
	}
	
}