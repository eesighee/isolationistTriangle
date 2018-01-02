package com.rev.barberharbor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rev.barberharbor.model.Barber;
import com.rev.barberharbor.model.BarberReview;
import com.rev.barberharbor.model.ServiceType;
import com.rev.barberharbor.model.StylingService;
import com.rev.barberharbor.service.BarberService;
import com.rev.barberharbor.service.ServiceTypeService;
import com.rev.barberharbor.service.StylingService2;

@RestController
@RequestMapping(value="/service")
public class StylingServiceController {

	@Autowired
	private StylingService2 stylingService;
	
	@Autowired
	private ServiceTypeService stService;
	
	@Autowired
	private BarberService bService;
	
	@CrossOrigin
	@RequestMapping(value = "/add", method= RequestMethod.POST)
	public StylingService addBarberService(@RequestBody String[] data){
		System.out.println(data);
		Barber barber = bService.getById(Long.parseLong(data[0]));
		ServiceType type = stService.getById(Long.parseLong(data[3]));
		System.out.println("type @@@@@@@@@@@@@@@@@@@@@@" + type.getType());
		StylingService service = new StylingService(data[1], Double.parseDouble(data[2]), barber, type);
		return stylingService.addBarberService(service);
	}
	
}
