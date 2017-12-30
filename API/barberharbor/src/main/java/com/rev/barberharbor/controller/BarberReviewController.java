package com.rev.barberharbor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rev.barberharbor.model.BarberReview;
import com.rev.barberharbor.service.BarberReviewService;

@RestController
@RequestMapping(value="/barberreview")
public class BarberReviewController {

	@Autowired
	private BarberReviewService service;
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public List<BarberReview> findAllByBarber_Id(@PathVariable long id) {
		return service.findAllByBarber_Id(id);
	}
	
}
