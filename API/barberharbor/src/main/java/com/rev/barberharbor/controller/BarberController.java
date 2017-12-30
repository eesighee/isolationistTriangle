package com.rev.barberharbor.controller;

import java.util.List;

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
	public Barber getById(@PathVariable long id) {
		return service.getById(id);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public List<Barber> findAllBarbers() {
		return service.getAllBarbers();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/shop/{id}", method = RequestMethod.GET, produces = "application/json")
	public List<Barber> findAllByShop_Id(@PathVariable long id) {
		return service.findAllByShop_Id(id);
	}
}
