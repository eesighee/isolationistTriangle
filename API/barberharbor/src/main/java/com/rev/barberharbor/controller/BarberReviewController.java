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
import com.rev.barberharbor.model.Barber;
import com.rev.barberharbor.service.BarberReviewService;
import com.rev.barberharbor.service.BarberService;

@RestController
@RequestMapping(value="/barberreview")
public class BarberReviewController {

	@Autowired
	private BarberReviewService rService;
	
	@Autowired
	private BarberService bService;
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public List<BarberReview> findAllByBarber_Id(@PathVariable Long id) {
		return rService.findAllByBarber_Id(id);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
	public Barber getBarberByBarber_Id(@PathVariable Long id) {
		return bService.getById(id);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public BarberReview addBarberReview(@RequestBody String[] data) {
		Barber barber = bService.getById(Long.parseLong(data[0]));
		BarberReview review = new BarberReview(barber, Double.parseDouble(data[1]), data[2]);
		return rService.addBarberReview(review);
	}
	
}
