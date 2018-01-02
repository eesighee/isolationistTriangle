package com.rev.barberharbor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rev.barberharbor.model.StylingService;
import com.rev.barberharbor.repository.StylingServiceRepo;
import com.rev.barberharbor.service.BarberService;
import com.rev.barberharbor.service.ServiceTypeService;
import com.rev.barberharbor.service.StylingService2;

@RestController
@RequestMapping(value="/service")
public class StylingServiceController {
	
	@Autowired
	StylingServiceRepo ssrepo;

	@Autowired
	private StylingService2 stylingService;
	
	@Autowired
	private ServiceTypeService stService;
	
	@Autowired
	private BarberService bService;
	
	@CrossOrigin
	@RequestMapping(value = "/add", method= RequestMethod.POST)
	public StylingService addBarberService(@RequestBody StylingService service){
		return ssrepo.save(service);
	}
	
}