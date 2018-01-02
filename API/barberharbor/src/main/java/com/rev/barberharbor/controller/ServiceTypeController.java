package com.rev.barberharbor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rev.barberharbor.model.ServiceType;
import com.rev.barberharbor.service.ServiceTypeService;

@RestController
public class ServiceTypeController {
	
	@Autowired
	ServiceTypeService stservice;
	
	@CrossOrigin
	@GetMapping(value="/servicetype")
	public List<ServiceType> getAll(){
		return stservice.getAll();
	}

}
