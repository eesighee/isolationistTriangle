package com.rev.barberharbor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rev.barberharbor.model.Shop;
import com.rev.barberharbor.service.LocationService;

@RestController
@RequestMapping(value="/locate")
public class LocateController {
	
	@Autowired
	private LocationService locServ;
	
	/*
	 *  url: xxxx/locate
	 *  method: POST
	 *  parameters: [user: User]
	 *  returns:  List of Shops ordered by how close the shop is to user
	 */
	@CrossOrigin
	@GetMapping(value="/search/{lat}/{lng}/{max}")
	public List<Shop> locateShopsByLocation(@PathVariable double lat, @PathVariable double lng, @PathVariable double max) {
		//return locServ.findClosestShops(data[0], data[1], data[2]);
		return locServ.getClosestShops(lat, lng, max);
	}	
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET)
	public List<Shop> getShops() {
		return locServ.getAllShops();
	}

}
