package com.rev.barberharbor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rev.barberharbor.model.Barber;
import com.rev.barberharbor.service.BarberService;

@RestController
@RequestMapping(value="/barber")
public class BarberController {

	@Autowired
	private BarberService service;
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Barber getById(@PathVariable int id) {
		return service.getById(id);
	}
}
